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
    //����service����
    private invitationService is=new invitationServiceImpl() ;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ַ�
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//���op����
		String op=req.getParameter("op");
		
		//���뷽��
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
	//���
    private void Add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// ���ҳ������
    	String invitationMessage = req.getParameter("invitationMessage");
		int plantId =Integer.parseInt(req.getParameter("plateId")) ;
		int categoryId =Integer.parseInt(req.getParameter("categoryId")) ;
		String userId=req.getParameter("userId");
		
		System.out.println(invitationMessage+","+plantId+","+categoryId);
		
		//���ϵͳʱ��
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invitationId = userId+format.format(date);
		System.out.println(invitationId);
		//String dates=format.format(date);
		
		//����ʵ�������
		bbs_invitation invi = new bbs_invitation(invitationId, invitationMessage, userId, plantId, categoryId);
    	//������ӷ���
		boolean isOk=is.add(invi);
		PrintWriter out=resp.getWriter();
    	//���ص�ҳ������ݣ���ʾ�ɹ���ʧ��
    	if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
	}
	//��ʾ������Ϣ
	private void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�������
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
