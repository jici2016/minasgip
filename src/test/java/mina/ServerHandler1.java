package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.hamcrest.core.IsInstanceOf;

import mina.bean.Bind;
import mina.bean.Bind_Resp;
import mina.bean.Constants;
import mina.bean.Msg;
import mina.bean.MsgBody;
import mina.bean.MsgHeader;
import mina.bean.UnBind;
import mina.bean.UnBind_Resp;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018年1月2日
 *
 */
public class ServerHandler1 extends IoHandlerAdapter{

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
		System.out.println("ServerHandler1-exceptionCaught");
//		System.out.println(cause.getMessage());
		cause.printStackTrace();
//		System.out.println(cause);
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
		System.out.println("inputClosed");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(session, message);
//		message = (Msg)message;
		System.out.println("messageReceived:"+message);
		
		if(message instanceof UnBind) {
			UnBind unBind = (UnBind)message;
			System.out.println("unbind:"+(message instanceof UnBind));
			UnBind_Resp unBind_Resp = new UnBind_Resp();
			MsgHeader msgHeader = new MsgHeader();
			msgHeader.setCommand_ID(Constants.MSGID.SGIP_UNBIND_RESP);
//			msgHeader.setMessage_Length(20);
			msgHeader.setSequence_Number(unBind.getMsgHeader().getSequence_Number());
			unBind_Resp.setMsgHeader(msgHeader );
			session.write(unBind_Resp);
//			session.closeNow();
		}else if(message instanceof Bind) {
			Bind bind = (Bind)message;
			System.out.println("bind:"+(message instanceof Bind) );
			Bind_Resp bind_Resp = new Bind_Resp();
			
			//如果鉴权成功就是 0，否则是别的错误码  
			bind_Resp.setResult((byte)1);//默认成功
			byte[]tmpbuf = new byte[8];
			for (byte b=0;b<tmpbuf.length;b++) {
				tmpbuf[b]=0;
			}
			String reserve = new String(tmpbuf);
			bind_Resp.setReserve(reserve);
			MsgHeader header = new MsgHeader();
			header.setCommand_ID(Constants.MSGID.SGIP_BIND_RESP);
			header.setSequence_Number(bind.getMsgHeader().getSequence_Number());
			//头长度加上身体长度为 总体长度
			header.setMessage_Length(header.getMessage_Length()+bind_Resp.getBodyLength());
		 	bind_Resp.setMsgHeader(header);
		 	System.out.println("回复bind_Resp：+"+bind_Resp);
		 	session.write(bind_Resp);
			
		}
//		byte[]bytes = (byte[])message;
//		
//		for (int i = 0; i < bytes.length; i++) {
//			System.out.println("b"+i+":"+bytes[i]);
//		}
		
//		byte[]bytes=message
//		session.write("get:"+message);
//		session.write(new String(bytes, "utf-8"));
//		session.closeOnFlush();
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
		
//		System.out.println("messageSent:"+(String)message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
		System.out.println("sessionClosed");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
//		System.out.println("sessionIdle:"+status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		System.out.println("sessionOpened");
	}
	
}
