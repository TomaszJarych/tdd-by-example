package guru.springframework;

public interface Expression {
	
//	Expression plus(Money amount);
	
	Money reduce(Bank bank, String toCurrency);

}
