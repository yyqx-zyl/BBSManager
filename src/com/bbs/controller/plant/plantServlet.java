package com.bbs.controller.plant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.entity.bbs_plate;
import com.bbs.service.plant.plantService;
import com.bbs.service.plant.impl.plantServiceImpl;

/**
 * Servlet implementation class plantServlet
 */
@WebServlet("/plant")
public class plantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private plantService ps=new plantServiceImpl();
	private bbs_plate plant=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public plantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//获得客户端传递的参数值
		String op=req.getParameter("op");
		if ("Add".equals(op)) {
			//添加
			Add(req,resp);
		}else if ("showAll".equals(op)) {
			showAll(req,resp);
		}else if ("findeByid".equals(op)) {
			findeByid(req,resp);
		}else if("updata".equals(op)) {
			updata(req,resp);
		}else if("deletById".equals(op)) {
			deletById(req,resp);
		}else if("scach".equals(op)) {
			scach(req,resp);
		}
		
	}
	//搜索
	private void scach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获得页面的值
		String plateTitle=req.getParameter("plateTitle");
		System.out.println(plateTitle);
		//调用方法
		List<bbs_plate> plants=ps.scach(plateTitle);
		
		req.setAttribute("plant",plants);
		req.getRequestDispatcher("server/plant-list.jsp").forward(req, resp);
	}

	//根据id删除
	private void deletById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取id值
		int plateId=Integer.parseInt(req.getParameter("plateId"));
		System.out.println(plateId);
		//调用方法
		boolean isOk=ps.deletById(plateId);
		PrintWriter out=resp.getWriter();
		if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
	}


	//修改
	private void updata(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取页面数据
		int plateId=Integer.parseInt(req.getParameter("plateId"));
		String plateTitle=req.getParameter("plateTitle");
		String plateMessage=req.getParameter("plateMessage");
		int isEnable=Integer.parseInt(req.getParameter("isEnable"));
		
		System.out.println(plateId+","+plateTitle+","+plateMessage+","+isEnable);
		//创建实体类对象
		plant=new bbs_plate(plateId,plateTitle, plateMessage, isEnable);
		//调用方法，保存数据
		boolean isOk=ps.updata(plant);
		PrintWriter out = resp.getWriter();
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}

	//根据id查询
	private void findeByid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//获取页面数据
			String plateId=req.getParameter("plateId");
			//调用应用层数据
			List<bbs_plate> plant=ps.findeByid(plateId);
			System.out.println(plateId);
			//返回数据
			req.setAttribute("plant",plant);
			req.getRequestDispatcher("server/plant-edit.jsp").forward(req, resp);
	}

	//显示所有
	private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<bbs_plate> plant=ps.showAll();
		req.setAttribute("plant",plant);
		req.getRequestDispatcher("server/plant-list.jsp").forward(req, resp);
	}

	//添加
	private void Add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//设置响应的文件类型
		resp.setContentType("aplication/json;charset=UTF-8");
		//获取页面数据
		String plateTitle=req.getParameter("plateTitle");
		String plateMessage=req.getParameter("plateMessage");
		System.out.println(plateTitle+"    "+plateMessage);
		PrintWriter out = resp.getWriter();
		plant=new bbs_plate(plateTitle,plateMessage);
		boolean isOk=ps.savePlant(plant);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
