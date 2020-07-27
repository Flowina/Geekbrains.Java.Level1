package Lesson3;

import java.util.Scanner;

import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        run();
    }

    /*1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
       * */
    public static void run() {
        int attemptsCount = 3;
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        do {
            // задать случайное число
            int secretNumber = rand.nextInt(10);
            System.out.printf("У Вас есть %d попытки%n", attemptsCount);
            for (int i = 0; i < attemptsCount; i++) {
                System.out.printf("Попытка № %d%n", i + 1);
                int attemptValue =getUserAttemptValue(sc,0,9);

                if (attemptValue == secretNumber) {
                    System.out.println("Поздравляю! Победа!!!");
                    break;
                } else {
                    System.out.println("Не угадали ;-Р");
                }
            }
            //После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»");
            int userAnswer = sc.nextInt();
            if (userAnswer != 1) {
                gameOver = true;
                System.out.println("Как жаль! Возвращайтесь побыстрее!");
            }
        } while (!gameOver);
        sc.close();
    }

    private static int getUserAttemptValue(Scanner sc, int min, int max) {
        while (true) {
            int attemptValue = sc.nextInt();
            if (attemptValue < min || attemptValue > max) {
                System.out.printf("Значение должно быть от %d до %d. Повторите попытку%n", min, max);
            } else {
                return attemptValue;
            }
        }
    }

}
