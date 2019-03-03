package OrganizingContainersofBalls;

import static org.junit.Assert.*;

import org.junit.*;

public class OrganizingContainersofBallsTest {

	@Test
	public void testHR1() {
		assertEquals("Possible", Solution.organizingContainers(new int[][]{{1, 1}, {1, 1}}));
	}
	
	@Test
	public void testHR2() {
		assertEquals("Impossible", Solution.organizingContainers(new int[][]{{0, 2}, {1, 1}}));
	}

	@Test
	public void testHR3() {
		assertEquals("Impossible", Solution.organizingContainers(new int[][]{{1, 3, 1}, {2, 1, 2}, {3, 3, 3}}));
	}
	
	@Test
	public void testHR4() {
		assertEquals("Possible", Solution.organizingContainers(new int[][]{{0, 2, 1}, {1, 1, 1}, {2, 0, 0}}));
	}
}
