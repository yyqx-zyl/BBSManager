package com.bbs.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.service.user.CrudsService;
import com.bbs.service.user.impl.CrudsImplService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    	//创建一个操作用户的业务对象类
    
  	private CrudsService cr=new CrudsImplService();
  	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		//获得页面数据
		String userId=req.getParameter("userid");
		String userpsw=req.getParameter("userpsw");
		//调用业务层中的方法
		boolean isOk=cr.verification(userId, userpsw);
		//跳转
		if (isOk) {
			req.getSession().setAttribute("userId",userId);
			req.getRequestDispatcher("UserServlet?op=index").forward(req, resp);
		}else {
			//回到登录页面
			req.getRequestDispatcher("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
