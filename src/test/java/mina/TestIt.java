package mina;

import java.util.Calendar;

import org.junit.Test;

/**
 *
 * @Package: mina
 * @author liuming
 * @date 2018Äê1ÔÂ8ÈÕ
 *
 */
public class TestIt {

	@Test
	public void t1() {
		int a = 0xA;
		System.out.println(a);
		//(Hexdump: 00 00 00 14 00 00 00 02 00 01 9B 5E 06 44 D2 79 00 00 00 01)
		//			00 00 00 14 00 00 00 02 00 01 9B 5E 06 71 83 6A 00 00 00 01
		//Hexdump: 00 00 00 3D 00 00 00 01 00 01 9B 5E 06 72 52 9C 00 00 00 4D 02 74 64 74 6C 62 73 00 00 00 00 00 00 00 00 00 00 74 64 74 6C 62 73 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
		int[] hexdump = new int[] {00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00 ,02 ,00 ,01, 0x9B,0x5E, 0x06 ,0x44 ,0xD2, 0x79, 0x00, 0x00, 0x00, 0x01};
		for(int i:hexdump) {
			System.out.print(i+",");
		}
		System.out.println("");
		String binaryString = Integer.toBinaryString(a);
		System.out.println(binaryString);
	}
	
	@Test
	public void getReserve()
	{
		byte tmpId[] = new byte[8];
//		System.arraycopy(super.buf, 53, tmpId, 0, tmpId.length);
		String tmp = (new String(tmpId)).trim();
		System.out.println("["+tmp+"]");
	}
	@Test
	public void getCurrentTimestamp()
	{
		Calendar cal = Calendar.getInstance();
		int t = cal.get(Calendar.MONTH) + 1;
		t = t * 100 + cal.get(Calendar.DAY_OF_MONTH);
		t = t * 100 + cal.get(Calendar.HOUR_OF_DAY);
		t = t * 100 + cal.get(Calendar.MINUTE);
		t = t * 100 + cal.get(Calendar.SECOND);
		System.out.println(t);
	}
}
