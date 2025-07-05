package calculator;

public class Calculator
{
    public int add(String numbers) {
        if (numbers.isEmpty())
        {
            return 0;
        }
        //String numbers = "1,2\n3,4";
        //numArray will be ["1", "2", "3", "4"]
        String[] numArray = numbers.split(",|\n");
        int sum = 0;
        for (String numStr : numArray)
        {
            sum += Integer.parseInt(numStr.trim());
        }
        return sum;
    }
}
