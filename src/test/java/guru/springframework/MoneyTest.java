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

	@Test
	void testSimpleAddition() {
		Expression five = Money.createDollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Expression reduced = bank.reduce(sum, "USD");
		assertEquals(Money.createDollar(10), reduced);

	}

	@Test
	void testPlusReturnsSum() {
		Expression five = Money.createDollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augmend);
		assertEquals(five, sum.addmend);
	}

	@Test
	void testReduceSum() {
		Expression sum = new Sum(Money.createDollar(3), Money.createDollar(4));
		Bank bank = new Bank();
		Expression result = bank.reduce(sum, Money.USD_CURRENCY_CODE);
		assertEquals(Money.createDollar(7), result);
	}

	@Test
	void testReduceMoney() {
		Bank bank = new Bank();
		Expression result = bank.reduce(Money.createDollar(1), Money.USD_CURRENCY_CODE);
		assertEquals(Money.createDollar(1), result);
	}

	@Test
	void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate(Money.EUR_CURRENCY_CODE, Money.USD_CURRENCY_CODE, 2);
		Expression result = bank.reduce(Money.createEuro(2), Money.USD_CURRENCY_CODE);
		assertEquals(Money.createDollar(1), result);
	}

	@Test
	void testIdentityRate() {
		assertEquals(1, new Bank().rate(Money.USD_CURRENCY_CODE, Money.USD_CURRENCY_CODE));
		assertEquals(1, new Bank().rate(Money.EUR_CURRENCY_CODE, Money.EUR_CURRENCY_CODE));
	}

	@Test
	public void testMixedAddition() {
		Expression fiveBucks = Money.createDollar(5);
		Expression tenFrancs = Money.createEuro(10);
		Bank bank = new Bank();
		bank.addRate(Money.EUR_CURRENCY_CODE, Money.USD_CURRENCY_CODE, 2);
		Expression result = bank.reduce(fiveBucks.plus(tenFrancs), Money.USD_CURRENCY_CODE);
		assertEquals(Money.createDollar(10), result);
	}
}
