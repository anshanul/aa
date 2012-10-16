package assign.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.InfoUser;
import assign.dbaccess.InfoUserBo;

import assign.dbaccess.ValidationException;



/**
 * Servlet implementation class ViewUserDetails
 */
public class ViewUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errors="";
    	String fname = request.getParameter("firstName");
    	System.out.println("ram");
    
          InfoUserBo businessobj = new InfoUserBo();
    	
    	InfoUser valueobj = null;
    	try{
    		
    		valueobj = businessobj.getDetails(fname);
    		
    	}catch (ValidationException emve){
			 errors = emve.getErrorMessage();
		 }
    	
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	if (errors.equals("")) {
    		request.setAttribute("persondetails", valueobj);
        	RequestDispatcher rd = 
        	request.getRequestDispatcher("/jsp/viewuserinfo.jsp");
        	rd.forward(request, response);
		}else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/jsp/Home.jsp");
		} 
    	
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
