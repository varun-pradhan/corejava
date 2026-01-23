String Methods
Here are the **most important String methods in Java**, commonly used for string manipulation:

### Core String Methods
- **`charAt(int index)`**: Returns the character at the specified index.
- **`length()`**: Returns the number of characters in the string.
- **`substring(int beginIndex)` / `substring(int beginIndex, int endIndex)`**: Extracts a portion of the string.
- **`concat(String str)`**: Appends the specified string to the end.
- **`indexOf(String str)` / `lastIndexOf(String str)`**: Returns the index of the first or last occurrence of the specified substring.

### Comparison & Equality
- **`equals(Object obj)`**: Compares strings for exact content equality (case-sensitive).
- **`equalsIgnoreCase(String str)`**: Compares strings ignoring case.
- **`compareTo(String str)`**: Compares strings lexicographically.
- **`startsWith(String prefix)` / `endsWith(String suffix)`**: Checks if the string starts or ends with the specified value.

### Case & Formatting
- **`toUpperCase()` / `toLowerCase()`**: Converts all characters to upper or lower case.
- **`trim()` / `strip()`**: Removes leading and trailing whitespace (`strip()` is newer and supports Unicode).

### Search & Replace
- **`contains(CharSequence s)`**: Returns `true` if the string contains the specified sequence.
- **`replace(char old, char new)` / `replaceAll(String regex, String replacement)`**: Replaces characters or substrings (supports regex in `replaceAll`).
- **`replaceFirst(String regex, String replacement)`**: Replaces only the first match of the regex.

### Conversion & Splitting
- **`split(String regex)`**: Splits the string into an array using the given delimiter (regex).
- **`toCharArray()`**: Converts the string into a character array.
- **`valueOf()`**: Converts various data types (int, char[], boolean, etc.) to a string.






