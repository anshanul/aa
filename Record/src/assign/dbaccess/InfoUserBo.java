package assign.dbaccess;


import java.util.ArrayList;



import assign.validation.FirstNameValidation;



public class InfoUserBo {

	public void addUser(InfoUser inUser) throws ValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		//2a: validation
		FirstNameValidation validationExp = new FirstNameValidation();
		String errorMsg = validationExp.validateFirstName(inUser.getFirstName());
		//emailaddress

		//firstname

		allMessages.append(errorMsg);
		//lastname
		//remaining fields

		Infocon dbaAccess = new Infocon();
		dbaAccess.addUser(inUser);

		/*//2b: no error from validation, call db component
		if (allMessages.length() == 0){
			Infocon dbaAccess = new Infocon();
			dbaAccess.addUser(inUser);
		}
		//if error return to controller
		else{
			ValidationException validationfname = new ValidationException(allMessages.toString());
			 throw validationfname;
		}*/
		return;
	}
	
	public void deleteUser(String fname) throws ValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		Infocon dbaAccess = new Infocon();
		dbaAccess.deleteUser(fname);
		
	}
	
	public ArrayList getAllUserEntries() throws ValidationException, Exception{
		Infocon dbaAccess = new Infocon();
		ArrayList userlist = dbaAccess.getAllUserEntries();
		return userlist;
	}
	
	public InfoUser getDetails(String firstName) throws ValidationException, Exception{

		StringBuffer allMessages = new StringBuffer();
		//validation
		//FirstNameValidation name = new FirstNameValidation();
		//allMessages.append(name.validateFirstName(firstname.getFirstName()));
		//if (allMessages.length() == 0){
			//database insert
			Infocon dbaAccess = new Infocon();
			InfoUser user= dbaAccess.getDetails(firstName);
		//}
		//else{
			//throw new ValidationException(allMessages.toString());
		
		return user;
	}
	public void updateDetails(InfoUser firstName) throws ValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		
		
			Infocon dbaAccess = new Infocon();
			dbaAccess.updateDetails(firstName);
		
		return;
	}


}
	

