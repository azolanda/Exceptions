package seminar1;

public class Exceptions001 {
    public static void main(String[] args) {
        // ------------ 1 ------------
        // System.out.println(divide(29, 0));

        // int[] arr1 = { 2, 3, 4, 5 };
        // System.out.println(getFiveElementsSum(arr1));

        // System.out.println(isEven(0));

        // ------------ 3 ------------
        int[] arr2 = { 2, 0, 5, 3 };
        int[] arr3 = { 7, 4, 3 };
        // int[] arrResult1 = diffArrays(arr2, arr3);
        // for (int i = 0; i < arrResult1.length; i++) {
        // System.out.println(arrResult1[i]);
        // }

        // ------------ 4 ------------
        int[] arr4 = { 7, 0, 3, 0 };
        int[] arrResult2 = divideArrays(arr2, arr4);
        // for (int i = 0; i < arrResult2.length; i++) {
        // System.out.println(arrResult2[i]);
        // }
    }

    // 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо!");
        }
        return a / b;
    }

    public static int getFiveElementsSum(int[] array) {
        int fiveElementsSum = 0;
        for (int i = 0; i < 5; i++) {
            if (array.length < 5) {
                throw new ArrayIndexOutOfBoundsException("Выход за пределы массива недопустим!");
            }

            fiveElementsSum += array[i];
        }
        return fiveElementsSum;
    }

    public static boolean isEven(int num) {
        if (num == 0) {
            throw new IllegalArgumentException("Аргумент, равный нулю, недопустим!");
        }

        return num % 2 == 0;
    }

    // 3. Реализуйте метод, принимающий в качестве аргументов два целочисленных
    // массива, и возвращающий новый массив, каждый элемент которого равен разности
    // элементов двух входящих массивов в той же ячейке. Если длины массивов не
    // равны, необходимо как-то оповестить пользователя.

    public static int[] diffArrays(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            if (array1.length > 0) {
                int[] result = new int[array1.length];

                for (int i = 0; i < array1.length; i++) {
                    result[i] = array2[i] - array1[i];
                }

                return result;
            } else {
                throw new RuntimeException("Передан пустой массив!");
            }

        } else {
            throw new RuntimeException("Переданы массивы разной длины!");
        }
    }

    // *
    // Реализуйте метод, принимающий в качестве аргументов два целочисленных
    // массива, и возвращающий новый массив, каждый элемент которого равен
    // частному элементов двух входящих массивов в той же ячейке.
    // Если длины массивов не равны, необходимо как-то оповестить пользователя.
    // Важно: При выполнении метода единственное исключение,
    // которое пользователь может увидеть - RuntimeException,т.е.ваше.

    public static int[] divideArrays(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            if (array1.length > 0) {
                int[] result = new int[array1.length];

                for (int i = 0; i < array1.length; i++) {
                    if (array1[i] == 0) {
                        throw new RuntimeException("Деление на ноль недопустимо!");
                    }
                    result[i] = array2[i] / array1[i];
                }

                return result;
            } else {
                throw new RuntimeException("Передан пустой массив!");
            }

        } else {
            throw new RuntimeException("Переданы массивы разной длины!");
        }
    }
}