package mina;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import org.hamcrest.core.IsInstanceOf;

import mina.bean.Bind;
import mina.bean.Bind_Resp;
import mina.bean.Constants;
import mina.bean.Msg;
import mina.bean.MsgHeader;
import mina.bean.SequenceNumber;
/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018��1��4��
 *
 */
public class SgipEncoder implements MessageEncoder<Object> {

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.demux.MessageEncoder#encode(org.apache.mina.core.session.IoSession, java.lang.Object, org.apache.mina.filter.codec.ProtocolEncoderOutput)
	 */
	public void encode(IoSession session, Object obj, ProtocolEncoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------��ʼ����---------------");
		System.out.println("encode:"+obj);
//		Integer msgLength = msg.getBodyLength();
//		System.out.println("��Ϣ�ܳ��ȣ�"+msgLength);
		IoBuffer buffer = null;
		if(obj instanceof Msg) {
		Msg	msg  = (Msg)obj;
		Integer message_Length = msg.getMsgHeader().getMessage_Length();
		System.out.println("��Ϣ�ܳ��ȣ�"+message_Length);
		Integer bodyLength = msg.getBodyLength();
		System.out.println("��Ϣ�峤�ȣ�"+bodyLength);
		buffer =  IoBuffer.allocate(message_Length);
		MsgHeader header = msg.getMsgHeader();
		buffer.putInt(header.getMessage_Length());
		buffer.putInt(header.getCommand_ID());
		SequenceNumber sequence_Number = header.getSequence_Number();
		buffer.putInt(sequence_Number.getFirst());
		buffer.putInt(sequence_Number.getSecond());
		buffer.putInt(sequence_Number.getThird());
		
		//ֻд������Ϣͷ
				//���滹Ҫд��Ϣ��
				System.out.println("��Ϣͷ��������"+header);
				System.out.println("SgipEncoder-buffer:"+buffer);
				switch (header.getCommand_ID()) {
				case Constants.MSGID.SGIP_BIND_RESP:
					System.out.println("����SGIP_BIND_RESP");
					Bind_Resp bind_Resp = (Bind_Resp)obj;
					System.out.println(bind_Resp);
					buffer.put(bind_Resp.getResult());
					byte[]tmpbuf = bind_Resp.getReserve().getBytes();
					buffer.put(tmpbuf);
					break;
				case Constants.MSGID.SGIP_BIND:
					System.out.println("����SGIP_BIND");
					Bind bind = (Bind)obj;
					buffer.put(bind.getLogin_Type());
					buffer.put(bind.getLogin_Name().trim().getBytes());
					buffer.put(bind.getLogin_Password().trim().getBytes());
					buffer.put(bind.getReserve().getBytes());
					System.out.println("SgipEncoder-buffer:"+buffer);
					break;
				default:
					break;
				}
				
				buffer.flip();
		}
		
		session.write(buffer);
		System.out.println("------------��������---------------");
	}


}
