package seminar2;

import java.util.InputMismatchException;
import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить 
// к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

public class Exceptions002 {
    public static void main(String[] args) {
        System.out.println(getFloatNum());

    }

    public static Float getFloatNum() {
        Float num = null;
        Scanner scan = new Scanner(System.in);

        while (num == null) {
            try {
                num = scan.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Ввод в неверном формате! Повторите ввод");
            }
        }

        scan.close();
        return num;
    }
}
