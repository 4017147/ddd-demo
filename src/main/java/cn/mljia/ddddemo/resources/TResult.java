package cn.mljia.ddddemo.resources;

public class TResult implements java.io.Serializable {
	private static final long serialVersionUID = 7828683340362103706L;

	/**
	 * -1锛氬弬鏁伴敊璇� 200:鎴愬姛 400锛氬け璐�
	 * 
	 */
	protected int status;

	/**
	 * 寮傚父淇℃伅
	 * 
	 */
	protected String errorMessage;

	/**
	 * 寮傚父淇℃伅
	 * 
	 */
	protected String error_message;

	/**
	 * 
	 * 杩斿洖瀵硅薄鎬绘暟(鍒嗛〉鐢�)
	 */
	protected int totalCount;

	/**
	 * 
	 * 杩斿洖瀵硅薄鎬绘暟(鍒嗛〉鐢�)
	 */
	protected int total_count;

	/**
	 * 
	 * 杩斿洖姣忛〉鏉℃暟(鍒嗛〉鐢�)
	 */
	protected int rows;

	/**
	 * 杩斿洖鍊糞tring鏍煎紡
	 * 
	 */
	protected String content;

	/**
	 * 杩斿洖鍊糘bject鏍煎紡
	 * 
	 */
	protected Object data;

	public TResult() {
		super();
	}

	public TResult(int status) {
		super();
		this.status = status;
	}

	public TResult(int status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public TResult(int status, String errorMessage, int totalCount, int rows, String content, Object data) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
		this.totalCount = totalCount;
		this.rows = rows;
		this.content = content;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		setError_message(errorMessage);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotal_count(totalCount);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

}
