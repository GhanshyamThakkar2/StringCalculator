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
    public void testNewlineAsSeparator() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
}
