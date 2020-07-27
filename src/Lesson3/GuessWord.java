package Lesson3;

import java.util.Scanner;
import java.util.Random;

/*
2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
* */

public class GuessWord {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        do {
            int wordIndex = rand.nextInt(words.length);
            String secretWord = words[wordIndex];
            //System.out.println("Test: " + secretWord);
            boolean win = false;
            int counter = 1;
            do {
                System.out.printf("Попытка № %d%n", counter);
                String attemptValue = sc.nextLine().toLowerCase();

                if (attemptValue.equals(secretWord)) {
                    System.out.println("Поздравляю! Победа!!!");
                    break;
                } else {
                    System.out.println("Не угадали ;-Р");
                    printHint(secretWord, attemptValue);
                }

                counter++;
            } while(!win);

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет»");
            int userAnswer = sc.nextInt();
            if (userAnswer != 1) {
                gameOver = true;
                System.out.println("Как жаль! Возвращайтесь побыстрее!");
            }
        } while (!gameOver);

        sc.close();
    }

    public static void printHint(String secretWord, String attemptValue) {
        int placeholderLength = 15;
        char placeholder = '#';
        StringBuilder sb = new StringBuilder();
        int secretWordLength = secretWord.length();
        int attemptValueLength = attemptValue.length();

        for (int i = 0; i < placeholderLength; i++) {
            if ((secretWordLength - 1 < i) || (attemptValueLength - 1 < i)) {
                sb.append(placeholder);
                continue;
            }

            if (secretWord.charAt(i) == attemptValue.charAt(i)) {
                sb.append(secretWord.charAt(i));
            } else {
                sb.append(placeholder);
            }
        }
        System.out.println(sb.toString());
    }
}
