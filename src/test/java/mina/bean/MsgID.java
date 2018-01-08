package mina.bean;

/**
 *
 * @Package: mina.bean
 * @author liuming
 * @date 2018Äê1ÔÂ2ÈÕ
 *
 */
public final class MsgID {
	Integer SGIP_BIND = 0x1;
	Integer SGIP_BIND_RESP = 0x80000001;
	Integer SGIP_UNBIND = 0x2;
	Integer SGIP_UNBIND_RESP = 0x80000002;
	Integer SGIP_SUBMIT = 0x3;
	Integer SGIP_SUBMIT_RESP = 0x80000003;
	Integer SGIP_DELIVER = 0x4;
	Integer SGIP_DELIVER_RESP = 0x80000004;
	Integer SGIP_REPORT = 0x5;
	Integer SGIP_REPORT_RESP = 0x80000005;
}
