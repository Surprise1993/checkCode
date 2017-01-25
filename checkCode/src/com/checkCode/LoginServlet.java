package com.checkCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String piccode = (String)req.getSession().getAttribute("piccode");
		String checkcode = req.getParameter("checkcode").toUpperCase();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		if (piccode.equals(checkcode)) {
			out.print("验证成功！");
		} else {
			out.print("验证失败！！！！！！");
		}
		out.flush();
		out.close();
	}

}
