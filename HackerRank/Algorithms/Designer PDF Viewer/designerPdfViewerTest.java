package DesignerPDFViewer;

import static org.junit.Assert.*;
import org.junit.*;

public class designerPdfViewerTest {

	@Test
	public void testHR1() {
		assertEquals(9, Solution.designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5,
					5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "abc"));		
	}

	@Test
	public void testHR2() {
		assertEquals(28, Solution.designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5,
					5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, "zaba"));		
	}
	
	@Test
	public void testZeroLengthString_should_Zero() {
		assertEquals(0, Solution.designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5,
					5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, ""));		
	}
}
