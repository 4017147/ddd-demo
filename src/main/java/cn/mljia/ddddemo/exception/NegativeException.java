package cn.mljia.ddddemo.exception;

public class NegativeException extends Exception {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;

	private String message;

	public NegativeException() {
		super();
	}

	public NegativeException(String message) {
		super(message);
		this.setStatus(0);
		this.setMessage(message);
	}

	public NegativeException(Integer status, String message) {
		super(message);
		this.setStatus(status);
		this.setMessage(message);
	}

	public NegativeException(Integer status, String message, Throwable cause) {
		super(message, cause);
		this.setStatus(status);
		this.setMessage(message);
	}

	public NegativeException(String message, Throwable cause) {
		super(message, cause);
		this.setStatus(0);
		this.setMessage(message);
	}

	public NegativeException(Throwable cause) {
		super(cause);
		this.setStatus(0);
		this.setMessage(null);
	}

	public Integer getStatus() {
		return status;
	}

	private void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}

}
