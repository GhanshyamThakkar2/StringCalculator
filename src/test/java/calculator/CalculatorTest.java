package calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest
{
    @Test
    public void testEmptyStringReturnsZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.add(""));
    }
    @Test
    public void testSingleNumberReturnsValue() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.add("1"));
    }
    @Test
    public void testTwoNumbersCommaSeparated() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.add("1,2"));
    }
    @Test
    public void testMultipleNumbersReturnsSum() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.add("1,2,3,4,5"));
    }
    @Test
    public void testNewlineAsSeparator() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
//    @Test(expected = IllegalArgumentException.class)
//    public void testInvalidDelimiterSequenceThrowsException() {
//        Calculator calc = new Calculator();
//        calc.add("1,\n");  // This should trigger the validation and throw an exception
//    }
    @Test
    public void testCustomDelimiter() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumberThrowsException() {
        Calculator calc = new Calculator();
        calc.add("1,-2,3");
    }
    @Test
    public void testNumbersGreaterThanThousandAreIgnored() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add("2,1001"));
        assertEquals(1002, calc.add("2,1000")); // 1000 is allowed
    }
    @Test
    public void testMultiCharacterDelimiter() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }
    @Test
    public void testMultipleDelimiters() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testMultipleLongDelimiters() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add("//[***][%%]\n1***2%%3***4"));
    }

}
