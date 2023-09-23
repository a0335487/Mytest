import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String calc(String input) {
        String need_result;
        String[] need;
        need = input.split("[+\\-*/]");
        String a = need[0];
        String b = need[1];
        need[0] = Roman_Num(need, need[0]);
        need[1] = Roman_Num(need, need[1]);
        try {
            int first = Integer.parseInt(need[0]);
            int second = Integer.parseInt(need[1]);

            if (need.length > 2) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                throw new IllegalArgumentException();
            } else {
                int result = 0;
                if (first < 1 || first > 10 || second < 1 || second > 10) {
                    System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно.");
                    throw new IllegalArgumentException();
                } else {
                    //char operator = input.charAt(input.indexOfAny("+-*/"));
                    if (input.indexOf('+') != -1) {
                        result = first + second;
                    } else if (input.indexOf('-') != -1) {
                        result = first - second;
                    } else if (input.indexOf('*') != -1) {
                        result = first * second;
                    } else if (input.indexOf('/') != -1){
                        if (second == 0) {
                            System.out.println("Деление на ноль запрещено.");
                            throw new ArithmeticException();
                        }
                        else {
                            result = first / second;
                        }
                    } else {
                        System.out.println("Неподдерживаемая операция");
                        throw new IllegalArgumentException();
                    }

                }

                need_result = Integer.toString(result);
                int result2;
                String[] rom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
                    for (String value : rom) {
                        if (Arrays.binarySearch(rom, a) >= 0 && Arrays.binarySearch(rom, b) >= 0) {
                            if (result > 0) {
                                need_result = ArabicToRoman(result);
                            }
                            else{
                                System.out.println("В римской системе нет отрациальных чисел");
                                throw new ArithmeticException();
                            }
                        }
                        else if (Arrays.binarySearch(rom, a) >= 0 && !Objects.equals(b, value)) {
                            System.out.println("Используются одновременно разные системы счисления");
                            throw new IllegalArgumentException();
                        }
                        else if (Arrays.binarySearch(rom, b) >= 0 && !Objects.equals(a, value)){
                            System.out.println("Используются одновременно разные системы счисления");
                            throw new IllegalArgumentException();
                        }
                        else{
                            need_result = need_result;
                        }
                    }
                return need_result;
            }
        }
        catch (NumberFormatException ae) {
            System.out.println("Ошибка в формате чисел: " + ae.getMessage());
            throw ae;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        String S1;
        input = in.nextLine();
        S1 = calc(input);
        System.out.println(S1);


    }

    static String Roman_Num(String[] string1, String string) {
        String[] rom = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < rom.length; i++) {
                if (Objects.equals(string, rom[i])) {
                    string = number[i];
                }
                else {
                    string = string;
                }
        }

        return string;
    }



    static String ArabicToRoman(int num) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder result = new StringBuilder();

        for (int i = romans.length - 1; i >= 0; i--) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

}

