package guru.springframework;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Euro {
	
	private int amount;

	Euro times(int multiplier) {
		return new Euro(amount * multiplier);
	}
	
	@Override
	public boolean equals(Object obj) {
		Euro euro = (Euro)obj;
		return this.amount == euro.amount;
	}

}
