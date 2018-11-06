package guru.springframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void testMultiplication() {
		Money five = Money.createDollar(5);
		assertEquals(Money.createDollar(10), five.times(2));
		Money fiveEuro = Money.createEuro(5);
		assertEquals(Money.createEuro(10), fiveEuro.times(2));
	}

	@Test
	void testEquality() {
		assertEquals(Money.createDollar(5), Money.createDollar(5));
		assertNotEquals(Money.createDollar(5), Money.createDollar(8));
		assertEquals(Money.createEuro(5), Money.createEuro(5));
		assertNotEquals(Money.createEuro(5), Money.createEuro(8));
		assertNotEquals(Money.createEuro(5), Money.createDollar(5));
		

	}

	@Test
	void testCurrency() {
		assertEquals("USD", Money.createDollar(1).getCurrency());
		assertEquals("EUR", Money.createEuro(1).getCurrency());
	}
}
