package com.bbs.controller.invitation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.bbs_category;
import com.bbs.entity.bbs_invitation;
import com.bbs.service.invitation.invitationService;
import com.bbs.service.invitation.impl.invitationServiceImpl;

/**
 * Servlet implementation class category
 */
@WebServlet("/invitation")
public class invitationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public invitationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //调用service方法
    private invitationService is=new invitationServiceImpl() ;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//获得op数据
		String op=req.getParameter("op");
		
		//进入方法
		if ("showAll".equals(op)) {
			System.out.println("All");
			showAll(req,resp);
		}else if ("Add".equals(op)) {
			Add(req,resp);
		}else if ("".equals(op)) {
			//(req,resp);
		}else if ("".equals(op)) {
			//(req,resp);
		}else if ("".equals(op)) {
			//(req,resp);
		}else if ("".equals(op)) {
			//(req,resp);
		}
	}
	//添加
    private void Add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获得页面数据
    	String invitationMessage = req.getParameter("invitationMessage");
		int plantId =Integer.parseInt(req.getParameter("plateId")) ;
		int categoryId =Integer.parseInt(req.getParameter("categoryId")) ;
		String userId=req.getParameter("userId");
		
		System.out.println(invitationMessage+","+plantId+","+categoryId);
		
		//获得系统时间
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invitationId = userId+format.format(date);
		System.out.println(invitationId);
		//String dates=format.format(date);
		
		//创建实体类对象
		bbs_invitation invi = new bbs_invitation(invitationId, invitationMessage, userId, plantId, categoryId);
    	//调用添加方法
		boolean isOk=is.add(invi);
		PrintWriter out=resp.getWriter();
    	//返回到页面的数据，提示成功或失败
    	if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
	}
	//显示所有信息
	private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获得数据
		List<bbs_invitation> invi= is.showAll();
		
		req.setAttribute("invi",invi);
		req.getRequestDispatcher("server/invitation-list.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
