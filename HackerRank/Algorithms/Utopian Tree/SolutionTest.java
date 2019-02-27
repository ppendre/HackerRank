import static org.junit.Assert.*;

import org.junit.*;

public class SolutionTest {

	@Test
	public void testHR1_1() {
		assertEquals(1, Solution.utopianTree(0));		
	}
	
	@Test
	public void testHR1_2() {
		assertEquals(2, Solution.utopianTree(1));		
	}
	
	@Test
	public void testHR1_3() {
		assertEquals(7, Solution.utopianTree(4));		
	}

}
