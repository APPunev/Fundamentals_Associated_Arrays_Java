package AssociatedArrays_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mapNameInt = new HashMap<>();
        Map<String, Integer> mapLanguageCount = new HashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("exam finished")){
            String[] token = input.split("-");
            String userName = token[0];
            if (token.length == 3) {
                String language = token[1];
                int points = Integer.parseInt(token[2]);
                if (!mapNameInt.containsKey(userName)) {
                    mapNameInt.put(userName, points);
                }else{
                    int currentPoints = mapNameInt.get(userName);
                    if (currentPoints < points) {
                        mapNameInt.put(userName,points);
                    }
                }
                if (!mapLanguageCount.containsKey(language)) {
                    mapLanguageCount.put(language,1);
                }
                else{
                    mapLanguageCount.put(language, mapLanguageCount.get(language) + 1);
                }
            }else{
                mapNameInt.remove(userName);

            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        mapNameInt.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(el -> System.out.println(el.getKey()+ " | " + el.getValue()));
        System.out.println("Submissions:");
        mapLanguageCount.entrySet()
                .stream()
                .sorted(Map.Entry
                        .<String,Integer>comparingByValue()
                        .reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(el -> System.out.println(el.getKey() + " - " + el.getValue()));
    }
}
