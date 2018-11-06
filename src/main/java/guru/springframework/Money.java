package guru.springframework;

public abstract class Money {

	protected int amount;
	
	protected abstract String getCurrency();
	
	public abstract Money times(int multiplier);

	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.amount == money.amount && this.getClass() == obj.getClass();
	}

	public static Money createDollar(int amount) {
		return new Dollar(amount);
	}

	public static Money createEuro(int amount) {
		return new Euro(amount);
	}
}
