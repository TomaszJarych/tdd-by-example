package guru.springframework;

public class Sum implements Expression {
	
	protected Money augmend;
	protected Money addmend;
	
	public Sum(Money augmend, Money addmend) {
		super();
		this.augmend = augmend;
		this.addmend = addmend;
	}


	public Money reduce(Bank bank,String toCurrency) {
		int amount = augmend.amount + addmend.amount;
		return new Money(amount, toCurrency);
	}
	
	
	

}
