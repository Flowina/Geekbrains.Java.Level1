package Lesson1;

public class Main<number> {
    /*
    2.
     */
    public static void main(String[] args) {
        //2.
        byte a1 = 10;
        short b2 = 30000;
        int c1 = 1;
        long i3 = 2;
        float d1 = 23f;
        double e2 = 45D;
        char m1 = 'f';
        boolean v1 = true;
        String name = "dog";

        // 3
        int r = CountResult(1, 4, 5, 6);
        System.out.println(r);
        // 4
        System.out.println(IsSumBetween10and20(9, 20));

        //5
        IsNumberPositiveOrNegative(1);
        IsNumberPositiveOrNegative(0);
        IsNumberPositiveOrNegative(-1);

        //6
        System.out.println(IsNumberNegative(1));
        System.out.println(IsNumberNegative(0));
        System.out.println(IsNumberNegative(-1));
        //7
        PrintName("Bob");
        //8
        IsYearLeap(2020);
        IsYearLeap(2021);
    }

    /*3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры
    этого метода;*/
    private static int CountResult(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    /*4.Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    если да – вернуть true, в противном случае – false;*/
    public static boolean IsSumBetween10and20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /* 5.Написать метод,которому в качестве параметра передается целое число,метод должен напечатать в консоль положительное ли
    число передали,или отрицательное;Замечание:ноль считаем положительным числом.*/
    public static void IsNumberPositiveOrNegative(int a) {
        if (a >= 0) {

            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }
    // 6.Написать метод,которому в качестве параметра передается целое число,метод должен вернуть true,если число отрицательное;

    public static boolean IsNumberNegative(int a) {
        return a < 0;
    }
    // 7.Написать метод,которому в качестве параметра передается строка,обозначающая имя,метод должен вывести в консоль сообщение
    // «Привет,указанное_имя!»;

    public static void PrintName(String name) {

        System.out.println("Привет, " + name +"!");

    }
     /*
8.*Написать метод,который определяет является ли год високосным,и выводит сообщение в консоль.
Каждый 4-й год является високосным,кроме каждого 100-го,при этом каждый 400-й – високосный.*/

    public static void IsYearLeap(int year) {
        //напишите тут ваш код

        boolean leap_year = false;

        if(year%400 ==0){
            leap_year = true;
        }
        else if (year%100 ==0) {

        }
        else if (year%4 ==0) {
            leap_year = true;
        }
        System.out.println("Год " + year + (leap_year ? " - " : " - не") + "високосный");
    }

}










