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
    	//����һ�������û���ҵ�������
    
  	private CrudsService cr=new CrudsImplService();
  	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		//���ҳ������
		String userId=req.getParameter("userid");
		String userpsw=req.getParameter("userpsw");
		//����ҵ����еķ���
		boolean isOk=cr.verification(userId, userpsw);
		//��ת
		if (isOk) {
			req.getSession().setAttribute("userId",userId);
			req.getRequestDispatcher("UserServlet?op=index").forward(req, resp);
		}else {
			//�ص���¼ҳ��
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
