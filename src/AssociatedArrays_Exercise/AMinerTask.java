package AssociatedArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mapMetal = new LinkedHashMap<>();
        while(true){
            String metal = scanner.nextLine();
            if (metal.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!mapMetal.containsKey(metal)) {
                mapMetal.put(metal, quantity);
            }else{
                mapMetal.put(metal,mapMetal.get(metal) + quantity);
            }
        }
        for (Map.Entry<String, Integer> entry: mapMetal.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
