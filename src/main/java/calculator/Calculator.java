package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty())
        {
            return 0;
        }
        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            String[] parts = numbers.split("\n", 2);
            String delimiterPart = parts[0].substring(2);

            // Check if delimiter is in the format
            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]"))
            {
                // Remove brackets and escape special regex characters
                delimiter = java.util.regex.Pattern.quote(delimiterPart.substring(1, delimiterPart.length() - 1));
            }
            else
            {
                // Single character delimiter
                delimiter = delimiterPart;
            }
            numbers = parts[1];
        }

        // Validation for invalid input like "1,\n"
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
            else if (num <= 1000) // Ignore numbers greater than 1000
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
