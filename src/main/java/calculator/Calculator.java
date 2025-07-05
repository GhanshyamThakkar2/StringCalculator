package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return Integer.parseInt(numbers);
    }
}
