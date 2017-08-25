package com.sridhar.product.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sridhar.product.Product;
import com.sridhar.product.bo.ProductServiceBO;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		Integer price=Integer.parseInt(request.getParameter("price"));
		
		Product p=new Product();
		
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ProductServiceBO bean = (ProductServiceBO) context.getBean("productBO");
		bean.createProduct(p);
		
		PrintWriter out = response.getWriter();
		out.println("new product created!!");
		
	}

}
