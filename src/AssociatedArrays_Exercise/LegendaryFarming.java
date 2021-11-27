package AssociatedArrays_Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//The possible items are:
//  •	Shadowmourne - requires 250 Shards
//  •	Valanyr - requires 250 Fragments
//  •	Dragonwrath - requires 250 Motes
// Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as "2 motes 3 ores 15 stones".
// Keep track of the key materials - the first that reaches the 250 mark wins the race.
// At that point, print the corresponding legendary obtained.
// Then, print the remaining shards, fragments, motes, ordered by quantity in descending order, then by name in ascending order, each on a new line.
// Finally, print the collected junk items, in alphabetical order.
// Input
// •Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
// Output
// •On the first line, print the obtained item in format {Legendary item} obtained!
// •On the next three lines, print the remaining key materials in descending order by quantity
//    •If two key materials have the same quantity, print them in alphabetical order
// •On the final several lines, print the junk items in alphabetical order
//    •All materials are printed in format {material}: {quantity}
//    •All output should be lowercase, except the first letter of the legendary

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        Map<String, Integer> mapElement = new TreeMap<>();
        mapElement.put("shards", 0);
        mapElement.put("motes", 0);
        mapElement.put("fragments", 0);// elements map
        Map<String, Integer> junk = new TreeMap<>();// junk map

        int index = 0;

        while (true) {
            String[] data = input.split(" ");

            for (int i = 0; i < data.length; i+=2) {
                int quantity = Integer.parseInt(data[i]);
                String element = data[i + 1];


                if (!mapElement.containsKey(element)) {
                    switch (element) {
                        case "shards":
                        case "fragments":
                        case "motes":
                            mapElement.put(element, quantity);
                            if (mapElement.get(element) >= 250) {
                                print(mapElement, junk);
                                return;
                            }
                            break;
                        default:
                            junk.put(element, quantity);
                            break;
                    }
                } else {
                    switch (element) {
                        case "shards":
                        case "fragments":
                        case "motes":
                            mapElement.put(element, mapElement.get(element) + quantity);
                            if (mapElement.get(element) >= 250) {
                                print(mapElement, junk);
                                return;
                            }
                            break;
                        default:
                            junk.put(element, junk.get(element) + quantity);
                            break;
                    }
                }
            }
            input = scanner.nextLine().toLowerCase();
        }
    }


    private static void print(Map<String, Integer> mapElement, Map<String, Integer> junk) {
        for (Map.Entry<String, Integer> entry: mapElement.entrySet()) {
            if (entry.getValue() >= 250) {
                String object = entry.getKey();
                switch (object) {
                    case "shards":
                        System.out.println("Shadowmourne obtained!");
                        int shardValue = entry.getValue() - 250;
                        entry.setValue(shardValue);
                        break;
                    case "fragments":
                        System.out.println("Valanyr obtained!");
                        int fragmentsValue = entry.getValue() - 250;
                        entry.setValue(fragmentsValue);
                        break;
                    case "motes":
                        System.out.println("Dragonwrath obtained!");
                        int motesValue = entry.getValue() - 250;
                        entry.setValue(motesValue);
                        break;
                }

                mapElement.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue()
                                .reversed()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .forEach(el ->
                            System.out.println(el.getKey() + ": " + el.getValue()));

                for (Map.Entry<String, Integer> junkEntry : junk.entrySet()) {
                    System.out.println(junkEntry.getKey() + ": " + junkEntry.getValue());
                }
            }
        }
    }
}
