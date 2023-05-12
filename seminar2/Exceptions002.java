package seminar2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions002 {
    public static void main(String[] args) {
        // System.out.println(getFloatNum());

        int[] array = { 1, 2, 3, 3, 3, 2, 1 };
        task2(array);

    }

    // 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить
    // к падению приложения, вместо этого, необходимо повторно запросить у
    // пользователя ввод данных.

    public static Float getFloatNum() {
        Float num = null;
        Scanner scan = new Scanner(System.in);

        do {
            try {
                System.out.println("Введите число: --> ");
                num = scan.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Ввод в неверном формате! Повторите ввод");
                scan.nextLine();
            }
        } while (num == null);

        scan.close();
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
}
