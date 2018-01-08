package mina.bean;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018年1月2日
 *
 */
public class MsgHeader {
	/**
	 * 消息的总长度(4字节)
	 */
	private Integer Message_Length = 20;
	/**
	 * 命令ID(4字节)
	 */
	private Integer Command_ID;
	/**
	 * 序列号(12字节)
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
