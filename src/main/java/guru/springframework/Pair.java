package guru.springframework;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Pair {

	private final String from;
	private final String to;

	public Pair(String from, String to) {
		this.from = from;
		this.to = to;
	}

}
