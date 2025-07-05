<h1>String Calculator in Java</h1>

<p>This project is a simple <strong>String Calculator</strong> built in Java, following the rules and progressive steps of the popular String Calculator Kata.</p>

<p>The calculator is able to:</p>
<ul>
    <li>Add numbers provided as strings.</li>
    <li>Support custom delimiters.</li>
    <li>Handle multiple delimiters.</li>
    <li>Ignore numbers greater than 1000.</li>
    <li>Detect and throw exceptions for negative numbers.</li>
    <li>Validate and reject incorrectly formatted input.</li>
</ul>

<h2>Features Implemented</h2>

<ol>
    <li><strong>Empty String Returns 0</strong><br>
        Example: <code>"" → 0</code>
    </li>
    <br>
    <li><strong>Single Number Returns Its Value</strong><br>
        Example: <code>"5" → 5</code>
    </li>
    <br>
    <li><strong>Sum of Two or More Numbers (Comma or Newline Separated)</strong><br>
        Example: <code>"1,2" → 3</code><br>
        Example: <code>"1\n2,3" → 6</code>
    </li>
    <br>
    <li><strong>Support Custom Single-Character Delimiters</strong><br>
        Example: <code>"//;\n1;2" → 3</code>
    </li>
    <br>
    <li><strong>Reject Invalid Input (e.g. "1,\n")(This is commented)</strong><br>
        Example: <code>"1,\n"</code> throws <code>IllegalArgumentException</code>
    </li>
    <br>
    <li><strong>Ignore Numbers Greater Than 1000</strong><br>
        Example: <code>"2,1001" → 2</code>
    </li>
    <br>
    <li><strong>Support Custom Multi-Character Delimiters</strong><br>
        Example: <code>"//[***]\n1***2***3" → 6</code>
    </li>
    <br>
    <li><strong>Support Multiple Delimiters of Any Length</strong><br>
        Example: <code>"//[*][%%]\n1*2%%3" → 6</code>
    </li>
    <br>
    <li><strong>Throw Exception on Negative Numbers and List Them</strong><br>
        Example: <code>"1,-2,3,-4"</code> throws <code>IllegalArgumentException: Negative numbers not allowed: -2, -4</code>
    </li>
</ol>
<h2>Test Execution Screenshot</h2>
<p>All test cases pass successfully:</p>
<img src="https://github.com/GhanshyamThakkar2/StringCalculator/raw/main/Test%20cases%20are%20passed.png" alt="Test Cases Passed" />



