package AssociatedArrays_LAB;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        String[] elements = input.split("\\s+");

        Map<String, Integer> mapOfWords = new LinkedHashMap<>();

        for (String word:elements) {
            if (mapOfWords.containsKey(word)) {
                mapOfWords.put(word, mapOfWords.get(word) + 1);
            }else{
                mapOfWords.put(word,1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: mapOfWords.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey());
            }
        }
        for (int i = 0; i < oddWords.size(); i++) {
            if (i == oddWords.size() - 1) {
                System.out.print(oddWords.get(i));
            }else{
                System.out.print(oddWords.get(i) + ", ");
            }
        }
    }
}
