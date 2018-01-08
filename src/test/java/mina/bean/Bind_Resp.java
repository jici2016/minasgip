package mina.bean;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018年1月2日
 *
 */
public class Bind_Resp extends Msg{
	/**
	 * 1
	 * Bind执行命令是否成功。
		0：执行成功
		其它：错误码
	 */
	private byte Result;
	
	
	/**
	 * 8
	 *保留，扩展用 
	 */
	private String Reserve="\00000000";



	/**
	 * @return the result
	 */
	public byte getResult() {
		return Result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(byte result) {
		Result = result;
	}


	/**
	 * @return the reserve
	 */
	public String getReserve() {
		return Reserve;
	}


	/**
	 * @param reserve the reserve to set
	 */
	public void setReserve(String reserve) {
		Reserve = reserve;
	}


	/* (non-Javadoc)
	 * @see mina.bean.Msg#getBodyLength()
	 */
	@Override
	public Integer getBodyLength() {
		// TODO Auto-generated method stub
		return 9;
	}


	@Override
	public String toString() {
		return "Bind_Resp [Result=" + Result + ", Reserve=" + Reserve + "]";
	}
	
}
