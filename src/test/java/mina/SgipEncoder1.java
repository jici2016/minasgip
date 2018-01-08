package mina;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

import mina.bean.Bind_Resp;
import mina.bean.Constants;
import mina.bean.Msg;
import mina.bean.MsgHeader;
import mina.bean.SequenceNumber;
/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018年1月4日
 *
 */
public class SgipEncoder1 implements MessageEncoder<Msg> {

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.demux.MessageEncoder#encode(org.apache.mina.core.session.IoSession, java.lang.Object, org.apache.mina.filter.codec.ProtocolEncoderOutput)
	 */
	public void encode(IoSession session, Msg msg, ProtocolEncoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("encode:"+msg);
//		Integer msgLength = msg.getBodyLength();
//		System.out.println("消息总长度："+msgLength);
		Integer message_Length = msg.getMsgHeader().getMessage_Length();
		System.out.println("消息总长度："+message_Length);
		Integer bodyLength = msg.getBodyLength();
		System.out.println("消息体长度："+bodyLength);
		IoBuffer buffer = IoBuffer.allocate(message_Length,true);
		MsgHeader header = msg.getMsgHeader();
		buffer.putInt(header.getMessage_Length());
		buffer.putInt(header.getCommand_ID());
		SequenceNumber sequence_Number = header.getSequence_Number();
		buffer.putInt(sequence_Number.getFirst());
		buffer.putInt(sequence_Number.getSecond());
		buffer.putInt(sequence_Number.getThird());
		//只写完了消息头
		//下面还要写消息体
		System.out.println("消息体编码："+buffer);
		
		switch (header.getCommand_ID()) {
		case Constants.MSGID.SGIP_BIND_RESP:
			System.out.println("编码SGIP_BIND_RESP");
			Bind_Resp bind_Resp = (Bind_Resp)msg;
			System.out.println(bind_Resp);
			buffer.put(bind_Resp.getResult());
			byte[]tmpbuf = new byte[8];
			buffer.put(tmpbuf);
			break;

		default:
			break;
		}
		
		buffer.flip();
		session.write(buffer);
	}


}
