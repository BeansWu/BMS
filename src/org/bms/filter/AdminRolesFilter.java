package org.bms.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminRolesFilter
 */
@WebFilter(
		description = "拦截没有权限的管理员访问请求", 
		urlPatterns = { 
				"/AdminRolesFilter", 
				"/admin/sys-set", 
				"/admin/reader-mgt", 
				"/admin/book-mgt", 
				"/admin/book-borrow-return", 
				"/admin/sys-search"
		})
public class AdminRolesFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminRolesFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		@SuppressWarnings("unchecked")
		Map<String, Boolean> roles = (Map<String, Boolean>) session.getAttribute("roles");
		String uri = req.getRequestURI();
		
		if (uri.indexOf("sys-set") != -1) {
			if (roles.get("sysSet")) {
				chain.doFilter(request, response);
				return;
			}
		} else if (uri.indexOf("book-mgt") != -1) {
			if (roles.get("bookMgt")) {
				chain.doFilter(request, response);
				return;
			}
		} else if (uri.indexOf("reader-mgt") != -1) {
			if (roles.get("readerMgt")) {
				chain.doFilter(request, response);
				return;
			}
		} else if (uri.indexOf("book-borrow-return") != -1) {
			if (roles.get("bookBorrowAndReturn")) {
				chain.doFilter(request, response);
				return;
			}
		} else if (uri.indexOf("sys-search") != -1) {
			if (roles.get("sysSearch")) {
				chain.doFilter(request, response);
				return;
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
