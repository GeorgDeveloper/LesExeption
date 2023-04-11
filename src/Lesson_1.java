/* Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
 Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
        1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
        2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
        3. если вместо массива пришел null, метод вернет -3
        4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
        Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит
        искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый
        результат пользователю. Например, если вернулся -2, пользователю выведется сообщение:
        “Искомый элемент не найден”.
*/
public class Lesson_1 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 6, 5, 4, 7, 9, 8};
        int[] arr2 = {1, 2};
        int n = 3;
        int m = 0;

        System.out.println(findingAnOccurrence(arr, n));
        System.out.println(findingAnOccurrence(arr, m));
        System.out.println(findingAnOccurrence(arr2, m));
        System.out.println(findingAnOccurrence(null, m));

        int[][] array1 = {{0,1,1},{0,1,1},{1,1,1}};
        int[][] array2 = {{0,1,1},{0,1,1},{1,1,2}};
        int[][] array3 = {{0,1,1},{0,1,1}};
        System.out.println(sumNumber(array1));
        //System.out.println(sumNumber(array2));
        System.out.println(sumNumber(array3));
    }

    public static int findingAnOccurrence(int[] array, int num) {
        int index = -2;
        if (array != null) {
            if (array.length < 3) {
                System.out.print("Ошибка: ");
                index = -1;
            } else {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == num) {
                        index = i;
                    }
                }
                if (index == -2) {
                    System.out.print("Ошибка: ");
                }
            }
        } else {
            System.out.print("Ошибка: ");
            index = -3;
        }
        return index;
    }

    /*Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    Необходимо посчитать и вернуть сумму элементов этого массива. При этом накладываем на метод 2 ограничения:
    метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
    и в каждой ячейке может лежать только значение 0 или 1. Если нарушается одно из условий,
    метод должен бросить RuntimeException с сообщением об ошибке.*/

    public static int sumNumber (int[][] arr){
        int result = 0;
        if (arr.length == arr[0].length){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] == 0 || arr[i][j] == 1){
                        result = result + arr[i][j];
                    } else {
                        throw new RuntimeException("Массив содержит недопустимые значения");
                    }
                }
            }
        } else {
            throw new RuntimeException("Не корректная длина массива");
        }
        return result;
    }
}