package AssociatedArrays_LAB;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Map<Double, Integer> mapOfNums = new TreeMap<>();
        for (double num:numbers) {
            if (!mapOfNums.containsKey(num)) {
                mapOfNums.put(num,0);
            }
            mapOfNums.put(num, mapOfNums.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> entry: mapOfNums.entrySet()) {
            DecimalFormat format = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n", format.format(entry.getKey()), entry.getValue());
        }
    }
}
