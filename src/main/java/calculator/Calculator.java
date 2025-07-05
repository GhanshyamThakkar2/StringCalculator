package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Calculator that adds numbers provided in a string.
 * <p>
 * Supports:
 * - Comma and newline as default delimiters.
 * - Custom single or multiple delimiters.
 * - Ignores numbers greater than 1000.
 * - Throws exceptions for negative numbers.
 * - Validates against invalid input patterns.
 * </p>
 */
public class Calculator {

    /** Default delimiter: Comma or newline. */
    public static final String DEFAULT_DELIMITER = "[,\n]";

    /**
     * Adds numbers provided in a formatted string.
     *
     * @param input String containing numbers separated by delimiters.
     * @return Sum of valid numbers.
     * @throws IllegalArgumentException if input contains negative numbers or invalid delimiter patterns.
     */
    public long add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;

        if (input.startsWith("//")) {
            delimiter = extractDelimiters(input);
            input = extractRelevantInput(input);
        }

        validateInput(input);

        String[] numArray = input.split(delimiter);
        return calculateSum(numArray);
    }

    /**
     * Extracts custom delimiters from the input string.
     *
     * @param input Full input string starting with custom delimiter definition.
     * @return Regular expression string for splitting by custom delimiters.
     */
    private String extractDelimiters(String input) {
        String delimiterPart = input.split("\n")[0].substring(2);

        if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
            List<String> delimiters = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);

            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }
            return String.join("|", delimiters);
        } else {
            return Pattern.quote(delimiterPart);
        }
    }

    /**
     * Extracts the number section from the input string.
     *
     * @param input Full input string starting with delimiter definition.
     * @return Substring containing only the numbers.
     */
    private String extractRelevantInput(String input) {
        return input.split("\n")[1];
    }

    /**
     * Validates the input string for invalid delimiter-newline patterns.
     *
     * @param input Input string to validate.
     * @throws IllegalArgumentException if the input has a comma directly followed by a newline or vice versa.
     */
    private void validateInput(String input) {
        if (input.contains(",\n") || input.contains("\n,")) {
            throw new IllegalArgumentException("Invalid input: Delimiter followed by a newline or empty value.");
        }
    }

    /**
     * Calculates the sum of numbers, ignoring numbers greater than 1000 and handling negative numbers.
     *
     * @param numArray Array of string numbers to process.
     * @return Sum of valid numbers.
     * @throws IllegalArgumentException if negative numbers are found.
     */
    private long calculateSum(String[] numArray) {
        long sum = 0;
        List<Long> negatives = new ArrayList<>();

        for (String numStr : numArray) {
            if (numStr.isEmpty()) continue;

            long num = Long.parseLong(numStr.trim());

            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            String negativeList = negatives.toString().replace("[", "").replace("]", "");
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeList);
        }

        return sum;
    }
}
