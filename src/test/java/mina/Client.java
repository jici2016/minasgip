package mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.DemuxingProtocolEncoder;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018Äê1ÔÂ2ÈÕ
 *
 */
public class Client {
	public static void main(String[] args) {
		IoConnector connector = new NioSocketConnector(4);
		connector.setHandler(new ClientHandler2());
		DefaultIoFilterChainBuilder chain = connector.getFilterChain();
		chain.addLast("logger", new LoggingFilter());
		chain.addLast("sgip", new ProtocolCodecFilter(new SgipProtocolCodecFactory()));
//		chain.addLast("sgip", new ProtocolCodecFilter(new ProtocolEncoder() {
//			
//			public void encode(IoSession arg0, Object arg1, ProtocolEncoderOutput arg2) throws Exception {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			public void dispose(IoSession arg0) throws Exception {
//				// TODO Auto-generated method stub
//				
//			}
//		}, new SgipDecoder()));
		connector.getSessionConfig().setReaderIdleTime(6);
		connector.getSessionConfig().setWriterIdleTime(8);
		ConnectFuture future = connector.connect(new InetSocketAddress("localhost",8802));
		future.addListener(new IoFutureListener<IoFuture>() {

			public void operationComplete(IoFuture arg0) {
				// TODO Auto-generated method stub
				System.out.println("operationComplete");
			}
		}).awaitUninterruptibly();
//		acceptor.dispose(true);
		System.out.println("=========SmsClient is start============");
		
		
		
		
	}
}
