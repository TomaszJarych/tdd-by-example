package guru.springframework;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Dollar {

	private int amount;

	Dollar times(int multiplier) {

		return new Dollar(amount*multiplier);
	}
}
