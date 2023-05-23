package seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/*
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
 * Фамилия Имя Отчество дата_рождения номер_телефона пол
 * 
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата_рождения - строка формата dd.mm.yyyy
 * номер_телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * 
 * Приложение должно проверить введенные данные по количеству. 
 * Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
 * что он ввел меньше и больше данных, чем требуется.
 * 
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
 * Можно использовать встроенные типы java и создать свои.
 * Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 * 
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
 * в него в одну строку должны записаться полученные данные, вида
 * <Фамилия> <Имя> <Отчество> <датарождения> <номертелефона> <пол>
 * 
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * 
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
 * пользователь должен увидеть стектрейс ошибки.
 */

public class Exceptions003 {
    public static void main(String[] args) {
        String[] keys = { "Фамилия", "Имя", "Отчество", "дата_рождения формата dd.mm.yyyy",
                "номер_телефона - целое беззнаковое число без форматирования", "пол - символ латиницей f или m" };
        Scanner scan = new Scanner(System.in);

        Map<String, String> dataValues = getData(scan, keys);

        if (checkData(dataValues, keys)) {
            String data = "";
            for (String key : keys) {
                data += dataValues.get(key);
                data += " ";
            }

            try (FileWriter file = new FileWriter("./seminar3/" + dataValues.get("Фамилия") + ".txt", true)) {
                file.write(data.trim() + "\n");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл.");
                e.printStackTrace();
            }
        }
    }

    public static Map<String, String> getData(Scanner sc, String[] key) {
        Map<String, String> data = new HashMap<>();
        int length = key.length;
        int i = 0;
        String scanNext = " ";

        while (!scanNext.equals("")) {
            if (i < length) {
                System.out.println(key[i] + ": -->");
                scanNext = sc.nextLine();
                data.put(key[i], scanNext);
            } else {
                scanNext = sc.nextLine();
                if (!scanNext.equals("")) {
                    data.put("" + i, scanNext);
                }
            }
            i++;
        }
        return data;
    }

    private static int checkDataQuantity(int size, int length) {
        if (size > length) {
            return -1;
        }

        if (size < length) {
            return -10;
        }

        return 0;
    }

    private static boolean checkDateOfBirdth(Map<String, String> data, String key) {
        String dateOfBirdth = data.get(key);
        if (dateOfBirdth.length() != 10 || dateOfBirdth.charAt(2) != '.' || dateOfBirdth.charAt(5) != '.') {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                System.out.println(
                        "Ошибка ввода данных! Дата рождения введена в неверном формате. Необходимо ввести дату рождения в формате dd.mm.yyyy, где dd, mm, yyyy - целые беззнаковые числа.");
                return false;
            }
        }

        int day = 0;
        int month = 0;
        int year = 0;

        try {
            day = Integer.parseInt(dateOfBirdth.substring(0, 2));
            month = Integer.parseInt(dateOfBirdth.substring(3, 5));
            year = Integer.parseInt(dateOfBirdth.substring(6));
        } catch (NumberFormatException e) {
            System.out.println(
                    "Ошибка ввода данных! Дата рождения введена в неверном формате. Необходимо ввести дату рождения в формате dd.mm.yyyy, где dd, mm, yyyy - целые беззнаковые числа.");
            return false;
        }

        if (day < 0 || month < 0 || year < 0) {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                System.out.println(
                        "Ошибка ввода данных! Дата рождения введена в неверном формате. День, месяц и год рождения не могут быть отрицательными числами.");
                return false;
            }
        }

        if (day > 31 || month > 12) {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                System.out.println(
                        "Ошибка ввода данных! Дата рождения введена в неверном формате. День рождения не может быть больше числа 31. Месяц рождения не может быть больше числа 12.");
                return false;
            }
        }
        return true;
    }

    private static boolean checkTelephone(Map<String, String> data, String key) {
        String telNumber = data.get(key);

        try {
            if (telNumber.charAt(0) == '-') {
                throw new NumberFormatException();
            }
            Long.parseLong(telNumber);
        } catch (NumberFormatException e) {
            System.out.println(
                    "Ошибка ввода данных! Номер телефона задан в неверном формате, необходимо ввести целое беззнаковое число без форматирования.");
            return false;
        }

        return true;
    }

    private static boolean checkSex(Map<String, String> data, String key) {
        String sex = data.get(key);
        if (sex.length() > 1 || !sex.equals("f") && !sex.equals("m")) {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                System.out.println(
                        "Ошибка ввода данных! Неверно задан пол. Чтобы задать пол, необходимо ввести один символ латиницей f или m.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkData(Map<String, String> data, String[] keys) {
        int errorCode = checkDataQuantity(data.size(), keys.length);
        boolean result = false;

        if (errorCode == -1) {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                System.out.println("Ошибка ввода данных! Введено больше данных, чем требуется.");
                return result;
            }
        }

        if (errorCode == -10) {
            try {
                throw new DataFormatException();
            } catch (DataFormatException e) {
                System.out.println("Ошибка ввода данных! Введено меньше данных, чем требуется.");
                return result;
            }
        }

        if (!checkDateOfBirdth(data, keys[3])) {
            return result;
        }

        if (!checkTelephone(data, keys[4])) {
            return result;
        }

        result = checkSex(data, keys[5]);

        return result;
    }
}