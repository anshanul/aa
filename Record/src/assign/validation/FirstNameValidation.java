package assign.validation;

import assign.interfaces.ErrorMsg;
import java.io.*;

public class FirstNameValidation {

	public FirstNameValidation() {
		super();
		
	}
	
	public String validateFirstName(String firstName){
		if (isFieldBlankOrNull(firstName)){
			return ErrorMsg.FIRST_NAME_IS_BLANK;
		}	
		return "";
	}
	
	private boolean isFieldBlankOrNull(String field){
		if (field == null || field.trim().equals("")){
			return true;
		}
		return false;
	}

}
