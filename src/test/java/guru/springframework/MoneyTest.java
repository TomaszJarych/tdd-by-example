package guru.springframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void testMultiplication() {
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		assertEquals(10, product.getAmount());
		product = five.times(3);
		assertEquals(15, product.getAmount());
	}
	
	@Test
	void testEquality() {
		assertEquals(new Dollar(5), new Dollar(5));
		
		assertNotEquals(new Dollar(5), new Dollar(8));
		
		assertEquals(new Dollar(5).hashCode(), new Dollar(5).hashCode());
		
	}
}
