package AssociatedArrays_Exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> mapCompanies = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] data = input.split(" -> ");
            String company = data[0];
            String ID = data[1];
            if (!mapCompanies.containsKey(company)) {
                mapCompanies.put(company,new ArrayList<>());
                mapCompanies.get(company).add(ID);
            }else {
                if (!mapCompanies.get(company).contains(ID)) {
                    mapCompanies.get(company).add(ID);
                }
            }
            input = scanner.nextLine();
        }

        mapCompanies.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry -> {
            System.out.println(entry.getKey());
            List<String> id = entry.getValue();
            id.stream().forEach(el -> System.out.println("-- " + el));
        });
    }
}
