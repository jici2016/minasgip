package mina.bean;


import org.apache.mina.core.buffer.IoBuffer;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018年1月2日
 *
 */
public class Bind extends Msg{
	/**
	 * 1
	 * 登录类型。
		1：SP向SMG建立的连接，用于发送命令
		2：SMG向SP建立的连接，用于发送命令
		3：SMG之间建立的连接，用于转发命令
		4：SMG向GNS建立的连接，用于路由表的检索和维护
		5：GNS向SMG建立的连接，用于路由表的更新
		6：主备GNS之间建立的连接，用于主备路由表的一致性
		11：SP与SMG以及SMG之间建立的测试连接，用于跟踪测试
		其它：保留
	 */
	private byte Login_Type;
	
	/**
	 * 16 
	 * 服务器端给客户端分配的登录名
	 */
	private String Login_Name;
	
	/**
	 * 16
	 * 服务器端和Login Name对应的密码
	 */
	private String Login_Password;
	
	/**
	 * 8
	 *保留，扩展用 
	 */
	private String Reserve;
	byte[] tmpbuf = null;
	{
		tmpbuf = new byte[8];
		for (int i = 0; i < tmpbuf.length; i++) {
			tmpbuf[i] = 0;
		}
	}
	/**
	 * 
	 */
	public Bind() {
		// TODO Auto-generated constructor stub
		super.setBodyLength(41);
		
		this.Reserve = new String(tmpbuf);
	}

	public byte getLogin_Type() {
		return Login_Type;
	}

	public void setLogin_Type(byte login_Type) {
		Login_Type = login_Type;
	}

	public String getLogin_Name() {
		return Login_Name;
	}

	public void setLogin_Name(String login_Name) {
		Login_Name = login_Name;
	}

	public String getLogin_Password() {
		return Login_Password;
	}

	public void setLogin_Password(String login_Password) {
		Login_Password = login_Password;
	}

	public String getReserve() {
		return Reserve;
	}

	public void setReserve(String reserve) {
		Reserve = reserve;
	}
	
	public static void main(String[] args) {
//		Constants.MsgID
//		Bind b = new Bind();
		
	}

	/* (non-Javadoc)
	 * @see mina.bean.Msg#getBodyLength()
	 */
	@Override
	public Integer getBodyLength() {
		return null;
	}

	@Override
	public String toString() {
		return "Bind [Login_Type=" + Login_Type + ", Login_Name=" + Login_Name + ", Login_Password=" + Login_Password
				+ ", Reserve=" + Reserve + "]"+super.toString();
	}

}
