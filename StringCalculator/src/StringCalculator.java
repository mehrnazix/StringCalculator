import java.io.IOException;

import javax.swing.SwingUtilities;

public class StringCalculator {
	public int sum;
	public char delimiter;


	public static void main(String[] args) {
		StringCalculator stringCalc = new StringCalculator();
		System.out.println(stringCalc.add("-4,2"));
	}
	
	public int add(String string) {
		
		String numbers[] = string.split(",|\n");
		
		int negativeNums[] = null; 
		
		for (int i = 0; i < numbers.length; i++) {
			int number = 0;
			try {
				number = Integer.parseInt(numbers[i]);
			} catch (Exception e) {
				sum += 0;
			}
			if (number > 0) {					
				sum += number;
			}
			if (number < 0) {
				negativeNums[i]= number;
				throw new IllegalArgumentException("negatives not allowed");
			}
		}
		
		if (negativeNums.length > 1) {
			throw new IllegalArgumentException("negatives not allowed");
		}
		return sum;
	}
}
