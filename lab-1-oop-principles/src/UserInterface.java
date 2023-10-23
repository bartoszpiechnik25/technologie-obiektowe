import java.util.*;

public class UserInterface {
    private final Scanner scanner;
    private final CurrencyCollection collection;
    private final RequestHandler requestHandler = RequestHandler.getInstance();

    public UserInterface() {
        scanner = new Scanner(System.in);
        List<Map<XMLParser.CurrencyAttr, String>> parsed = new ArrayList<>();
        try {
            parsed = XMLParser.parse(requestHandler.get("https://www.nbp.pl/kursy/xml/lasta.xml"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        collection = CollectionInitializer.initialize(parsed);
    }
    private Currency getCurrencyCodeFromUser(String promptInfo) {
        while (true) {
            System.out.print(promptInfo);
            String currencyCode = scanner.nextLine().toUpperCase();
            try {
                return collection.get(currencyCode);
            } catch (NoSuchElementException ne) {
                System.out.printf("Currency with code --> %s does not exist in the collection!\n", currencyCode);
            }
        }
    }
    private double getAmountToConvert(String code) {
        while (true) {
            System.out.printf("Enter amount of currency %s to convert: ", code);
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                scanner.nextLine();
                return amount;
            } else {
                System.out.println("Provide valid double number!");
                scanner.nextLine();
            }
        }
    }
    private static void displayMenu() {
        System.out.println("|-------------------------------|");
        String m = "| MENU                          |";
        String c = "| \t-> c - start converting     |";
        String q = "| \t-> q - finish the execution |";
        System.out.println(m);
        System.out.println(c);
        System.out.println(q);
        System.out.println("|-------------------------------|");

    }
    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Action: ");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("c")) {
                Currency c1 = getCurrencyCodeFromUser("Enter currency code that you want to convert: ");
                double amount = getAmountToConvert(c1.getCurrencyCode());
                Currency c2 = getCurrencyCodeFromUser("Enter currency code that you want to convert to: ");
                CurrencyConverter converter = new CurrencyConverter(c1, c2, amount);
                System.out.println(converter.convert());
            } else if (action.equals("q")) {
                System.out.println("See you next time!");
                System.exit(0);
            } else {
                System.out.println("Invalid action!");
            }
        }
    }
}
