import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Результат: " + calc(input));
    }

    static String calc(String input) {
        // Удаляем любые пробелы во входной строке
        input = input.replaceAll("\\s+", "");

        // Разбиваем входную строку на числа и операцию
        String[] arr = input.split("[\\D&&[^.]]");
        double num1 = Double.parseDouble(arr[0]);
        double num2 = Double.parseDouble(arr[1]);
        char operator = input.replaceAll("[\\d.]", "").charAt(0);

        // Выполняем арифметическую операцию
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    return "Ошибка: деление на ноль.";
                }
                break;
            default:
                return "Ошибка: неверная арифметическая операция.";
        }
        // Возвращаем результат в виде строки
        return String.valueOf(result);
    }


}