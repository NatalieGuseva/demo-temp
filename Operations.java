import java.util.InputMismatchException;

public class Operations {
    static int number;
    static char operation;
    static String result = "";

    //  Метод поиска знака операции
    public static char methodOperation(String userInput) {
        char[] uchar = new char[10];
        //  Заполняем символьный массив символами строки, которую ввел пользователь и определяем знак операции
        for (int i = 0; i < userInput.length(); i++) {
            uchar[i] = userInput.charAt(i);
            if (uchar[i] == '+') {
                operation = '+';
            }
            if (uchar[i] == '-') {
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

    public static void calculate(String userInput) {

        String[] blocks = userInput.split("[+-/*\"]");
        if (blocks.length == 5) {
            String st01 = blocks[1];
            String st04 = blocks[4];
            result = calculated(st01, st04, operation);
            if (result.length() > 40) {
                String rez = result.substring(0, 40);
                System.out.println(rez + "...");
            } else {
                System.out.println(result);
            }
        } else {              //            blocks.length == 4;
            String st01 = blocks[1];
            String st03 = blocks[3];
            number = Integer.parseInt(st03);
            result = calculated(st01, number, operation);
            if (result.length() > 40) {
                String rez = result.substring(0, 40);
                System.out.println(rez + "...");
            } else {
                System.out.println(result);
            }
        }
    }

    //  Meтoд для двух строк
    public static String calculated(String num1, String num2, char op) {

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                int resA = num1.length() - num2.length();
                if (num1.length() == num2.length() || num1.length() < num2.length()) {
                    result = "0";
                } else {
                    result = num1.substring(0, resA);
                }
                break;
            case '*':
                System.out.println("Неверный знак операции * (введите + или -)");
                break;
            case '/':
                System.out.println("Неверный знак операции / (введите + или -)");
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

    //  Meтoд для строки и числа
    public static String calculated(String num1, int num, char op) {

        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");
                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':
                for (int u = 0; u < num; u++) {
                    result = result + num1;
                }
                break;
            case '/':
                try {
                    int resB = num1.length() / num;
                    if (num1.length() == num) {
                        result = "1";
                    } else {
                        result = num1.substring(0, resB);
                    }
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (num1.length() < num) {
                        System.out.println("Делимое меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}






