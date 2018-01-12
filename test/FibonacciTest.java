import static org.junit.Assert.*;

import org.junit.Test;

import com.silentkid.practice.recursive.Fibonacci;


public class FibonacciTest {
	@Test
	public void test1(){
		Fibonacci f = new Fibonacci(3);
		assertEquals(2 ,f.recor());
		
	}
	
	@Test
	public void test11(){
		Fibonacci f = new Fibonacci(11);
		assertEquals(89 ,f.recor());
		
	}
}
