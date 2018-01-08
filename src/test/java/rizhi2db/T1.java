package rizhi2db;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;

/**
 *
 * @Package: rizhi2db
 * @author liuming
 * @date 2017Äê12ÔÂ25ÈÕ
 *
 */
public class T1 {
	public static void main1(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++)
		fixedThreadPool.submit(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<100;i++)
				System.out.println(Thread.currentThread().getName()+"-"+i);
			}
		});
		
		fixedThreadPool.shutdown();
		
	}
	
	@Test
	public void test1() {
		try {
			Selector selector = Selector.open();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
