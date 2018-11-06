package guru.springframework;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor

public class Dollar {

	private int amount;

	Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}

	@Override
	public boolean equals(Object  obj) {
		Dollar dollar = (Dollar) obj;
		return this.amount == dollar.amount;
	}

}
