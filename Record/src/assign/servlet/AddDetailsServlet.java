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
 * Servlet implementation class AddDetailsServlet
 */
public class AddDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errors = "";
		//Step1: capture input and populate the VO
		InfoUser inUser = new InfoUser();
		// Get registration details and set to the EMailAddress
		//Step:1
		inUser.setFirstName(request.getParameter("firstName"));
		inUser.setLastName(request.getParameter("lastName"));
		inUser.setSex(request.getParameter("sex"));
		inUser.setPhoneNo(request.getParameter("phoneNo"));
		inUser.setHouseNo(request.getParameter("houseNo"));
		inUser.setCity(request.getParameter("city"));
		inUser.setState(request.getParameter("state"));

		// Step2: Do processing or Business logic
		InfoUserBo infoBo = new InfoUserBo();

		try
		{
			infoBo.addUser(inUser);
		}
		catch (ValidationException emve)
		{
			errors = emve.getErrorMessage();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		//step3: Response Back
		if (errors.equals(""))
		{
			response.sendRedirect("/Record/jsp/Home.jsp");
		}
		else 
		{
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/Record/jsp/adduser.jsp");
		}

	}
}
