package com.snsoft.ElectricHeating.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.ElectricHeating.utils.AllConstant;
import com.snsoft.ElectricHeating.utils.JWTUtil;
import com.snsoft.ElectricHeating.utils.JsonUtil;
import com.snsoft.ElectricHeating.utils.KeyPairUtil;
import com.snsoft.ElectricHeating.utils.SecretKeyUtil;

/**
 * @author 16计算机 Moriaty
 * @version 1.0
 * @copyright ：Moriaty 版权所有 © 2019
 * @date 2019/6/17 19:41
 * @Description TODO JWT 过滤器，用于处理登录
 */
public class JWTProcessingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 转化ServletRequest为HttpRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		try {
			if (req.getServletPath().equals("/login") && req.getMethod().equals("POST")) {
				// 登录接口
				chain.doFilter(req, resp);
			} else if (req.getServletPath().equals("/register") && req.getMethod().equals("POST")) {
				chain.doFilter(req, resp);
			} else {
				// 非登录接口
				// 使用私钥解密，比对
				String plaintext = JWTUtil.getPlaintext(req, "plaintext");
				String ciphertext = JWTUtil.getPlaintext(req, "ciphertext");
				if (plaintext != null && ciphertext != null) {
					String decrypt = SecretKeyUtil.decrypt(ciphertext, KeyPairUtil.PRIVATE_KEY);
					if (decrypt.equals(plaintext)) {
						chain.doFilter(req, resp);
					} else {
						resp.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "请先登录1"));
					}
				} else {
					resp.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "请先登录"));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(JsonUtil.jsonResponse(null, AllConstant.CODE_ERROR, "服务器发生错误"));
		}

	}

	@Override
	public void destroy() {

	}
}
