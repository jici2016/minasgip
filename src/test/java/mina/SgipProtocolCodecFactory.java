package mina;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

import mina.bean.Msg;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018Äê1ÔÂ5ÈÕ
 *
 */
public class SgipProtocolCodecFactory extends DemuxingProtocolCodecFactory {
	
	private SgipEncoder encoder ;
	private SgipDecoder decoder;
	public SgipProtocolCodecFactory() {
		// TODO Auto-generated constructor stub
		encoder = new SgipEncoder();
		decoder = new SgipDecoder();
		addMessageDecoder(decoder);
		addMessageEncoder(Msg.class,encoder);
	}
	public SgipEncoder getEncoder() {
		return encoder;
	}
	public void setEncoder(SgipEncoder encoder) {
		this.encoder = encoder;
	}
	public SgipDecoder getDecoder() {
		return decoder;
	}
	public void setDecoder(SgipDecoder decoder) {
		this.decoder = decoder;
	}
	
}
