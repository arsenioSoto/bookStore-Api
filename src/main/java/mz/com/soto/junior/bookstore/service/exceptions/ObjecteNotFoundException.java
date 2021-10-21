package mz.com.soto.junior.bookstore.service.exceptions;


public class ObjecteNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjecteNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjecteNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
