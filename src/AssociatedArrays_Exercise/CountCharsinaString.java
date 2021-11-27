package AssociatedArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsinaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> lettersCount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ' ') {
                continue;
            }
            if (!lettersCount.containsKey(currentChar)) {
                lettersCount.put(currentChar, 1);
            }else{
                int currentValue = lettersCount.get(currentChar);
                lettersCount.put(currentChar, currentValue + 1);
            }
        }
        for (Map.Entry <Character, Integer> entry:lettersCount.entrySet()) {
            //{char} -> {occurrences}
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
