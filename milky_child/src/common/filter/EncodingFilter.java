package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * init - doFilter - destroy
 * 
 * filterChain: 여러필터를 모아서 연속 처리할 수 있도록 한 객체
 *
 */
public class EncodingFilter implements Filter{
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("EncodingFilter.init()");
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//공통 인코딩 처리
		request.setCharacterEncoding("utf-8");
		System.out.println("request : [utf-8]으로 인코딩 처리함");
		
		//필터체인에 연결된 다음 filter의 doFilter를 호출
		//다음 필터가 없다면, Servlet을 호출함.
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFilter.destroy()");		
	}

	
}
