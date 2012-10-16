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
 * Servlet implementation class ModifyUserServlet
 */
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errors = "";
		//Step1: capture input and populate the VO
		InfoUser firstName = new InfoUser();
		
		firstName.setFirstName(request.getParameter("firstName"));
		firstName.setLastName(request.getParameter("lastName"));
		firstName.setSex(request.getParameter("sex"));
		firstName.setPhoneNo(request.getParameter("phoneNo"));
		firstName.setHouseNo(request.getParameter("houseNo"));
		firstName.setCity(request.getParameter("city"));
		firstName.setState(request.getParameter("state"));

		// Step2: Do processing or Business logic
		InfoUserBo infoBo = new InfoUserBo();
		System.out.println("anu");

		try
		{
			infoBo.updateDetails(firstName);
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


