package AssociatedArrays_Exercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> productsData = new LinkedHashMap<>();
        String input = scanner.nextLine();


        while(!input.equals("buy")){
            String[] inputData = input.split(" ");
            //{name} {price} {quantity}

            String name = inputData[0];
            double price = Double.parseDouble(inputData[1]);
            double quantity = Double.parseDouble(inputData[2]);

            if (!productsData.containsKey(name)) {
                productsData.put(name,new ArrayList<>());
                productsData.get(name).add(price);
                productsData.get(name).add(quantity);
            }else{
                //double currentCount = productsData.get(name) + quantity;
                productsData.get(name).set(0,price);
                double sumQuantity = productsData.get(name).get(1) + quantity;
                productsData.get(name).set(1,sumQuantity);
                //productsData.put(name, currentCount * price);
            }


            input = scanner.nextLine();
        }

        productsData.entrySet().stream().forEach(entryProduct -> System.out.printf("%s -> %.2f%n",entryProduct.getKey(),(entryProduct.getValue().get(0) * entryProduct.getValue().get(1))));
    }
}
