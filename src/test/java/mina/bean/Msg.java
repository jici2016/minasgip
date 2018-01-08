package mina.bean;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018��1��2��
 *
 */
public abstract class Msg {
	
	private Integer body_Length = 0;

	public abstract Integer getBodyLength();

	public void setBodyLength(Integer length) {
		this.body_Length = length;
	}
	
	
//	/**
//	 * ��Ϣ��
//	 */
//	private MsgBody msgBody;
	
	/**
	 * ��Ϣͷ
	 */
	private MsgHeader msgHeader;
	
	public MsgHeader getMsgHeader() {
		return msgHeader;
	}
	public void setMsgHeader(MsgHeader msgHeader) {
		this.msgHeader = msgHeader;
	}

	@Override
	public String toString() {
		return "Msg [body_Length=" + body_Length + ", msgHeader=" + msgHeader + "]";
	}
	
	
	
	
}
