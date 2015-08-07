import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	
	StringCalculator stringCalculator;
	@Before
	public void setup ()
	{
		stringCalculator = new StringCalculator();
	}
		
	@Test
	public void emptyStringReturnZero () {
		int result = stringCalculator.add(" ");
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void oneNumberReturnItSelf () {
		int result = stringCalculator.add("232");
		Assert.assertEquals(232, result);
	}
	
	@Test
	public void returnSumOfNumbers () {
		int result = stringCalculator.add("12,4");
		Assert.assertEquals(16, result);
	}
	
	@Test
	public void handleTwoTypeOfDelimiters() {
		int result = stringCalculator.add("3\n7,1");
		Assert.assertEquals(11, result);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void negativeNumbersNotAllow() {
		exception.expect(IllegalArgumentException.class);
		stringCalculator.add("-5,2");
	}
	
	@Test 
	public void patternChangesDelimiter() {
		int result = stringCalculator.add("//;\n1;2");
		Assert.assertEquals(";", stringCalculator.delimiter);
	}
	
	@Test
	public void numbersBiggerThan1000ShouldBeIgnored() {
		int result = stringCalculator.add("1002,5");
		Assert.assertEquals(5, result);
	}
	
	@Test
	public void patternWithSeveralDelimiterShouldBeSupported() {
		int result = stringCalculator.add("//[***][%]\n1*2%3");
		Assert.assertEquals("[***][%]", stringCalculator.delimiter);
	}
	
	@Test
	public void severalDelimiterShouldBeReturnCorrectSum() {
		int result = stringCalculator.add("//[***][%]\n1*2%3");
		Assert.assertEquals(6, result);
	}
}
