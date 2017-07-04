import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
        //对request和response进行一些预处理
		HttpServletResponse hp = (HttpServletResponse)response;
		HttpServletRequest hr = (HttpServletRequest)request;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = hr.getSession();
        if(session.getAttribute("Session_name") != null) {
        	chain.doFilter(request, response);
        } else {
        	hp.sendRedirect("../RFID");
        }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
//		System.out.println("----过滤器初始化----");
        //得到过滤器的名字
//        String filterName = filterConfig.getFilterName();
        //得到在web.xml文件中配置的初始化参数
/*        String initParam1 = filterConfig.getInitParameter("name");
        String initParam2 = filterConfig.getInitParameter("like");*/
        //返回过滤器的所有初始化参数的名字的枚举集合。
        //Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        
/*        System.out.println(filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);*/
        /*while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }*/
	}
}


  /*<filter>
      <filter-name>Filter</filter-name>
      <filter-class>MyFilter</filter-class>
  </filter>
  <filter-mapping>
      <filter-name>Filter</filter-name>
      <url-pattern>/index.jsp</url-pattern>
  </filter-mapping>*/




