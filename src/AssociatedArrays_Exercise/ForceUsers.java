package AssociatedArrays_Exercise;

import java.util.*;

public class ForceUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> forceBook = new HashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("Lumpawaroo")){
            if (input.contains("|")) {
                //{forceSide} | {forceUser}
                String forceSide = input.split(" " + "\\|" + " ")[0];
                String user = input.split(" " + "\\|" + " ")[1];

                forceBook.putIfAbsent(forceSide, new ArrayList<>());

                boolean exist = false;
                for (List<String> name: forceBook.values()){
                    if (name.contains(user)) {
                        exist = true;
                    }
                }
                if (!exist) {
                    forceBook.get(forceSide).add(user);
                }
            }
            else{
                // if(input.contains("->"))
                //{forceUser} -> {forceSide}
                String user = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];

                forceBook.entrySet().forEach(entry -> entry.getValue().remove(user));

                forceBook.putIfAbsent(forceSide, new ArrayList<>());
                forceBook.get(forceSide).add(user);
                System.out.printf("%s joins the %s side!%n",user, forceSide);
            }
            input = scanner.nextLine();
        }

        forceBook
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sortResult = Integer.compare(e2.getValue().size(),e1.getValue().size());
                    if (sortResult == 0) {
                        sortResult = e1.getKey().compareTo(e2.getKey());
                    }
                    return sortResult;
                }).forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n",entry.getKey(), entry.getValue().size());
                    entry.getValue().stream().sorted().forEach(user-> System.out.println("! " + user));
                });
    }
}
