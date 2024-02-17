import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Результат: " + calc(input));
    }

    static String calc(String input) {

        input = input.replaceAll("\\s+", "");         // Удаляем любые пробелы во входной строке

        String[] opera = {"+", "-", "/", "*"};
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        String operators = "";

        for (int i = 0; i < input.length(); i++) {
            String massInput = String.valueOf(input.charAt(i));
            if (Arrays.asList(opera).contains(massInput)) {
                if (!operators.isEmpty()) {
                    throw new IllegalArgumentException("т.к. формат математической операции не удовлетворяет заданию - два или более операнда и один оператор (+, -, /, *)");
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


        if (!(Integer.parseInt(String.valueOf(num1)) > 0 && Integer.parseInt(String.valueOf(num1)) < 11 && Integer.parseInt(String.valueOf(num2)) > 0 && Integer.parseInt(String.valueOf(num2)) < 11)) {
            throw new IllegalArgumentException("цыфра пиздец хдоровая ");
        }


        int result;

        switch (operators) {
            case "+":
                result = Integer.parseInt(String.valueOf(num1)) + Integer.parseInt(String.valueOf(num2));
                break;
            case "-":
                result = Integer.parseInt(String.valueOf(num1)) - Integer.parseInt(String.valueOf(num2));
                break;
            case "*":
                result = Integer.parseInt(String.valueOf(num1)) * Integer.parseInt(String.valueOf(num2));
                break;
            case "/":
                if (Integer.parseInt(String.valueOf(num2)) != 0) {
                    result = Integer.parseInt(String.valueOf(num1)) / Integer.parseInt(String.valueOf(num2));
                } else {
                    return "Ошибка: деление на ноль.";
                }
                break;
            default:
                return "Ошибка: неверная арифметическая операция.";
        }

        return String.valueOf(result);
    }


}

