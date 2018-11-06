package guru.springframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void testMultiplicationDollar() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		assertEquals(new Dollar(10), product);
		product = five.times(3);
		assertEquals(new Dollar(15), product);
	}

	@Test
	void testEqualityDollar() {
		assertEquals(new Dollar(5), new Dollar(5));

		assertNotEquals(new Dollar(5), new Dollar(8));

	}

	@Test
	void testMultiplicationEuro() {
		Euro five = new Euro(5);
		Euro product = five.times(2);
		assertEquals(new Euro(10), product);
		product = five.times(3);
		assertEquals(new Euro(15), product);
	}

	@Test
	void testEqualityEuro() {
		assertEquals(new Euro(5), new Euro(5));

		assertNotEquals(new Euro(5), new Euro(8));


	}
}
