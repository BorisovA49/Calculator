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
        // Разбиваем входную строку на числа и операцию
        String[] arr = input.split("[\\D]");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        char operator = input.replaceAll("[\\d.]", "").charAt(0);

        HashMap<Integer, String> arabicToRoman = new HashMap<>();
        arabicToRoman.put(1, "I");
        arabicToRoman.put(2, "II");
        arabicToRoman.put(3, "III");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(6, "VI");
        arabicToRoman.put(7, "VII");
        arabicToRoman.put(8, "VIII");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(10, "X");


        // Выполняем арифметическую операцию
        int result;
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

