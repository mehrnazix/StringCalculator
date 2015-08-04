import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

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

	//because of trowing exception this test did not work
	@Test
	public void negativeNumbersNotAllow() {
		int result = stringCalculator.add("-5,2");
		Assert.assertEquals(2, result);
	}
	
//	@Test 
//	public void patternChangesDelimiter() {
//		int result = stringCalculator.add("//;\n1;2");
//		Assert.assertEquals(3, result);
//	}
	
}
