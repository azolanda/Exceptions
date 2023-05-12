package seminar2;

// 3. Дан следующий код, исправьте его там, где требуется

public class Exceptions002Task3 {
    // пробрасывать Exception не требуется,
    // т.к. все возможные исключения будут обработаны внутри метода
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            // возникновения IndexOutOfBoundsException можно избежать, например, с помощью
            // следующего кода:
            // int index = 3;
            // int[] abc = new int[index + 1];
            // abc[0] = 1;
            // abc[1] = 2;
            // abc[3] = 9;
            int[] abc = { 1, 2 };
            abc[3] = 9;
            // в данном коде отлавливать NullPointerException не требуется, т.к. массив abc
            // не равен null
            // } catch (NullPointerException ex) {
            // System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    // пробрасывать FileNotFoundException в данном методе не требуется,
    // т.к. работа с файлами в методе не ведется, FileNotFoundException
    // не возникнет
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
