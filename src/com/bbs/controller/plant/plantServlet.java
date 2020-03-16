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
		//�����ַ�
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//��ÿͻ��˴��ݵĲ���ֵ
		String op=req.getParameter("op");
		if ("Add".equals(op)) {
			//���
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
	//����
	private void scach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//���ҳ���ֵ
		String plateTitle=req.getParameter("plateTitle");
		System.out.println(plateTitle);
		//���÷���
		List<bbs_plate> plants=ps.scach(plateTitle);
		
		req.setAttribute("plant",plants);
		req.getRequestDispatcher("server/plant-list.jsp").forward(req, resp);
	}

	//����idɾ��
	private void deletById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//��ȡidֵ
		int plateId=Integer.parseInt(req.getParameter("plateId"));
		System.out.println(plateId);
		//���÷���
		boolean isOk=ps.deletById(plateId);
		PrintWriter out=resp.getWriter();
		if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
	}


	//�޸�
	private void updata(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//��ȡҳ������
		int plateId=Integer.parseInt(req.getParameter("plateId"));
		String plateTitle=req.getParameter("plateTitle");
		String plateMessage=req.getParameter("plateMessage");
		int isEnable=Integer.parseInt(req.getParameter("isEnable"));
		
		System.out.println(plateId+","+plateTitle+","+plateMessage+","+isEnable);
		//����ʵ�������
		plant=new bbs_plate(plateId,plateTitle, plateMessage, isEnable);
		//���÷�������������
		boolean isOk=ps.updata(plant);
		PrintWriter out = resp.getWriter();
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}

	//����id��ѯ
	private void findeByid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//��ȡҳ������
			String plateId=req.getParameter("plateId");
			//����Ӧ�ò�����
			List<bbs_plate> plant=ps.findeByid(plateId);
			System.out.println(plateId);
			//��������
			req.setAttribute("plant",plant);
			req.getRequestDispatcher("server/plant-edit.jsp").forward(req, resp);
	}

	//��ʾ����
	private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<bbs_plate> plant=ps.showAll();
		req.setAttribute("plant",plant);
		req.getRequestDispatcher("server/plant-list.jsp").forward(req, resp);
	}

	//���
	private void Add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//������Ӧ���ļ�����
		resp.setContentType("aplication/json;charset=UTF-8");
		//��ȡҳ������
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
