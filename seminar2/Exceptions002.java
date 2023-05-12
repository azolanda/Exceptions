package seminar2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions002 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // System.out.println(getFloatNum(scan));

        int[] array = { 1, 2, 3, 3, 3, 2, 1 };
        // task2(array);
        System.out.println("Введенная строка: \n" + getStr(scan));
        scan.close();
    }

    // 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить
    // к падению приложения, вместо этого, необходимо повторно запросить у
    // пользователя ввод данных.

    public static Float getFloatNum(Scanner sc) {
        Float num = null;

        do {
            try {
                System.out.println("Введите число: --> ");
                num = sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Ввод в неверном формате! Повторите ввод");
                sc.nextLine();
            }
        } while (num == null);

        return num;
    }

    // 2. Если необходимо, исправьте данный код

    public static void task2(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    // 4. Разработайте программу, которая выбросит Exception,
    // когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static String getStr(Scanner sc) {
        String str = null;
        System.out.println("Введите строку: -->");
        str = sc.nextLine();

        if (str.equals("")) {
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }

        return str;
    }
}
