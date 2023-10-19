import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Siema");
        HashMap<String, String> test = new HashMap<>();

        test.put("Siema", "test");

        System.out.println(test.containsKey("Siema"));
        System.out.println(test.containsKey("essa"));
    }
}
