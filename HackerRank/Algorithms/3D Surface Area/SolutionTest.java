import static org.junit.Assert.*;

import org.junit.*;

public class SolutionTest {

	@Test
	public void testSurfaceAreaOneCube() {
		assertEquals(6, Solution.surfaceArea(new int[][]{{1}}));		
	}
	
	@Test
	public void testSurfaceAreaHR1() {
		assertEquals(60, Solution.surfaceArea(new int[][]{{1, 3, 4}, {2, 2, 3}, {1, 2, 4}}));		
	}
}
