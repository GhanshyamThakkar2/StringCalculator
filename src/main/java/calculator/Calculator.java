package calculator;

public class Calculator
{
    public int add(String numbers) {
        if (numbers.isEmpty())
        {
            return 0;
        }
        if (numbers.contains(","))
        {
            String[] numArray = numbers.split(",");
            int sum = 0;
            for (String numStr : numArray)
            {
                sum += Integer.parseInt(numStr.trim());
            }
            return sum;
        }
        return Integer.parseInt(numbers);
    }
}
