package guru.springframework;

import lombok.AllArgsConstructor;

public abstract class Money {

	private final static String USD_CURRENCY_CODE = "USD";
	private final static String EUR_CURRENCY_CODE = "EUR";

	protected int amount;
	protected String currency;


	public abstract Money times(int multiplier);

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
		return this.amount == money.amount && this.getClass() == obj.getClass();
	}

	public static Money createDollar(int amount) {
		return new Dollar(amount, USD_CURRENCY_CODE);
	}

	public static Money createEuro(int amount) {
		return new Euro(amount, EUR_CURRENCY_CODE);
	}
}
