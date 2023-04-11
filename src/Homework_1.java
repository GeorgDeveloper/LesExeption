public class Homework_1 {
    /*Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
 Если длины массивов не равны, необходимо как-то оповестить пользователя.
* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException,
 т.е. ваше.*/

    public static int[] sumNumberArray(int[] arrOne, int[] arrTwo) {
        int len = arrOne.length;
        int[] resultArr = new int[len];
        if (arrOne.length == arrTwo.length) {
            for (int i = 0; i < resultArr.length; i++) {
                resultArr[i] = arrOne[i] + arrTwo[i];
            }
        } else {
            System.out.println("Не корректная длина массива");
            return null;
        }
        return resultArr;
    }

    public static int[] partialNumberArray(int[] arrOne, int[] arrTwo) {
        int len = arrOne.length;
        int[] resultArr = new int[len];
        if (arrOne.length == arrTwo.length) {
            for (int i = 0; i < resultArr.length; i++) {
                if (arrTwo[i] != 0) {
                    resultArr[i] = arrOne[i] / arrTwo[i];
                } else {
                    resultArr[i] = 0;
                }
            }
        } else {
            throw new RuntimeException("Не корректная длина массива");
        }
        return resultArr;
    }

    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            throw new RuntimeException("Пустой массив");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 5, 4, 7, 9, 8};
        int[] arr2 = {1, 2, 4, 6, 5, 9, 2, 3, 9};

        System.out.println("Массив:");
        printArray(arr);
        System.out.println("Массив:");
        printArray(arr2);
        System.out.println("Результа суммирования:");
        printArray(sumNumberArray(arr, arr2));

        System.out.println("Результа поиска частного:");
        printArray(partialNumberArray(arr, arr2));
    }
}
