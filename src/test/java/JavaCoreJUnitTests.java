import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.Main.*;
import static org.junit.Assert.*;

public class JavaCoreJUnitTests {

    // 1.1

    @Test
    public void testShowInConsole() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 4, 9);
        Stream<Integer> secondStream = Stream.of(1,2,3,4,5,6,7,4,9);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        showStreamInConsole(stream);
        String[] preparedValue = secondStream.map(Object::toString)
                .toArray(String[]::new);

        String[] outputLines = outputStream.toString().split(System.lineSeparator());

        for (int i = 0; i < preparedValue.length; i++) {
            assertEquals(String.valueOf(preparedValue[i]), outputLines[i]);
        }

        System.setOut(System.out);
    }

    // 1.2

    @Test
    public void testGenerateRandomValue() {
        int limit = 10;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        generateRandomStreamValue(limit);

        String[] outputLines = outputStream.toString().split(System.lineSeparator());

        assertEquals(limit, outputLines.length);

        System.setOut(System.out);
    }

    // 1.3

    @Test
    public void testGenerateRandomValueAndReturnToList() {
        int limitNumber = 10;

        List<Integer> numbers = generateAndReturnRandomValue(limitNumber);

        assertEquals(limitNumber,numbers.size());
    }

    @Test
    public void testConvertListToStream() {
        List<Integer> preparedNumbers = List.of(1, 5, 10, 100, 2, 40);

        Stream<Integer> stream = convertListToStream(preparedNumbers);
        List<Integer> actualNumbers = stream.toList();

        assertEquals(preparedNumbers, actualNumbers);
        assertTrue(preparedNumbers.containsAll(actualNumbers));
    }

    @Test
    public void testConvertEmptyListToStream() {
        List<Integer> preparedNumbers = List.of();

        Stream<Integer> stream = convertListToStream(preparedNumbers);

        List<Integer> actualNumbers = stream.toList();

        assertEquals(preparedNumbers, actualNumbers);
        assertTrue(preparedNumbers.containsAll(actualNumbers));
    }

    @Test
    public void testCollectEvenValue() {
        List<Integer> preparedNumbers = List.of(1, 4, 2, 6, 103, 56, 43, 67, 9, 6);

        List<Integer> actualResult = collectEvenValue(preparedNumbers);

        List<Integer> expectedResult = preparedNumbers.stream()
                        .filter(value -> value % 2 == 0)
                        .toList();

        assertEquals(expectedResult, actualResult);
        assertTrue(expectedResult.containsAll(actualResult));
    }

    @Test
    public void testCollectEvenValueWithOnlyOddValue() {
        List<Integer> preparedNumbers = List.of(1, 3, 5, 7, 9, 11);

        List<Integer> actualResult = collectEvenValue(preparedNumbers);

        List<Integer> expectedResult = preparedNumbers.stream()
                .filter(value -> value % 2 == 0)
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    // 2.4

    @Test
    public void testCollectEvenValueAndConvertToArray() {
        List<Integer> preparedNumbers = List.of(1, 3, 5, 7, 9, 10, 2);

        Integer[] actualResult = collectEvenValueToArray(preparedNumbers);

        Integer[] expectedResult = preparedNumbers.stream()
                .filter(value -> value % 2 == 0)
                .toArray(Integer[]::new);

        assertEquals(actualResult.length, expectedResult.length);

        for(int i = 0; i < actualResult.length; i++) {
            assertEquals(expectedResult[i], actualResult[i]);
        }
    }

    // 2.5

    @Test
    public void testCollectValueStartWitchC() {
        List<String> preparedText = List.of("mam", "COMMON", "n2", "d4", "c5", "c0", "h1");

        List<String> actualResult = collectValueStartWithC(preparedText);

        List<String> expectedResult = preparedText.stream()
                .filter(text -> text.toLowerCase().startsWith("c"))
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertAllValueToUpper() {
        List<String> preparedText = List.of("mam", "COMMON", "n2", "d4", "c5", "c0", "h1");

        List<String> actualResult = convertAllValueToUpper(preparedText);

        List<String> expectedResult = preparedText.stream()
                .filter(text -> text.toLowerCase().startsWith("c"))
                .map(String::toUpperCase)
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSortInDescendingOrder() {
        List<String> preparedResult = List.of("mam", "COMMON", "n2", "d4", "c5", "c0", "h1");

        List<String> actualResult = sortInDescendingOrder(preparedResult);

        List<String> expectedResult = preparedResult.stream()
                .filter(text -> text.toLowerCase().startsWith("c"))
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSortInDescendingOrderWithEmptyList() {
        List<String> preparedResult = List.of();

        List<String> actualResult = sortInDescendingOrder(preparedResult);

        assertEquals(preparedResult, actualResult);
        assertNotSame(preparedResult, actualResult);
    }

    // 3.6

    @Test
    public void testDisplayNameThatStartWithA() {
        List<String> preparedName = List.of("Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana");

        List<String> actualResult = namesThatStartWithA(preparedName);

        List<String> expectedResult = preparedName.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNameThatStartWithAWithoutA() {
        List<String> preparedName = List.of("Shekhar", "Rahul", "Salman", "Yana");

        List<String> actualResult = namesThatStartWithA(preparedName);

        List<String> expectedResult = preparedName.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNameThatLongThanFiveSymbols() {
        List<String> preparedName = List.of("Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana");

        List<String> actualResult = nameLongerThanFiveSymbols(preparedName);

        List<String> expectedResult = preparedName.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .filter(name -> name.length() > 5)
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSortedDisplayNamesInConsole() {
        List<String> preparedName = List.of("Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        displaySortedNamesInConsole(preparedName);

        String[] actualResult = outputStream.toString().split(System.lineSeparator());

        String[] expectedResult = preparedName.stream()
                .sorted(String::compareTo)
                .map(String::toLowerCase)
                .toArray(String[]::new);

        assertEquals(expectedResult.length, actualResult.length);

        for(int i = 0; i < actualResult.length; i++) {
            assertEquals(expectedResult[i], actualResult[i]);
        }

        System.setOut(System.out);
    }

    // 3.7

    @Test
    public void testConvertListToArray() {
        List<String> preparedList = List.of("Arsen");

        String[] actualResult = convertListToArray(preparedList);

        String[] expectedResult = preparedList.toArray(String[]::new);

        assertEquals(expectedResult.length, actualResult.length);
    }

    @Test
    public void testConverEmptyListToArray() {
        List<String> preparedList = List.of();

        String[] actualResult = convertListToArray(preparedList);

        String[] expectedResult = preparedList.toArray(String[]::new);

        assertEquals(expectedResult.length, actualResult.length);
    }

    @Test
    public void testAllMtach() {
        String[] preparedName = {"Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana"};

        assertFalse(checkAllMatchThatNameContainLetterS(preparedName));
    }

    @Test
    public void testAnyMatch() {
        String[] preparedName = {"Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana"};

        assertTrue(checkAnyMatchThatNameContainLetterS(preparedName));
    }

    @Test
    public void testNoneMatch() {
        String[] preparedName = {"Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana"};

        assertTrue(checkNoneMatchThatNameContainLetterH(preparedName));
    }

    // 3.9

    @Test
    public void testCountNamesThatStartWithA() {
        List<String> preparedName = List.of("Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana");

        long actualResult = countNamesThatStartWithA(preparedName);

        assertEquals(3, actualResult);
    }

    // 3.10

    @Test
    public void testPrintFirstNameWithLNegative() {
        List<String> preparedName = List.of("Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana");

        String actualResult = printFirstNameWithL(preparedName);

        String expectedResult = "Not found";

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPringFirstNameWithLPositive() {
        List<String> preparedName = List.of("Amitabh", "arsen", "Shekhar", "aman", "Rahul", "Salman", "Yana", "Laminat");

        String actualResult = printFirstNameWithL(preparedName);

        String expectedResult = "Laminat";

        assertEquals(expectedResult, actualResult);
    }

    // 4.11

    @Test
    public void testConcatenateListInToOne() {
        List<Integer> firstPreparedList = List.of(1,2,3);
        List<Integer> secondPreparedList = List.of(4,5,6);
        List<Integer> thirdPreparedList = List.of(7,8,9);

        List<Integer> actualResult = concatenateListInToOne(firstPreparedList,secondPreparedList,thirdPreparedList);

        List<Integer> expectedResult = Stream.of(firstPreparedList, secondPreparedList, thirdPreparedList)
                .flatMap(Collection::stream)
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertComplexIntoSimple() {
        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};

        String[] actualResult = convertComplexIntoSimple(dataArray);

        String[] expectedResult = Arrays.stream(dataArray)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);

        assertEquals(expectedResult.length, actualResult.length);

        for(int i = 0; i < actualResult.length; i++) {
            assertEquals(expectedResult[i], actualResult[i]);
        }
    }

    // 4.12

    @Test
    public void testFindUniqueNumbers() {
        ArrayList<Integer> preparedNumbers = new ArrayList<>(Arrays.asList(1, 1, 5, 3, 5, 8, 4));

        List<Integer> actualResult = findUniqueNumbers(preparedNumbers);

        List<Integer> expectedResult = preparedNumbers.stream()
                .distinct()
                .toList();

        assertEquals(expectedResult, actualResult);
    }

    // 4.13

    @Test
    public void testCountingElement() {
        ArrayList<Integer> preparedNumbers = new ArrayList<>(Arrays.asList(1, 1, 5, 3, 5, 8, 4));

        Map<Integer, Long> actualResult = countingElement(preparedNumbers);

        Map<Integer, Long> expectedResult = preparedNumbers.stream()
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()));

        assertEquals(expectedResult.size(), actualResult.size());

        for(int key : actualResult.keySet()) {
            assertEquals(expectedResult.get(key), actualResult.get(key));
        }
    }

    // 5.14

    @Test
    public void testFindLetterInValue() {
        Map<String, List<String>> preparedData = new HashMap<>();
        preparedData.put("John", Arrays.asList("555-1123","s", "555-3389", "a", "ba"));
        preparedData.put("Mary", Arrays.asList("555-2243","z", "555-5264", "u"));
        preparedData.put("Steve", Arrays.asList("555-6654", "555-3242", "d", "c"));

        List<String> actualResult = findLetterInValue(preparedData);

        List<String> expectedResult = preparedData.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(letter -> letter.length() == 1)
                .toList();

        assertEquals(expectedResult, actualResult);
    }
}
