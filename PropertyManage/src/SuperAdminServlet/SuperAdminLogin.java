package SuperAdminServlet;

import Model.SuperAdminDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class SuperAdminLogin
 */
public class SuperAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuperAdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out = response.getWriter();

		String account = request.getParameter("account");
		String password = request.getParameter("password");

		boolean flag;
		SuperAdminDAO superadminDAO = new SuperAdminDAO();
		flag = superadminDAO.login(account, password);
		if(flag == false) {
			out.print("<script>alert('账号或密码错误');window.location='SuperAdminLogin.jsp';</script>");
		}else {
			request.getRequestDispatcher("SearchAdmin.jsp").forward(request, response);
		}
	}

}
