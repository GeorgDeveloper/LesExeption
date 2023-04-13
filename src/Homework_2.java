import java.io.FileNotFoundException;
import java.util.Scanner;


public class Homework_2 {
    public static void main(String[] args) throws Exception {
        /* Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
        и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
        вместо этого, необходимо повторно запросить у пользователя ввод данных.*/
        System.out.println(getFractionalNumber());


        // Если необходимо, исправьте данный код

        taskTwo();

        // Дан следующий код, исправьте его там, где требуется (

        taskThree();

        /* Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/

        inputUser();

    }


    public static void inputUser() {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        try {
            if (input.isEmpty() || input.equals(" ")) {
                throw new Exception("Пустые строки вводить нельзя.");
            }
            System.out.println("Input: " + input);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void taskTwo(){
        double[] intArray = {1, 2, 5, 8, 7, 9, 8, 7, 9};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public static void taskThree() throws Exception {
        try {
            int a = 90;

            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 }; // не думаю что это стоит исправлять, если цель выкинуть исключение
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }



    public static float getFractionalNumber() {
        Scanner input = new Scanner(System.in);
        float number = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число: ");
            if (input.hasNextFloat()) {
                number = input.nextFloat();
                validInput = true;
            } else {
                System.out.println("Не корректный ввод. введите дробное число.");
                input.next();
            }
        }

        return number;
    }
}

