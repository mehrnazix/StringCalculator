import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

public class StringCalculator {
	private int sum;
	public String delimiter = "";


	public static void main(String[] args) {
		StringCalculator stringCalc = new StringCalculator();
		System.out.println(stringCalc.add("//[***][%]\n1*2%3[$]"));
		System.out.println(stringCalc.delimiter);
	}
	
	public int add(String string) {
		
		String negatives = "";
		int number = 0;
		
		Pattern p = Pattern.compile("^/{2}[;,:?]+\\n+.+");
		Matcher matcher = p.matcher(string);
		List<String> numbers = new ArrayList<String>();

		
		if (matcher.find()) {
			delimiter = Character.toString(string.charAt(2));
		}
		
		
		if (string.indexOf("[") != -1) {
			Pattern muliDelimiterPattern = Pattern.compile("\\[(.*?)\\]");
			Matcher multiDelimiterMatcher = muliDelimiterPattern.matcher(string);
			
			while (multiDelimiterMatcher.find()) {
				delimiter += multiDelimiterMatcher.group();
				
			}
//			if (multiDelimiterMatcher.find()) {
//				delimiter = multiDelimiterMatcher.group();
//			}
		}
		Pattern getNumbersPattern = Pattern.compile("-\\d+|\\d+");
		Matcher getNumbersMatch = getNumbersPattern.matcher(string);
		
		while (getNumbersMatch.find()) {
			numbers.add(getNumbersMatch.group());
			
		}
		
		
		
		
//		if (matcher.find()) {
//			delimiter = "" + string.charAt(2);
//			numbers = string.split(delimiter);
//		} else {
//			numbers = string.split(",|\n");
//			
//		}
				
		for (int i = 0; i < numbers.size(); i++) {
			try {
				number = Integer.parseInt(numbers.get(i));
			} catch (Exception e) {
				sum += 0;
			}
			if (number > 0  && number < 1000) {					
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
