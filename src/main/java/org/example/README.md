1. Implement Unit Tests for each task.
2. Don't forget to add the ReadMe file, gitignore file
3. Read about the innovations that were introduced in the 8th-9th Java, I ask around

   
### Task 1:
   1. Show in console
   ```java
   Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
   ```
   2. Create a list of random numbers using
   **Stream.generate()** , should have 20 items and print in console
   3. Collect Stream elements to a List:  Convert list elements to stream, select only even ones, use the collect method to collect them into a List:
### Task 2:
```java   
List<Integer> list = new ArrayList<Integer>();
   for(int i = 1; i < 10; i++){
   list.add(i)
   }
```
4. Repeat the same as in task 3 but collect all the elements in Array [];
5. filter values, keep those that start with "c", convert all values, convert to uppercase, sort in Descending order
```java   
List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
```
### Task 3:
6. 
- a) Display names that start with ‘A’ and have length > 5;
- b) Sort all names and display them in lower case on the screen
```java   
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
```
7. **Stream.match()** - Various matching operations can be used to check whether a given predicate matches the stream elements. Match returns a boolean result.
   - From task 6, take an array and check with allMatch or anyMatch whether the list contains names with the letter ‘S’ (allMatch should display false, anyMatch should display true)
   - From task 6, take an array and check with noneMatch whether the list contains names with the letter ‘H’ (should display true)
8. **Stream.count()** - The count() is a terminal operation returning the number of elements in the stream as a long value.

9. From task 6 count the number of names starting with “A” - display their number.

10. **Stream.findFirst()** - take the array from task 6 and print the first name starting with ‘L’  
   
### Task 4:
   11. Java Stream flatMap() - concatenate 3 arrays into one using flatMap ()
```java   
   List<Integer> list1 = Arrays.asList(1,2,3);
   List<Integer> list2 = Arrays.asList(4,5,6);
   List<Integer> list3 = Arrays.asList(7,8,9);
```
   And these are also combined into 1 
```java   
String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
```
   12. **Stream.distinct()** to remove duplicates - remove duplicates from this array and display.
```java   
ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
```
   13. **(OPTIONAL, NOT MANDATORY)** Collectors.toMap() - move the list into Map where the key is an element of the array and the value is the number of times the element occurs in the array
```java   
ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7));
```
   
###  Task 5:
   14. Write to a new list only letters that occur in the values of this map
```java   
   Map<String, List<String>> people = new HashMap<>();
   people.put("John", Arrays.asList("555-1123","s", "555-3389", "a"));
   people.put("Mary", Arrays.asList("555-2243","z", "555-5264"));
   people.put("Steve", Arrays.asList("555-6654", "555-3242", "d"));
```