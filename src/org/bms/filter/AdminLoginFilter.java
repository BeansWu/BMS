package org.bms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
@WebFilter(description = "拦截未登录用户访问", urlPatterns = { "/AdminLoginFilter" }, initParams = {
		@WebInitParam(name = "commonURL", value = ".js;.css;login;logout"),
		@WebInitParam(name = "charset", value = "utf-8") }, servletNames = { "springDispatcher" })
public class AdminLoginFilter implements Filter {

	// 初始化参数
	private FilterConfig config;

	/**
	 * Default constructor.
	 */
	public AdminLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String commonURL = config.getInitParameter("commonURL");
		String[] commonURLArray = commonURL.split(";");
		String uri = req.getRequestURI();

		for (String str : commonURLArray) {
			if (str == null || str.equals("")) {
				continue;
			}
			if (uri.indexOf(str) != -1) {
				chain.doFilter(request, response);
				return;
			}
		}

		Integer adminId = (Integer) session.getAttribute("adminId");
		if (adminId != null && !adminId.equals("")) {
			chain.doFilter(request, response);
			return;
		} else {
			resp.sendRedirect(req.getContextPath() + "/views/admin/login.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
