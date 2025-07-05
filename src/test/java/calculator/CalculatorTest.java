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
}
