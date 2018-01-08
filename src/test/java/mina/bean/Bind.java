package mina.bean;


import org.apache.mina.core.buffer.IoBuffer;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018��1��2��
 *
 */
public class Bind extends Msg{
	/**
	 * 1
	 * ��¼���͡�
		1��SP��SMG���������ӣ����ڷ�������
		2��SMG��SP���������ӣ����ڷ�������
		3��SMG֮�佨�������ӣ�����ת������
		4��SMG��GNS���������ӣ�����·�ɱ�ļ�����ά��
		5��GNS��SMG���������ӣ�����·�ɱ�ĸ���
		6������GNS֮�佨�������ӣ���������·�ɱ��һ����
		11��SP��SMG�Լ�SMG֮�佨���Ĳ������ӣ����ڸ��ٲ���
		����������
	 */
	private byte Login_Type;
	
	/**
	 * 16 
	 * �������˸��ͻ��˷���ĵ�¼��
	 */
	private String Login_Name;
	
	/**
	 * 16
	 * �������˺�Login Name��Ӧ������
	 */
	private String Login_Password;
	
	/**
	 * 8
	 *��������չ�� 
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
