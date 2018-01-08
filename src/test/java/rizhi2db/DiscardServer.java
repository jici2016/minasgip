package rizhi2db;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *
 * @Package: rizhi2db
 * @author liuming
 * @date 2017Äê12ÔÂ27ÈÕ
 *
 */
public class DiscardServer {
	private int port;
	public DiscardServer(int port) {
		this.port = port;
	}
	
	private void run() {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		ServerBootstrap serverBootStrap = new ServerBootstrap();
		serverBootStrap.group(bossGroup,workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// TODO Auto-generated method stub
							ch.pipeline().addLast(new TimeServerHandler());
						}
					})
					.option(ChannelOption.SO_BACKLOG,128)
					.childOption(ChannelOption.SO_KEEPALIVE,true);
		
		try {
			ChannelFuture channelFuture = serverBootStrap.bind(port).sync();
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		workerGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
		
		
		
	}
	
	public static void main(String[] args) {
		int port =8083;
		DiscardServer server = new DiscardServer(port);
		server.run();
	}
}
