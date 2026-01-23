Stream Methods
To solve **String DSA problems using Java Streams**, you can leverage the **Stream API** for functional-style, concise, and readable operations.  Below are the **most useful stream operations** applied to string manipulation in data structures and algorithms:

---

### 🔧 Core Stream Operations for String DSA

#### 1. **Convert String to Stream of Characters**
Use `chars()` or `codePoints()` to process each character.

```java
String str = "hello";
str.chars().forEach(System.out::println); // Prints ASCII values
```

For actual `Character` objects:
```java
str.chars()
   .mapToObj(c -> (char) c)
   .collect(Collectors.toList());
```

> ✅ Use `codePoints()` for full Unicode (e.g., emojis), as `chars()` treats surrogate pairs incorrectly.

---

#### 2. **Filter Characters**
Remove unwanted characters (e.g., non-alphabetic, spaces).

```java
String cleaned = str.chars()
    .filter(Character::isLetter)
    .mapToObj(c -> String.valueOf((char) c))
    .collect(Collectors.joining());
```

---

#### 3. **Map / Transform Characters**
Modify each character (e.g., uppercase, shift cipher).

```java
String upper = str.chars()
    .mapToObj(c -> String.valueOf((char) c).toUpperCase())
    .collect(Collectors.joining());
```

---

#### 4. **Collectors.joining() – Build Strings**
Combine stream elements into a single string.

```java
List<String> words = Arrays.asList("Java", "Stream", "API");
String result = words.stream()
    .collect(Collectors.joining(" ")); // "Java Stream API"
```

With prefix/suffix:
```java
.collect(Collectors.joining(", ", "[", "]")); // [a, b, c]
```

---

#### 5. **Grouping / Frequency Count**
Count character frequency (common in anagram problems).

```java
Map<Character, Long> freq = str.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
```

---

#### 6. **Check Conditions with Matching**
Use `anyMatch`, `allMatch`, `noneMatch` for validations.

```java
boolean hasDigit = str.chars().anyMatch(Character::isDigit);
boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
// Or with streams (advanced): compare char[i] with char[n-1-i]
```

---

#### 7. **Sorting Characters**
Sort characters in a string.

```java
String sorted = str.chars()
    .sorted()
    .mapToObj(c -> String.valueOf((char) c))
    .collect(Collectors.joining());
```

---

#### 8. **Split & Process Substrings**
Split string and process parts.

```java
Arrays.stream(str.split(" "))
      .filter(word -> word.length() > 3)
      .forEach(System.out::println);
```

---

#### 9. **Reduction with reduce()**
Combine characters or values.

```java
Optional<String> reduced = Stream.of("a", "b", "c")
    .reduce((a, b) -> a + "-" + b); // "a-b-c"
```

---

#### 10. **Partitioning**
Split based on condition (e.g., vowels vs consonants).

```java
Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
Map<Boolean, List<Character>> vowelConsonant = str.toLowerCase().chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.partitioningBy(c -> vowels.contains(c)));
```

---

### 📌 Common DSA String Problems Using Streams
| Problem | Stream-Based Approach |
|--------|------------------------|
| **Remove non-letters** | `filter(Character::isLetter)` + `joining()` |
| **Check palindrome** | Compare original vs reversed (use `StringBuilder`, not streams directly) |
| **Anagram check** | Sort characters using stream and compare |
| **Character frequency** | `groupingBy` + `counting()` |
| **First non-repeating char** | `groupingBy` + `counting()`, then `filter(entry -> entry.getValue() == 1)` |
| **String compression** | Use `groupingBy` or custom collector to count consecutive chars |

---

### ⚠️ Limitations & Notes
- **Strings are immutable**: Streams don’t modify original string.
- **Performance**: Streams add overhead; prefer loops for simple cases.
- **Unicode**: Use `codePoints()` instead of `chars()` for full Unicode support (e.g., emojis).

---






