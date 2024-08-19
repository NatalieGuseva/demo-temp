import java.util.Arrays;

public class Strings {
    public static String operationPlus(String s) {
        String s1 = s.replaceAll("[^\\d,\\w]+", "");
        if (s1.length() > 40){
            s1 = s1.substring(0,40).concat("...");
        }
        return s1;
    }
    public static String operationMinus(String s) {
        int index = s.indexOf("-");
        String s1 = s.substring(0, index);
        String s2 = s.substring(index + 1, s.length());
        String result = s1;
        for (int i = 0; i < s2.length(); i++) {
            String l = s2.substring(i, i + 1);
            if (s1.contains(l)) {
                s1 = s1.replaceFirst(l, "");
                result = result.replaceFirst(l, "");
            } else {
                s2.replaceAll("\\*", "");
                result = s1;
            }
        }if (result.length() > 40){
            result = result.substring(0,40).concat("...");
        }
        return result;
    }

    public static String operationMultiplication(String s) {
        String s1 = s.replaceAll("[^A-Za-z]", "");
        String s2 = s.replaceAll("\\D", "");
        int n = Integer.parseInt(s2);
        String result = s1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (n >= 1 && n <= 10) {
                if (result.isEmpty() == false) {
                    sb.append(result);
                }
            }
        }
        if (sb.length() > 40){
            sb = new StringBuilder(sb.substring(0, 40).concat("..."));
        }
        return sb.toString();
    }
    public static String operationDivision(String s) {
        String s1 = s.replaceAll("[^A-Za-z]", "");
        String s2 = s.replaceAll("\\D", "");
        int n = Integer.parseInt(s2);
        String result = s1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (n >= 1 && n <= 10) {
                if (result.isEmpty() == false) {
                    result = String.valueOf(s1.charAt(i));
                    sb.append(result);
                }
            }
        }
        return sb.toString();
    }
}