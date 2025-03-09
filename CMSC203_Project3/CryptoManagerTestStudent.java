
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertTrue(CryptoManager.isStringInBounds("\"TODAY IS SATURDAY\""));
		assertFalse(CryptoManager.isStringInBounds("hello"));
		assertFalse(CryptoManager.isStringInBounds("{HELLO"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hello", 4));
		assertEquals("HIJ", CryptoManager.caesarEncryption("DEF", 4));
		assertEquals("%&'", CryptoManager.caesarEncryption("DEF", 97));
		assertEquals("199.,C/", CryptoManager.caesarEncryption("GOODBYE", 106));
		assertEquals("UWPFC[", CryptoManager.caesarEncryption("SUNDAY", 2));
		assertEquals("MX$MW$EPQSWX$WTVMRK$FVIEO", CryptoManager.caesarEncryption("IT IS ALMOST SPRING BREAK", 4));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("SUNDAY", CryptoManager.caesarDecryption("UWPFC[", 2));
		assertEquals("SPRING BREAK IS CLOSE", CryptoManager.caesarDecryption(";8:16/H*:-)3H1;H+47;-", 1000));
		assertEquals("GOODBYE WORLD", CryptoManager.caesarDecryption("4<<1/F2MD<?91", 301));
		assertEquals("SPRING BREAK IS NEAR", CryptoManager.caesarDecryption("WTVMRK$FVIEO$MW$RIEV", 4));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("K SP$ X F", CryptoManager.bellasoEncryption("BARCELONA", "I_AM_TIRED"));
		assertEquals("OP_T[9SL&/]GZW", CryptoManager.bellasoEncryption("HAPPY NEW YEAR", "GOODBYE"));
		assertEquals("V!+QD@RVU4_2KR Q&Q??ROSYI<", CryptoManager.bellasoEncryption("I WISH IT WAS SPRING BREAK", "MATH182"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("BARCELONA", CryptoManager.bellasoDecryption("K SP$ X F", "I_AM_TIRED"));
		assertEquals("HAPPY NEW YEAR", CryptoManager.bellasoDecryption("OP_T[9SL&/]GZW", "GOODBYE"));
		assertEquals("I WISH IT WAS SPRING BREAK", CryptoManager.bellasoDecryption("V!+QD@RVU4_2KR Q&Q??ROSYI<", "MATH182"));

	}

}
