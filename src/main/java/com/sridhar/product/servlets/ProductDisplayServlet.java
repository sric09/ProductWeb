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
 * Servlet implementation class ProductDisplayServlet
 */
public class ProductDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ProductServiceBO bean = (ProductServiceBO) context.getBean("productBO");
		Product p=bean.fetchProduct(Integer.parseInt(request.getParameter("id")));
		
		PrintWriter out = response.getWriter();
		
		out.println("--- Product Details ---");
		out.println("Product Id: "+p.getId());
		out.println("Product Name: "+p.getName());
		out.println("Product Price: "+p.getPrice());
		
	}

}
