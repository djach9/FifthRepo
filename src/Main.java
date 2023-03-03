import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Map<String, String> properties = new HashMap<>();

        properties.put("login", "Angelina");
        properties.put("password", "angelinaInHollywood123");
        properties.put("title", "Salt");
        properties.put("url", "www.angelina.hollywood");
        properties.put("errorMessage", "file has not been founded");

        String[] sensitiveKeys = {"login","password","url"};


        properties.forEach((key, value) -> {
            if (Set.of(sensitiveKeys).contains(key)) {
                System.out.println(key + ": ***");
            } else {
                System.out.println(key + ": " + value);
            }
        });


        List<String> output = properties.entrySet()
                .stream()
                .map(entry -> {
                    String key = entry.getKey();
                    String value = Set.of(sensitiveKeys).contains(key) ? "***" : entry.getValue();
                    return key + ": " + value;
                })
                .collect(Collectors.toList());

        output.forEach(System.out::println);

    }
}