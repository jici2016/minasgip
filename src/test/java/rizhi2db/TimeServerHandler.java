package rizhi2db;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *
 * @Package: rizhi2db
 * @author liuming
 * @date 2017Äê12ÔÂ27ÈÕ
 *
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter{

	

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

		ByteBuf buf = ctx.alloc().buffer(4);
		buf.writeInt((int)(System.currentTimeMillis()/1000L+2208988800L));
		final ChannelFuture channelFuture = ctx.writeAndFlush(buf);
		channelFuture.addListener(new ChannelFutureListener() {
			
			public void operationComplete(ChannelFuture future) throws Exception {
				// TODO Auto-generated method stub
				assert channelFuture == future;
				ctx.close();
			}
		});
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		super.channelRead(ctx, msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);
	}

	
	
	
}
