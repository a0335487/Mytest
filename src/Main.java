import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String calc(String input) {
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
                String[] rom = {"I", "IV", "V", "IX", "X", "II", "III", "VI", "VII", "VIII"};
                    for (String value : rom) {
                        if (Objects.equals(a, value) && Objects.equals(b, value)) {
                            //need[0] = Roman_Num(need, need[0]);
                            //need[1] = Roman_Num(need, need[1]);
                            int result2;
                            if (result > 0) {
                                if (result > 10) {
                                    result2 = result;
                                    result = result2 - 10;

                                }
                                else{

                                }
                            }
                            else{
                                System.out.println("В римской системе нет отрицательных чисел!");
                                throw new IllegalArgumentException();
                            }

                        }
                        else {
                            result = result;
                        }
                    }
                return Integer.toString(result);
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
        String[] rom = {"I", "IV", "V", "IX", "X", "II", "III", "VI", "VII", "VIII"};
        for (String s : string1) {
            for (String value : rom) {
                if (Objects.equals(s, value)) {
                    switch (string) {
                        case "I":
                            string = "1";
                            break;
                        case "II":
                            string = "2";
                            break;
                        case "III":
                            string = "3";
                            break;
                        case "IV":
                            string = "4";
                            break;
                        case "V":
                            string = "5";
                            break;
                        case "VI":
                            string = "6";
                            break;
                        case "VII":
                            string = "7";
                            break;
                        case "VIII":
                            string = "8";
                            break;
                        case "IX":
                            string = "9";
                            break;
                        case "X":
                            string = "10";
                            break;
                    }
                } else {
                    string = string;
                }
            }
        }

        return string;
    }

}
