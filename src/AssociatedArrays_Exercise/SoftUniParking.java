package AssociatedArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String, String> mapUsers = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String commandData = command[0];
            String user = command[1];

            switch (commandData){

                case "register":
                    String plate = command[2];
                    if (!mapUsers.containsKey(user)) {
                        System.out.printf("%s registered %s successfully%n",user,plate);
                        mapUsers.put(user, plate);
                    }else{
                        System.out.printf("ERROR: already registered with plate number %s%n",plate);
                    }
                    break;
                case "unregister":
                    if (!mapUsers.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found%n",user);
                    }else{
                        System.out.printf("%s unregistered successfully%n",user);
                        mapUsers.remove(user);
                    }
                    break;

            }
        }

        mapUsers.entrySet().stream().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
