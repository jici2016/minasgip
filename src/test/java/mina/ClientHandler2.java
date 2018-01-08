package mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import mina.bean.Bind;
import mina.bean.MsgHeader;
import mina.bean.SequenceNumber;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018Äê1ÔÂ2ÈÕ
 *
 */
public class ClientHandler2 extends IoHandlerAdapter{

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
		System.out.println("client,exceptionCaught");
		cause.printStackTrace();
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
		System.out.println("client,inputClosed");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(session, message);
		System.out.println("client,messageReceived:"+message);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
		System.out.println("client,messageSent:\n"+message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
		System.out.println("client,sessionClosed");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		System.out.println("client,sessionCreated");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
		System.out.println("client,sessionIdle:"+status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		System.out.println("client,sessionOpened");
		
		Bind bind = new Bind();
		bind.setLogin_Name("tdtlbs");
		bind.setLogin_Password("tdtlbs");
		bind.setLogin_Type((byte) 1);
//		bind.setReserve(reserve);
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setCommand_ID(1);
		msgHeader.setMessage_Length(61);
		SequenceNumber sequence_Number = new SequenceNumber(93041, null, null);
//		sequence_Number.setFirst(100100);
//		sequence_Number.setSecond(second);
//		sequence_Number.setThird(third);;
		msgHeader.setSequence_Number(sequence_Number );
		bind.setMsgHeader(msgHeader );
		session.write(bind);
	}
	
}
