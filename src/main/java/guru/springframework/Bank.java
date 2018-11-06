package guru.springframework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

	private Map<Pair, Integer> rateMap = new HashMap<>();

	Money reduce(Expression source, String toCurrency) {
		return source.reduce(this, toCurrency);
	}

	public int rate(String fromCurrency, String toCurrency) {
		if (fromCurrency.equals(toCurrency)) {
			return 1;
		}
		return rateMap.get(new Pair(fromCurrency, toCurrency)).intValue();
	}

	public void addRate(String fromCurrency, String toCurrency, int rate) {
		rateMap.put(new Pair(fromCurrency, toCurrency), rate);

	}

}
