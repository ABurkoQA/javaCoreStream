package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final int MIN_NAME_LENGTH = 5;

    public static void main(String[] args) {

        // 1.1

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,4,9);

        showStreamInConsole(stream);

        // 1.2

        generateRandomStreamValue(20);

        // 1.3

        List<Integer> randomValueCollection = generateAndReturnRandomValue(4);

        List<Integer> evenValue = collectEvenValue(randomValueCollection);

        // 2.4

        Integer[] evenValueArray = collectEvenValueToArray(randomValueCollection);

        // 2.5

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        List<String> sortedList = sortInDescendingOrder(myList);

        // 3

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Abibaba");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        // 3.6

        List<String> namesWithA = nameLongerThanFiveSymbols(memberNames);

        displaySortedNamesInConsole(memberNames);

        // 3.7

        String[] nameArray = convertListToArray(memberNames);

        boolean anyMatchResult = checkAnyMatchThatNameContainLetterS(nameArray); // true
        boolean allMatchResult = checkAllMatchThatNameContainLetterS(nameArray); // false
        boolean noneMatchResult = checkNoneMatchThatNameContainLetterH(nameArray); // true

        // 3.9

        long countNamesWithA = countNamesThatStartWithA(memberNames);
        System.out.println(countNamesWithA);

        // 3.10

        String nameWithL = printFirstNameWithL(memberNames);
        System.out.println(nameWithL);

        // 4.11

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);


        List<Integer> concatenateList = concatenateListInToOne(list1, list2, list3);

        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};

        String[] simpleData = convertComplexIntoSimple(dataArray);

        // 4.12

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));

        List<Integer> uniqueNumbers = findUniqueNumbers(numbersList);

        // 4.13

        Map<Integer, Long> numbers = countingElement(numbersList);

        // 5.14

        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123","s", "555-3389", "a"));
        people.put("Mary", Arrays.asList("555-2243","z", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));

        List<String> letters = findLetterInValue(people);
    }

    // 1.1

    public static void showStreamInConsole(Stream<Integer> stream) {
        stream.forEach(System.out::println);
    }

    // 1.2

    public static void generateRandomStreamValue(int limitNumber) {
        Stream.generate(() -> new Random().nextInt())
                .limit(limitNumber)
                .forEach(System.out::println);
    }

    // 1.3

    public static List<Integer> generateAndReturnRandomValue(int limitNumber) {
        return Stream.generate(() -> new Random().nextInt())
                .limit(limitNumber)
                .toList();
    }

    public static Stream<Integer> convertListToStream(List<Integer> valueCollection) {
        return valueCollection.stream();
    }

    public static List<Integer> collectEvenValue(List<Integer> valueCollection) {
        Stream<Integer> stream = convertListToStream(valueCollection);

        return stream.filter(value -> value % 2 == 0).toList();
    }

    // 2.4

    public static Integer[] collectEvenValueToArray(List<Integer> valueCollection) {
        Stream<Integer> stream = convertListToStream(valueCollection);

        return stream.filter(value -> value % 2 == 0).toArray(Integer[]::new);
    }

    // 2.5

    public static List<String> collectValueStartWithC(List<String> textCollection) {
        return textCollection.stream()
                .filter(text -> text.toLowerCase().startsWith("c"))
                .toList();
    }

    public static List<String> convertAllValueToUpper(List<String> textCollection) {
        return collectValueStartWithC(textCollection).stream()
                .map(String::toUpperCase)
                .toList();
    }

    public static List<String> sortInDescendingOrder(List<String> textCollection) {
        return convertAllValueToUpper(textCollection).stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // 3.6

    public static List<String> namesThatStartWithA(List<String> nameList) {
        return nameList.stream()
                .filter(name -> name.toUpperCase().startsWith("A"))
                .toList();
    }

    public static List<String> nameLongerThanFiveSymbols(List<String> nameList) {
        return namesThatStartWithA(nameList).stream()
                .filter(name -> name.length() > MIN_NAME_LENGTH)
                .toList();
    }

    public static void displaySortedNamesInConsole(List<String> nameList) {
                nameList.stream()
                        .sorted(String::compareTo)
                        .map(String::toLowerCase)
                        .forEach(System.out::println);
    }

    // 3.7

    public static String[] convertListToArray(List<String> nameList) {
        return nameList.toArray(String[]::new);
    }

    public static boolean checkAllMatchThatNameContainLetterS(String[] nameArray) {
        return Arrays.stream(nameArray)
                .allMatch(name -> name.toUpperCase().startsWith("S"));
    }

    public static boolean checkAnyMatchThatNameContainLetterS(String[] nameArray) {
        return Arrays.stream(nameArray)
                .anyMatch(name -> name.toUpperCase().startsWith("S"));
    }

    public static boolean checkNoneMatchThatNameContainLetterH(String[] nameArray) {
        return Arrays.stream(nameArray)
                .noneMatch(name -> name.toUpperCase().startsWith("H"));
    }

    // 3.9

    public static Long countNamesThatStartWithA (List<String> nameList) {
        return nameList.stream()
                .filter(name -> name.toUpperCase().startsWith("A"))
                .count();
    }

    // 3.10

    public static String printFirstNameWithL(List<String> nameList) {
        return nameList.stream()
                .filter(name -> name.toUpperCase().startsWith("L"))
                .findFirst()
                .orElseGet(() -> "Not found");
    }

    // 4.11

    public static List<Integer> concatenateListInToOne(List<Integer>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .toList();
    }

    public static String[] convertComplexIntoSimple (String[][] complexData) {
        return Arrays.stream(complexData)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);
    }

    // 4.12

    public static List<Integer> findUniqueNumbers(ArrayList<Integer> numbersList) {
        return numbersList.stream()
                .distinct()
                .toList();
    }

    // 4.13

    public static Map<Integer, Long> countingElement(List<Integer> numbersList) {
        return numbersList.stream()
                .collect(Collectors.groupingBy(value -> value, Collectors.counting()));
    }

    // 5.14

    public static List<String> findLetterInValue(Map<String, List<String>> collection) {
        return collection.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(letter -> letter.length() == 1)
                .toList();
    }
}