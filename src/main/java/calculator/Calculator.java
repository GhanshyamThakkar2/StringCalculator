package calculator;

public class Calculator
{
    public int add(String numbers) {
        if (numbers.isEmpty())
        {
            return 0;
        }

        String delimiter = ",|\n";
        if (numbers.startsWith("//"))
        {
            String[] parts = numbers.split("\n", 2);
            delimiter = parts[0].substring(2);
            numbers = parts[1];
        }

        String[] numArray = numbers.split(delimiter);
        int sum = 0;
        for (String numStr : numArray)
        {
            sum += Integer.parseInt(numStr.trim());
        }
        return sum;
    }
}
