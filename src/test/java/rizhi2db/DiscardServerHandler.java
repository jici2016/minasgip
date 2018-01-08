package rizhi2db;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 *
 * @Package: rizhi2db
 * @author liuming
 * @date 2017Äê12ÔÂ27ÈÕ
 *
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
//		super.channelRead(ctx, msg);
		ByteBuf in = (ByteBuf)msg;
		while (in.isReadable()) {
			System.out.println((char)in.readByte());
			System.out.flush();
		}
		ReferenceCountUtil.release(msg);
//		((ByteBuf)msg).release();
		System.out.println("New Client:"+ctx.name());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
		ctx.close();
	}
	             
}
