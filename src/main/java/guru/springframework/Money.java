package guru.springframework;

import lombok.ToString;

@ToString
public class Money implements Expression {

	public final static String USD_CURRENCY_CODE = "USD";
	public final static String EUR_CURRENCY_CODE = "EUR";

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	protected String getCurrency() {
		return this.currency;
	}

	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.amount == money.amount && this.currency == money.currency;
	}

	public static Money createDollar(int amount) {
		return new Money(amount, USD_CURRENCY_CODE);
	}

	public static Money createEuro(int amount) {
		return new Money(amount, EUR_CURRENCY_CODE);
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier, this.currency);
	}

	@Override
	public Money reduce(Bank bank,String toCurrency) {
		return new Money(amount/bank.rate(this.currency, toCurrency), toCurrency);
	}

	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}

}
