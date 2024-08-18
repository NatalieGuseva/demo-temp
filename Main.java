import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.matches("(.*)\\+(.*)")) {
            System.out.print("\"" + Strings.operationPlus(input) + "\"");
        }
        if ((input.matches("(.*)\\-(.*)"))) {
            System.out.print("\"" + Strings.operationMinus(input) + "\"");
        }
        if ((input.matches("(.*)\\*\\d"))) {
            System.out.print("\"" + Strings.operationMultiplication(input) + "\"");
        }
        if ((input.matches("(.*)\\/\\d"))) {
            System.out.print("\"" + Strings.operationDivision(input) + "\"");
        }
        scanner.close();
    }
}