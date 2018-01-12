import java.util.ArrayList;
import java.util.stream.IntStream;

import org.junit.Test;


public class TestIntStream {

	@Test
	public void testArray(){
		
		ArrayList<String> list = new ArrayList<String>(10);
		String str = "aaa";
		list.add(list.indexOf(str), str);
		
		
	}
	
//	@Test
	public void test() {
//		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
//		
//		int batchSize = 4;
//		
//		IntStream.iterate(0, i -> i + 3)
//		.limit(10).boxed().forEach(System.out::println);
		
		IntStream.rangeClosed(0 , 100).forEach(i ->{
			StringBuffer bfr= new StringBuffer();
			if(i % 3 == 0 )
				bfr.append("Fizz");
			if(i % 5 == 0 )
				bfr.append("Buzz");
			if(i % 3 != 0 && i % 5 != 0 )
				bfr.append(i);
			
			System.out.println(bfr.toString());
			
		});
		
		
//		IntStream.rangeClosed(0, (list.size() - 1) / batchSize).boxed().
//				forEach(i -> {
//					int start = batchSize * i;
//					int end = batchSize * i + batchSize;
//					if(end > list.size()){
//						end = list.size();
//					}
//					System.out.println("here");
//					System.out.println(list.subList(start , end));
//					
//				}
//				);
	}

}
