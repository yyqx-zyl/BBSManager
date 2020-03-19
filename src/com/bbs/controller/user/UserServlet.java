package com.bbs.controller.user;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bbs.entity.bbs_user;
import com.bbs.service.user.UserService;
import com.bbs.service.user.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //调用方法
  		UserService cr=new UserServiceImpl();
  		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		//获取页面数据
		String op=req.getParameter("op");
		if ("show".equals(op)) {
			show(req,resp);
		}else if("index".equals(op)) {
			index(req,resp);
		}else if("Add".equals(op)) {
			Add(req,resp);
		}else if("delete".equals(op)) {
			delete(req,resp);
		}else if("showID".equals(op)) {
			showID(req,resp);
		}else if("xiu".equals(op)) {
			xiu(req,resp);
		}else if("delAll".equals(op)) {
			delAll(req,resp);
		}else if ("finduser".equals(op)) {
			finduser(req,resp);
		}else if ("loginOut".equals(op)) {
			loginOut(req,resp);
		}
		
	}
	//退出登录
	private void loginOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 清除保存在session中的用户名
				req.getSession().removeAttribute("userId");
				resp.sendRedirect("login.jsp");
	}
	//登录用户的信息显示
	private void finduser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String userId = req.getParameter("userId");
		List<bbs_user> users=cr.show(userId);
		if(users != null) {
			req.getSession().setAttribute("user", users);
			resp.sendRedirect("server/member-edit.jsp");
		}	
	}
	//主页面显示
	private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		List<bbs_user> user=null;
		user=cr.show();
		req.getSession().setAttribute("user", user);
		req.getRequestDispatcher("/server/index.jsp").forward(req, resp);
		
	}
	//批量删除
	private void delAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String userIds=req.getParameter("userIds");
		PrintWriter  out=resp.getWriter();
		boolean isOk=cr.delAll(userIds);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
		
	}

	//修改
	private void xiu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
				//获取页面数据
				String userId=req.getParameter("userId");
				String userPsw=req.getParameter("userPsw");
				String userEmail=req.getParameter("userEmail");
				String userSex=req.getParameter("userSex");
				
				System.out.println(userId+","+userPsw+","+userEmail+","+userSex);
				//创建用户表对象
				bbs_user user=new bbs_user();
				user.setUserId(userId);
				user.setUserPsw(userPsw);
				user.setUserEmail(userEmail);
				user.setUserSex(userSex);
				
				
				
				PrintWriter out = resp.getWriter();
				boolean isOk=cr.cha(user);
				if(isOk) {
					out.write("true");
				}else{
					out.write("true");
				}
				out.flush();
	}

	
	//根据id名查询用户信息
	private void showID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取页面信息
		String userId=req.getParameter("id");
		
		List<bbs_user> users=cr.show(userId);
		req.setAttribute("user",users);
		
		req.getRequestDispatcher("server/member-edit.jsp").forward(req, resp);
	}

	
	//显示
	private void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<bbs_user> users=cr.show();
		req.setAttribute("user",users);
		req.getRequestDispatcher("server/member-list.jsp").forward(req, resp);
	}
	
	
	//添加
	private void Add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String userEmail = null;
			String userId = null;
			String userPsw = null;
			String userSex = null;
			String userPhoto = null;
			// 获得文件上传的路径getServletContext().getRealPath("/file");
			String filePath = this.getServletContext().getRealPath("/static/file");
			// 查看是否是ServletFileUpload
			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory); // 获得表单中的所有请求 限制10M
				upload.setFileSizeMax(10 * 1024 * 1024);
				try {
					List<FileItem> items = upload.parseRequest(req); // 遍历所有的请求
					Iterator<FileItem> it = items.iterator();
					while (it.hasNext()) { // 取出元素对象
						FileItem item = it.next();
						// 判断是否是普通的表单元素
						if (item.isFormField()) {
							String name = item.getFieldName();// 得到表单中的值
							switch (name) {
							case "userEmail":
								userEmail = item.getString("UTF-8");
								break;
							case "userId":
								userId = item.getString("UTF-8");
								break;
							case "userPsw":
								userPsw = item.getString("UTF-8");
								break;
							case "userSex":
								userSex = item.getString("UTF-8");
								break;
							}
						} else {
							userPhoto = item.getName();
							// 设置一个上传文件的对象
							File saveFile = new File(filePath, userPhoto);
							item.write(saveFile);
						}
					}
					System.out.println(userId+""+userPsw+""+userEmail+""+userSex+""+userPhoto);
				} catch (FileUploadException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			bbs_user user=new bbs_user(userId, userPsw, userEmail, userSex, userPhoto);
			
			PrintWriter out = resp.getWriter();
			boolean isOk=cr.add(user);
			if(isOk) {
				out.write("true");
				//resp.sendRedirect("UserServlet?op=findAll");
			}else {
				out.write("false");
			}
			out.flush();

		}

	//删除
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String userId = req.getParameter("userId");
		resp.setContentType("application/json;charset=UTF-8");
		System.out.println(userId);
		PrintWriter out = resp.getWriter();
		boolean isOk=cr.delete(userId);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
