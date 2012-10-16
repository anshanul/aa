package assign.dbaccess;

public class ValidationException extends Exception {
	private String errorMessage;
	 
	/**
	 * No Argument Constructor
	 */
	public ValidationException(String inErrorMessage){
		errorMessage = inErrorMessage;
	}
	public void setErrorMessage(String inErrorMessage){
		errorMessage = inErrorMessage;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

}
