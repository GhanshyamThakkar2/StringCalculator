package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{
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
            String delimiterPart = parts[0].substring(2);

            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]"))
            {
                // Multiple delimiters case
                List<String> delimiters = new ArrayList<>();
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);

                while (matcher.find())
                {
                    delimiters.add(java.util.regex.Pattern.quote(matcher.group(1))); // Safely handle special characters
                }

                // Join all delimiters with | for regex splitting
                delimiter = String.join("|", delimiters);
            }
            else
            {
                // Single character delimiter
                delimiter = java.util.regex.Pattern.quote(delimiterPart);
            }

            numbers = parts[1];
        }

        // Invalid input pattern like "1,\n"
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
