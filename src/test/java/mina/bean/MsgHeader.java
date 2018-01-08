package mina.bean;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018��1��2��
 *
 */
public class MsgHeader {
	/**
	 * ��Ϣ���ܳ���(4�ֽ�)
	 */
	private Integer Message_Length = 20;
	/**
	 * ����ID(4�ֽ�)
	 */
	private Integer Command_ID;
	/**
	 * ���к�(12�ֽ�)
	 */
	private SequenceNumber Sequence_Number;
	
	public SequenceNumber getSequence_Number() {
		return Sequence_Number;
	}
	public void setSequence_Number(SequenceNumber sequence_Number) {
		Sequence_Number = sequence_Number;
	}
	public Integer getMessage_Length() {
		return Message_Length;
	}
	public void setMessage_Length(Integer message_Length) {
		Message_Length = message_Length;
	}
	public Integer getCommand_ID() {
		return Command_ID;
	}
	public void setCommand_ID(Integer command_ID) {
		Command_ID = command_ID;
	}
	
	@Override
	public String toString() {
		return "MsgHeader [Message_Length=" + Message_Length + ", Command_ID=" + Command_ID + ", Sequence_Number="
				+ Sequence_Number + "]";
	}
	
	
}
