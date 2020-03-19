package com.bbs.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.bbs_category;
import com.bbs.entity.bbs_plate;
import com.bbs.service.plant.plantService;
import com.bbs.service.plant.impl.plantServiceImpl;
import com.bbs.service.user.UserService;
import com.bbs.service.user.impl.UserServiceImpl;

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
    
  	private UserService cr=new UserServiceImpl();
  	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		//获得页面数据
		String userId=req.getParameter("userid");
		String userpsw=req.getParameter("userpsw");
		
		//调用业务层中验证登录的方法
		boolean isOk=cr.verification(userId, userpsw);
		//跳转
		if (isOk) {
			plantService ps=new plantServiceImpl();
			
			List<bbs_plate> plist=ps.showAll();
			List<bbs_category> clist=ps.showCall();
			req.getSession().setAttribute("clist",clist);
			req.getSession().setAttribute("plist",plist);
			
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
