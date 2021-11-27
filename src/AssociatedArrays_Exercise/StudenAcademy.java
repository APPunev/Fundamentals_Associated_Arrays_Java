package AssociatedArrays_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class StudenAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> mapStudents = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!mapStudents.containsKey(name)) {
                mapStudents.put(name, new ArrayList<>());
            }
            mapStudents.get(name).add(grade);
        }

        Map<String, Double> average =
                mapStudents.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                e -> e.getValue()
                                        .stream()
                                        .mapToDouble(Double::doubleValue)
                                        .average()
                                        .getAsDouble()));




        average.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
            if (entry.getValue() >= 4.5) {

                System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue());
            }
        });
    }
}
