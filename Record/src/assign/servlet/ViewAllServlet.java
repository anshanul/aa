package assign.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.InfoUser;
import assign.dbaccess.InfoUserBo;
import assign.dbaccess.ValidationException;



/**
 * Servlet implementation class ViewAllServlet
 */
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errors = "";
        response.setContentType("text/html");

	InfoUserBo userBO = new InfoUserBo();
	//InfoUser[] userlist = new InfoUser[];
	InfoUser[] userlist =  new InfoUser[10];

	try{
		ArrayList list = userBO.getAllUserEntries();
		Object[] aList = list.toArray(new InfoUser[list.size()]);
		for (int i = 0;i < aList.length;i++) {
			userlist[i] = (InfoUser) aList[i];
			System.out.println(userlist[i].getFirstName());
		}
	}catch (ValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
request.getSession().setAttribute("userlist", userlist);

		response.sendRedirect("/Record/jsp/viewall.jsp");	

	}
	else {
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/Record/jsp/Home.jsp");
	}
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
