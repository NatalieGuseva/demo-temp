import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Operations.methodOperation(input);
        Operations.calculate(input);
        scanner.close();
    }
}