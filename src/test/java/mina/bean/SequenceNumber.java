package mina.bean;

import java.util.Calendar;

import org.junit.Test;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018年1月5日
 *
 */
public class SequenceNumber {
	/**
	 * 源节点的编号
	 */
	Integer first=100100;
	Integer second=0105161530;
	Integer third=1;
	
	protected static int seqId = 1;

	
	
	/**
	 * 
	 */
	public SequenceNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param first
	 * @param second
	 * @param third
	 */
	public SequenceNumber(Integer first, Integer second, Integer third) {
		super();
		this.first = first;
		this.second = second==null?getCurrentTimestamp():second;
		this.third = third==null?generateSeqID():third;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getThird() {
		return third;
	}
	public void setThird(Integer third) {
		this.third = third;
	}
	@Override
	public String toString() {
		return "SequenceNumber [first=" + first + ", second=" + second + ", third=" + third + "]";
	}
	
	@Test
	public int getCurrentTimestamp()
	{
		Calendar cal = Calendar.getInstance();
		int t = cal.get(Calendar.MONTH) + 1;
		t = t * 100 + cal.get(Calendar.DAY_OF_MONTH);
		t = t * 100 + cal.get(Calendar.HOUR_OF_DAY);
		t = t * 100 + cal.get(Calendar.MINUTE);
		t = t * 100 + cal.get(Calendar.SECOND);
		return t;
	}
	
	public synchronized static int generateSeqID()
	{

		if (seqId >= 100000)
			seqId = 1;
		else
			seqId++;
		return seqId;
	}
}
