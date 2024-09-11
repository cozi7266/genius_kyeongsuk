package com.ssafy.servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public abstract class MyServlet implements Servlet {
	@Override
	public void destroy() {}
	@Override
	public ServletConfig getServletConfig() {return null;}
	@Override
	public String getServletInfo() {return null;}
	@Override
	public void init(ServletConfig arg0) throws ServletException {}
	public abstract void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException;
}
