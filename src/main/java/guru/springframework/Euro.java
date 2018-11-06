package guru.springframework;


public class Euro extends Money {

	public Euro(int amount) {
		this.amount = amount;
	}

	Euro times(int multiplier) {
		return new Euro(this.amount * multiplier);
	}

}
