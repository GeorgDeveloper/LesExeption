import java.io.*;
import java.util.Scanner;

public class UserData {
    //Homework_3
    /* Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
     разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных:
фамилия, имя, отчество - строки

дата_рождения - строка формата dd.mm.yyyy

номер_телефона - целое беззнаковое число без форматирования

пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
 вернуть код ошибки, обработать его и показать пользователю сообщение,
 что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в
 одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
 пользователь должен увидеть стектрейс ошибки.*/
    private String lastName;
    private String firstName;
    private String patronymic;
    private String birthdate;
    private long phoneNumber;
    private char gender;

    public UserData(String lastName, String firstName, String patronymic, String birthdate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String toDataString() {
        return String.format("%s;%s;%s;%s;%d;%c", lastName, firstName, patronymic, birthdate, phoneNumber, gender);
    }

    public static void newData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите данные пользователя в следующем формате: Фамилия, имя, отчество, " +
                "дата рождения (дд.мм.гггг), номер телефона, пол (f или m): ");
        String[] userData = scanner.nextLine().split(" ");
        scanner.close();

        if (userData.length != 6) {
            System.err.println("Неверное количество аргументов. Ожидал 6, но получил" + userData.length);
            System.exit(1);
        }

        String lastName = userData[0];
        String firstName = userData[1];
        String patronymic = userData[2];

        String birthdate = userData[3];
        if (!birthdate.matches("\\d{2}.\\d{2}.\\d{4}")) {
            System.err.println("Неверный формат даты рождения. Ожидаемый дд.мм.гггг");
            System.exit(1);
        }

        long phoneNumber = 0;
        try {
            phoneNumber = Long.parseLong(userData[4]);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат телефонного номера. Ожидалось целое число без знака.");
            System.exit(1);
        }

        char gender = userData[5].charAt(0);
        if (gender != 'f' && gender != 'm') {
            System.err.println("Недопустимый пол. Ожидаемый f или m.");
            System.exit(1);
        }

        UserData user = new UserData(lastName, firstName, patronymic, birthdate, phoneNumber, gender);

        String filename = lastName + ".txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(user.toDataString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Пользовательские данные, записанные в файл " + filename);
    }

    public static void readData(String nameFile){
        File file = new File(nameFile);

        if (!file.exists() || !file.canRead() || file.length() == 0) {
            System.out.println("Unable to read file: " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(";");
                for (String data : userData) {
                    System.out.print(data + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        newData();
        readData("Иванов.txt");
    }


}


