package AssociatedArrays_LAB;

import javax.sound.midi.Soundbank;
import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> synonymList = new ArrayList<>();

        Map<String, ArrayList<String>> wordsAndSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            wordsAndSynonyms.putIfAbsent(word, new ArrayList<>());
            wordsAndSynonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, ArrayList<String>> entry : wordsAndSynonyms.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }
    }
}
