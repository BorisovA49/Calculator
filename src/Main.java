import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Результат: " + calc(input));
    }


    public static String calc(String input) {
        boolean bool = false;
        input = input.replaceAll("\\s+", "");  // удаляем  пробелы
        String[] opera = {"+", "-", "/", "*"};
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        int num3;
        int num4;
        String operators = "";

        for (int i = 0; i < input.length(); i++) {
            String massInput = String.valueOf(input.charAt(i));
            if (Arrays.asList(opera).contains(massInput)) {
                if (!operators.isEmpty()) {
                    throw new IllegalArgumentException("Неверный формат ввода");
                }
                operators = massInput;
            } else {
                if (operators.isEmpty()) {
                    num1.append(massInput);
                } else {
                    num2.append(massInput);
                }
            }
        }
        if (!Arrays.asList(opera).contains(operators)) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        if (Arrays.asList(Constant.RIMNUMBER).contains(String.valueOf(num1)) && Arrays.asList(Constant.RIMNUMBER).contains(String.valueOf(num2))) {  //римские
            bool = true;
            num3 = romanToNumber(String.valueOf(num1));
            num4 = romanToNumber(String.valueOf(num2));
        } else if (!Arrays.asList(Constant.RIMNUMBER).contains(String.valueOf(num1)) && !Arrays.asList(Constant.RIMNUMBER).contains(String.valueOf(num2))) {  //римские
            num3 = Integer.parseInt(String.valueOf(num1));
            num4 = Integer.parseInt(String.valueOf(num2));
        } else throw new IllegalArgumentException("Разный формат чисел");

        if (!((num3 >= 0 && num3 < 11) && (num4 >= 0 && num4 < 11))) {
            throw new IllegalArgumentException("Неверный диапазон чисел");
        }
        int result;
        switch (operators) {
            case "+":
                result = num3 + num4;
                break;
            case "-":
                result = num3 - num4;
                break;
            case "*":
                result = num3 * num4;
                break;
            case "/":
                result = num3 / num4;
                break;
            default:
                return "Неизвестный оператор";
        }
        if (bool) {
            return convertNumToRoman(Integer.parseInt(String.valueOf(result)));
        } else return String.valueOf(result);
    }


    private static String convertNumToRoman(int input) {
        return Constant.RIMNUMBER[Integer.parseInt(String.valueOf(input))];
    }

    private static int romanToNumber(String roman) {

        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }
}
