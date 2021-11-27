package AssociatedArrays_Exercise;

import java.util.*;

public class Cours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> mapCourses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while(!input.equals("end")){
            String course = input.split(" : ")[0];
            String name = input.split(" : ")[1];
            if (!mapCourses.containsKey(course)) {
                mapCourses.put(course, new ArrayList<>());
            }
            mapCourses.get(course).add(name);
            input = scanner.nextLine();
        }
        mapCourses.entrySet().stream().sorted((n1, n2)-> Integer.compare(n2.getValue().size(), n1.getValue().size())).forEach(el-> {
            System.out.println(el.getKey() + ": " + el.getValue().size());
            List<String> person = el.getValue();
            person.stream().sorted().forEach(persone -> System.out.println("-- " + persone));
        });
    }
}
