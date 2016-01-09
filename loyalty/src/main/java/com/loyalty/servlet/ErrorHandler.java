package com.loyalty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loyalty.exception.CustomGenericException;

// Extend HttpServlet class
public class ErrorHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		
		// Analyze the servlet exception
		Throwable throwable = (Throwable) request
				.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request
				.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request
				.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}

		// Set response content type
		response.setContentType("text/html");

		if (throwable == null && statusCode == null) {
			msg += "<h2>Error information is missing</h2>";
		} else if (statusCode != null) {
			msg += "The status code : " + statusCode;
		} else {
			msg += "<h2>Error information</h2>";
			msg += "Servlet Name : " + servletName + "</br></br>";
			msg += "Exception Type : " + throwable.getClass().getName()
					+ "</br></br>";
			msg += "The request URI: " + requestUri + "<br><br>";
			msg += "The exception message: " + throwable.getMessage();
		}
		
		CustomGenericException custEx = new CustomGenericException(statusCode.toString(), msg.toString());
		
		ServletContext context = getServletContext();
	    RequestDispatcher dispatcher = context.getRequestDispatcher("/error");
	    request.setAttribute("customGenericException", custEx);
	    dispatcher.forward(request,response);
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
