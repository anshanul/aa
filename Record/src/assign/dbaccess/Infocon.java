package assign.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Infocon {


	public static Connection getConnection() throws Exception{
		Connection dbConn = null;
		try
		{
			String url = "jdbc:mysql://localhost:3306/employeedb";
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection(url, "root", "root");
		}
		catch (SQLException sqlexp) 
		{
			sqlexp.printStackTrace();
			throw sqlexp;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return dbConn;
	}


	public static void addUser(InfoUser inUser) throws Exception{

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		try{
			dbConn = getConnection();
			String insertQuery ="insert into userinfo(firstname, lastname, sex, phoneno, houseno, city, state ) values(?,?,?,?,?,?,?)";
			pStmt = dbConn.prepareStatement(insertQuery);
			pStmt.setString(1,inUser.getFirstName());
			pStmt.setString(2, inUser.getLastName());
			pStmt.setString(3, inUser.getSex());
			pStmt.setString(4, inUser.getHouseNo());
			pStmt.setString(5, inUser.getPhoneNo());
			pStmt.setString(6, inUser.getState());
			pStmt.setString(7, inUser.getCity());
			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			}
		}catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			pStmt.close();
			dbConn.close();
		}
		return;
	}
	
	public static void deleteUser(String fname) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = getConnection();
		// 1 select pk from e
		//String selectUserquery  = "SELECT userid FROM employeedb.userinfo where firstname like ?";
		//pStmt = dbConn.prepareStatement(selectUserquery); 
		//pStmt.setString(1, fname);
		//rowsDeleted = pStmt.executeUpdate();
		//ResultSet selectRs = 		pStmt.executeQuery()
		
//ResultSet rs = new ResultSet();
		
		
		String deletequery="DELETE FROM employeedb.userinfo WHERE (userinfo.firstname = ?)";
		pStmt = dbConn.prepareStatement(deletequery); 
		pStmt.setString(1, fname);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted != 1) {
			throw new Exception("Error in deleting the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}
	
	public static ArrayList getAllUserEntries() throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    ArrayList userlist = new ArrayList();
	    InfoUser user = null;

	     try{
		dbConn = getConnection();
		String SelectQuery="SELECT  firstname, lastname, sex, phoneno, houseno, city, state FROM userinfo";
		pStmt = dbConn.prepareStatement(SelectQuery);

   		rs = pStmt.executeQuery();

		while (rs.next()) {
		user = new InfoUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7));
		userlist.add(user);
		System.out.println(user.getFirstName());
                System.out.println(user.getPhoneNo());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return userlist;
	}
	
	public static InfoUser getDetails(String firstName) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    InfoUser firstname =null;
            ResultSet rs = null;
            

	     try{
		dbConn = getConnection();
		String searchquery="SELECT * FROM userinfo WHERE firstname = ?";
		pStmt = dbConn.prepareStatement(searchquery);
		pStmt.setString(1, firstName);
   		rs = pStmt.executeQuery();

		if (rs.next()) {
			firstname = new InfoUser(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8));

		System.out.println(firstname.getFirstName());
                System.out.println(firstname.getLastName());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		}
             catch(Exception e) {
		   e.printStackTrace();
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return firstname;
	}
	
	public static void updateDetails(InfoUser user) throws Exception{

		Connection dbConn = null;
		PreparedStatement pStmt = null;
		int rowsInserted = 0;

		try{
			dbConn = getConnection();
			String updatequery ="(UPDATE userinfo SET firstname=?,  lastname=?, sex=?,  phoneno = ?, houseno = ?, city = ?, state = ?) WHERE firstname=?";
			
			String myQuery =  "update userinfo set firstname='"+user.getFirstName()+"'," + "lastname='"+user.getLastName() +"'," + "sex='"+user.getSex() + "',"
													+ "phoneno ='" +user.getPhoneNo() + "'," + "houseno = '"+ user.getHouseNo() + "',"+ "city ='" + user.getCity()+ "'," 
													+ "state ='" +user.getState() +"'" + "where firstname='"+user.getFirstName() +"'";
					
			//pStmt = dbConn.prepareStatement(updatequery);
			pStmt = dbConn.prepareStatement(myQuery);
		/*	pStmt.setString(0,user.getFirstName());
			pStmt.setString(1, user.getLastName());
			pStmt.setString(2, user.getSex());
			pStmt.setString(3, user.getHouseNo());
			pStmt.setString(4, user.getPhoneNo());
			pStmt.setString(5, user.getState());
			pStmt.setString(6, user.getCity());*/
			rowsInserted = pStmt.executeUpdate();

			if (rowsInserted != 1) {
				throw new Exception("Error in inserting the row");

			}
		}catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			pStmt.close();
			dbConn.close();
		}
		return;
	}
	
            

	     
	}



