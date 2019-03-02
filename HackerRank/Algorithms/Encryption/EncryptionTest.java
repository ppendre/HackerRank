package Encryption;

import static org.junit.Assert.*;

import org.junit.*;

public class EncryptionTest {

	@Test
	public void testEncryptionHR1() {
		assertEquals("hae and via ecy", Solution.encryption("haveaniceday"));
	}
	
	@Test
	public void testEncryptionHR2() {
		assertEquals("fto ehg ee dd", Solution.encryption("feedthedog"));
	}

	@Test
	public void testEncryptionHR3() {
		assertEquals("clu hlt io", Solution.encryption("chillout"));
	}
}
