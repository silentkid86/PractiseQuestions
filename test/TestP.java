//import static java.util.Arrays.asList;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.junit.Test;
//
//import com.silentkid.practice.P;
//
//public class TestP {
//
//	@Test
//	public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
//	    assertThat(P.last(asList("a", "b", "c", "d")), is(equalTo("d")));
//	}
//
//
//	@Test
//	public void shouldFindSecondLastElementFromAList() throws Exception {
//	    List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
//	    assertThat(P.secondLast(numbers), is(equalTo(10)));
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void shouldThrowExceptionWhenListEmpty() throws Exception {
//	    P.secondLast(Collections.emptyList());
//	}
//
//	@Test(expected = NoSuchElementException.class)
//	public void shouldThrowExceptionWhenListHasSingleElement() throws Exception {
//	    P.secondLast(Arrays.asList(1));
//	}
//
//}
