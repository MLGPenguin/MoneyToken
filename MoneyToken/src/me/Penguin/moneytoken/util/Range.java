package me.Penguin.moneytoken.util;

import java.util.Random;

public class Range {	
	
	private int min, max;
	
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int getRandom() {
		return (new Random().nextInt(max-min) + min);
	}

}
