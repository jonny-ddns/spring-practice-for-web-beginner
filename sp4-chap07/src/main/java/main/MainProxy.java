package main;

import aopTest.ExeTimeCalculator;
import aopTest.ImpeCalculator;
import aopTest.RecCalculator;

public class MainProxy {
	public static void main(String[] args) {
		int number = 20;
		
		ExeTimeCalculator cal01 = new ExeTimeCalculator(new ImpeCalculator());
		ExeTimeCalculator cal02 = new ExeTimeCalculator(new RecCalculator());
		
		cal01.factororial(number);
		cal02.factororial(number);
	}
}
