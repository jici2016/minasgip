package mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018Äê1ÔÂ2ÈÕ
 *
 */
public class Server1 {
	public static void main(String[] args) {
		IoAcceptor acceptor = new NioSocketAcceptor(4);
		acceptor.setHandler(new ServerHandler1());
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		chain.addLast("logger", new LoggingFilter());
//		chain.addLast(name, new ProtocolCodecFilter(new ProtocolEncoder, decoder));
		chain.addLast("sgip", new ProtocolCodecFilter(new SgipProtocolCodecFactory()));
		//(Hexdump: 00 00 00 14 00 00 00 02 00 01 9B 5E 06 44 D2 79 00 00 00 01)

		acceptor.getSessionConfig().setReaderIdleTime(6);
		acceptor.getSessionConfig().setWriterIdleTime(8);
		try {
			acceptor.bind(new InetSocketAddress(8801));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=========SmsServer is start============");  
//		acceptor.dispose(true);
		
		
		
		
	}
}
