package assign.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.InfoUser;
import assign.dbaccess.InfoUserBo;
import assign.dbaccess.ValidationException;
/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errors = "";
		String fname = request.getParameter("firstName");
		InfoUserBo userBO = new InfoUserBo();
		try
		{
			userBO.deleteUser(fname);
		}
		catch (ValidationException emve)
		{
			errors = emve.getErrorMessage();
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		if (errors.equals("")){
			response.sendRedirect("/Record/jsp/Home.jsp");	
		}
		else {
			System.out.println(request.getRequestURI());
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/Record/jsp/DeleteUser.jsp");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
