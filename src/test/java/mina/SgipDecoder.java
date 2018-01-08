package mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mina.bean.AbstractMsg;
import mina.bean.Bind;
import mina.bean.Bind_Resp;
import mina.bean.Constants;
import mina.bean.Msg;
import mina.bean.MsgHeader;
import mina.bean.SequenceNumber;
import mina.bean.UnBind;
import mina.bean.UnBind_Resp;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018年1月2日
 *
 */
public class SgipDecoder implements MessageDecoder {
	Logger logger = LoggerFactory.getLogger(SgipDecoder.class);

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.demux.MessageDecoder#decodable(org.apache.mina.core.session.IoSession, org.apache.mina.core.buffer.IoBuffer)
	 */
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		// TODO Auto-generated method stub
		if (in.remaining()<20) {
			System.out.println("数还不够");
			return NEED_DATA;
		}
		return OK;
	}

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.demux.MessageDecoder#decode(org.apache.mina.core.session.IoSession, org.apache.mina.core.buffer.IoBuffer, org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageDecoderResult解码：" + in.toString());
//		logger.info("解码：" + in.toString());
		Msg msg = new AbstractMsg();
		
		MsgHeader header = new MsgHeader();
		
		while (in.hasRemaining()) {
			Integer message_Length = in.getInt();
			System.out.println("message_Length:"+message_Length);
			header.setMessage_Length(message_Length);

			Integer command_ID = in.getInt();
			
			header.setCommand_ID(command_ID);
			
			Integer first = in.getInt();
			Integer second = in.getInt();
			Integer third = in.getInt();
			SequenceNumber seqNum = new SequenceNumber();
			seqNum.setFirst(first);
			seqNum.setSecond(second);
			seqNum.setThird(third);
			header.setSequence_Number(seqNum);
			;
			msg.setMsgHeader(header);
			System.out.println("消息头："+header);
			System.out.println("消息体状态-capacity:"+in.capacity()+",pos:"+in.position()+",limit:-"+in.limit()+",剩余可读："+(message_Length-in.position()));
			//命令ID区分消息类型
			switch (command_ID) {
			case Constants.MSGID.SGIP_BIND:
				System.out.println("绑定");
				Bind bind = new Bind();
//				msg.setMsgHeader(header);
				bind.setMsgHeader(header);
				byte login_Type = in.get();
				bind.setLogin_Type(login_Type);
				byte[] tmpbuf = new byte[16];
				in.get(tmpbuf);
				
				String login_Name = new String(tmpbuf);
				
				bind.setLogin_Name(login_Name );
				in.get(tmpbuf);
				String login_Password = new String(tmpbuf);
				bind.setLogin_Password(login_Password);
				 tmpbuf = new byte[8];
				 in.get(tmpbuf);
				 String reserve = new String(tmpbuf);
				bind.setReserve(reserve);
				System.out.println("bind:"+bind);
				out.write(bind);
				break;
			case Constants.MSGID.SGIP_UNBIND:
				System.out.println("解绑");
				msg = new UnBind();
				msg.setMsgHeader(header);
				out.write(msg);
				break;
			case Constants.MSGID.SGIP_BIND_RESP:
				System.out.println("绑定结果：");
				Bind_Resp bind_Resp = new Bind_Resp();
				byte result = in.get();
				bind_Resp.setResult(result );
				tmpbuf = new byte[8];
				in.get(tmpbuf);
				 reserve = new String(tmpbuf);
				bind_Resp.setReserve(reserve );
				bind_Resp.setMsgHeader(header);
				out.write(bind_Resp);
				break;
			default:
				break;
			}
			
		}
		System.out.println("消息解码完成。。。");
		
		
		return OK;
	}

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.demux.MessageDecoder#finishDecode(org.apache.mina.core.session.IoSession, org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
