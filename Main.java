import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        if (input.matches("(.*)\\+(.*)")) {
            System.out.print("\"" + Strings.operationPlus(input) + "\"");
        }
        if ((input.matches("(.*)\\-(.*)"))) {
            System.out.print("\"" + Strings.operationMinus(input) + "\"");
        }
        if ((input.matches("(.*)\\*\\d+"))) {
            System.out.print("\"" + Strings.operationMultiplication(input) + "\"");
        }
        if ((input.matches("(.*)\\/\\d+"))) {
            System.out.print("\"" + Strings.operationDivision(input) + "\"");
        }
    }
}
