package BiggerisGreater;

import static org.junit.Assert.*;

import org.junit.*;

public class BiggerisGreaterTest {

	@Test
	public void testHR11() {
		assertEquals("lmon", Solution.biggerIsGreater("lmno"));
	}
	
	@Test
	public void testHR12() {
		assertEquals("no answer", Solution.biggerIsGreater("dcba"));
	}
	
	@Test
	public void testHR13() {
		assertEquals("no answer", Solution.biggerIsGreater("dcbb"));
	}
	
	@Test
	public void testHR14() {
		assertEquals("acbd", Solution.biggerIsGreater("abdc"));
	}
	
	@Test
	public void testHR15() {
		assertEquals("abdc", Solution.biggerIsGreater("abcd"));
	}
	
	@Test
	public void testHR16() {
		assertEquals("fedcbabdc", Solution.biggerIsGreater("fedcbabcd"));
	}
	
	@Test
	public void testHR31() {
		assertEquals("imllmmcslslkyoegyoam", Solution.biggerIsGreater("imllmmcslslkyoegymoa"));
	}

}
