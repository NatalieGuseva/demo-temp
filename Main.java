import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result = "";


    public static void main(String[] args) {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x]" +
                " где a и b - строки, а x - число  от 1 до 10 включительно  + Enter ");
//  Считываем строку userInput которую ввёл пользователь
        String input = scanner.nextLine();
        operation = methodOperation(input);
        work(input);
    }

    private static void work(String userInput) {
        String[] blocks = userInput.split("['\"']");
        if (blocks.length == 4) {
            String str1 = blocks[1];
            String str2 = blocks[3];
            if ((str1.length() <= 10) && str2.length() <= 10) {
                result = calculated(str1, str2, operation);
            }
            if (result.length() > 40) {
                String rez = result.substring(0, 40);
                System.out.println(rez + "...");
            } else {
                System.out.println(result);
            }
        } else {              //            blocks.length == 3;
            String str1 = blocks[1];
            String str2 = blocks[2].replaceAll("\\D", "");
            number = Integer.parseInt(str2);
            if ((number > 0) && number <= 10) {
                result = calculated(str1, operation, number);
            }
            if (result.length() > 40) {
                String rez = result.substring(0, 40);
                System.out.println(rez + "...");
            } else {
                System.out.println(result);
            }
        }
    }

    //  Метод поиска знака операции
    private static char methodOperation(String userInput) {
        char[] uchar = new char[100];
        //      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            uchar[i] = userInput.charAt(i);
            if (uchar[i] == '+') {
                operation = '+';
            }
            if (userInput.matches("(.*)\\-(.*)")) {
                operation = '-';
            }
            if (uchar[i] == '*') {
                operation = '*';
            }
            if (uchar[i] == '/') {
                operation = '/';
            }
        }
        return operation;
    }

    //  Метод для двух строк
    public static String calculated(String str1, String str2, char op) {
        switch (op) {
            case '*':
                System.out.println("Неверный знак операции + (введите + или -)");
                break;
            case '/':
                System.out.println("Неверный знак операции - (введите + или -)");
                break;
            case '+':
                result = str1 + str2;
                break;
            case '-':
                result = str1;
                if (str1.equalsIgnoreCase(str2)) {
                    result = "0";
                    break;
                }
                for (int i = 0; i < str2.length(); i++) {
                    String l = str2.substring(i, i + 1);
                    if (str1.contains(l)) {
                        str1 = str1.replaceFirst(l, "");
                        result = result.replaceFirst(l, "");
                    } else {
                        str2.replaceAll(".+", "");
                        result = str1;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }

    //  Метод для строки и числа
    public static String calculated(String str, char op, int num) {
        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");
                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':
                for (int u = 0; u < num; u++) {
                    result = result + str;
                }
                break;
            case '/':
                try {
                    int resB = str.length() / num;
                    if (str.length() == num) {
                        result = "1";
                    } else {
                        result = str.substring(0, resB);
                    }
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (str.length() < num) {
                        System.out.println("Делимое меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }
}
