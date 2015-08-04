import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

public class StringCalculator {
	public int sum;
	public String delimiter;


	public static void main(String[] args) {
		StringCalculator stringCalc = new StringCalculator();
		System.out.println(stringCalc.add("//;\n2;5"));
	}
	
	public int add(String string) {
		
		String negatives = "";
		int number = 0;
		
		Pattern p = Pattern.compile("^/{2}[;,:?]+\\n+.+");
		Matcher matcher = p.matcher(string);
		
		String numbers[] = null;
		
		if (matcher.find()) {
			delimiter = "" + string.charAt(2);
			numbers = string.split(delimiter);
		} else {
			numbers = string.split(",|\n");
			
		}
				
		for (int i = 0; i < numbers.length; i++) {
			try {
				number = Integer.parseInt(numbers[i]);
			} catch (Exception e) {
				sum += 0;
			}
			if (number > 0) {					
				sum += number;
			}
			if (number < 0) {
				negatives += " " + number;
			}
		}
		if (negatives.length() > 1) {
			
			throw new IllegalArgumentException("negatives not allowed" + negatives);
		}
		
		return sum;
	}
}
