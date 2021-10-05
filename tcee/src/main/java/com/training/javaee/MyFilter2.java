package com.training.javaee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter1
 */
@WebFilter("/myservlet")
public class MyFilter2 implements Filter {

    /**
     * Default constructor.
     */
    public MyFilter2() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2 çalıştı");
        String parameterLoc = request.getParameter("name");
        if (parameterLoc == null) {
            response.getWriter()
                    .print("name parametresiz giriş yok.");
        } else {
            if (parameterLoc.equals("ali")) {
                response.getWriter()
                        .print("ali giremez.");
            } else {
                chain.doFilter(request,
                               response);
            }
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(final FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
