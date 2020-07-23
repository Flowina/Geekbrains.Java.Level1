package Lesson2;

public class Main {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("1. Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;");
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задан массив:");
        printArr(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        System.out.println("Результат:");
        printArr(nums);

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;");

        int[] array = new int[8];
        System.out.println("Задан массив:");
        printArr(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        System.out.println("Результат:");
        printArr(array);
        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;");

        int[] nums1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < nums.length; i++) {
            if (nums1[i] < 6) {

                nums1[i] = nums1[i] * 2;
            }
        }
        printArr(nums1);
        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;");
        int size = 10;
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (i == k) {
                    table[i][k] = 1;
                    table[i][size - k - 1] = 1;
                }
            }
        }
        printArr(table);

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);");
        int[] arr = {1, 5, 3, 2, 11, -4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задан массив:");
        printArr(arr);

        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (min > a) {
                min = a;
            }
            if (max < a) {
                max = a;
            }
        }
        System.out.println("Результат:");
        System.out.println("Min = " + min + ", Max = " + max);

        /* 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.*/
        System.out.println("6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.");
        //int[] task6Array = {2, 2, 2, 1, 2, 2, 10, 1};
        //int[] task6Array = {2, 2, 2, 1, 2, 2, 10, 2};
        int[] task6Array = {5, 1, 1, 7, -2};
        System.out.println("Задан массив:");
        printArr(task6Array);
        System.out.println("Результат:" + checkBalance(task6Array));

        /* 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементымассива на n позиций.
         Для усложнения задачи нельзя пользоваться вспомогательными массивами.*/
        System.out.println("7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.");
        int[] task7Array = {1, 2, 3, 4, 5};
        System.out.println("Задан массив:");
        printArr(task7Array);
        //int n = 3;
        //int n = 0;
        //int n = -3;
        int n = 7;
        System.out.println("Сдвинуть на: " + n);
        shiftArray(task7Array, n);
        System.out.println("Результат:");
        printArr(task7Array);
    }

    private static boolean checkBalance(int[] arr) {
        int totalSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            totalSum = totalSum + arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum = leftSum + arr[i];
            int rightSum = totalSum - leftSum;
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    private static void shiftArray(int[] arr, int n) {
        int length = arr.length;
        if (length == 0) {
            return;
        }
        int _shift;
        // если смещение больше размера массива
        if (n > length) {
            _shift = n % length;
        } else {
            _shift = n;
        }

        if (_shift == 0) {
            return;
        }

        boolean isForward = _shift >= 0;
        int absShift = _shift < 0 ? (_shift * -1) : _shift;
        for (int i = 0; i < absShift; i++) {
            int temp = isForward ? arr[length - 1] : arr[0];
            if (isForward) {
                for (int j = length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[0] = temp;
            } else {
                for (int j = 0; j < length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[length - 1] = temp;
            }
        }

    }

    public static void printArr(int[] arr) {
        //Вывод результата.
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("] ");
    }

    public static void printArr(int[][] arr) {
        //Вывод результата.
        for (int i = 0; i < arr.length; i++) {
            printArr(arr[i]);
        }
    }

}
