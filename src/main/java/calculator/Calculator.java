package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String numbers)
    {
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

        // 🚩 Validation for invalid input like "1,\n"
        if (numbers.contains(",\n") || numbers.contains("\n,"))
        {
            throw new IllegalArgumentException("Invalid input: Delimiter followed by a newline or empty value.");
        }

        String[] numArray = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String numStr : numArray)
        {
            if (numStr.isEmpty())
            {
                continue;
            }

            int num = Integer.parseInt(numStr.trim());

            if (num < 0)
            {
                negatives.add(num);
            }
            else if (num <= 1000) // 🚀 Ignore numbers greater than 1000
            {
                sum += num;
            }
        }

        if (!negatives.isEmpty())
        {
            String negativeList = negatives.toString().replace("[", "").replace("]", "");
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeList);
        }

        return sum;
    }

}
