package com.huihui.sms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huihui.sms.service.StaffServiceImpl;

/**
 * Servlet implementation class getFestivalInf
 */
@WebServlet("/getFestivalInf")
public class getFestivalInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1。设置编码
		request.setCharacterEncoding("UTF-8");
		//2.获取参数
		String festivalBenedictionSms=request.getParameter("festivalBenedictionSms");
		festivalBenedictionSms="【太原工业学院】"+festivalBenedictionSms;
		System.out.println(festivalBenedictionSms+"iiiiiiii");
		//3.调用service层
		StaffServiceImpl staffService=new StaffServiceImpl();
				try {
					staffService.sendFestival(festivalBenedictionSms);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		//4.默认路径的跳转，登录成功后跳转到index.jsp页面
		String url="/index.jsp";
		//5.跳转到页面
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
