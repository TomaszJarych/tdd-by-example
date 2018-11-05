package guru.springframework;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Dollar {

	private int amount;

	Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}


	
	
	
}
