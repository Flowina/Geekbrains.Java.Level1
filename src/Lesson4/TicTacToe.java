package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        final int SIZE = 3;
        final char SYMBOL_HUMAN = 'X';
        final char SYMBOL_AI = 'O';
        final char SYMBOL_EMPTY = '*';
        char activeSymbol = SYMBOL_EMPTY;

        char[][] desk = createDesk(SIZE, SYMBOL_EMPTY);
        Cell lastHumanStep = null;
        boolean isDraw; // ничья
        int stepsTotal = 0;

        do {
            activeSymbol = toggleStep(activeSymbol, SYMBOL_EMPTY, SYMBOL_AI, SYMBOL_HUMAN);
            print(desk);

            if (activeSymbol == SYMBOL_HUMAN) {
                lastHumanStep = humanStep(desk, scanner, SYMBOL_HUMAN, SYMBOL_EMPTY);
            }
            if (activeSymbol == SYMBOL_AI) {
                aiStep(desk, SYMBOL_AI, SYMBOL_EMPTY, SYMBOL_HUMAN, lastHumanStep);
            }
            stepsTotal++;
            isDraw = stepsTotal == SIZE * SIZE;
        } while (!(isGameOver(desk, activeSymbol) || isDraw));
        print(desk);

        System.out.println("Game over!");

        if (isDraw) {
            System.out.println("Ничья!");
        } else {
            printWinner(activeSymbol, SYMBOL_AI, SYMBOL_HUMAN);
        }

        scanner.close();
    }

    private static char toggleStep(char active, char empty, char ai, char human) {
        if (active == empty || active == ai) {
            return human;
        } else {
            return ai;
        }
    }

    private static char[][] createDesk(int size, char emptySymbol) {
        char[][] desk = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                desk[i][j] = emptySymbol;
            }
        }
        return desk;
    }

    private static void print(char[][] desk) {
        System.out.println("------------");

        int size = desk.length;
        for (int i = 0; i <= size; i++) {
            System.out.print((i == 0 ? " " : i) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(desk[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static Cell humanStep(char[][] desk, Scanner scanner, char humanSymbol, char emptySymbol) {
        int x, y;
        boolean isCellValid;
        do {
            System.out.println("Введите координаты (строка столбец)");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
            isCellValid = isCellValid(x, y, desk, emptySymbol);
            if (!isCellValid) {
                System.out.println("Недопустимый ход. Попробуйте еще раз.");
            }
        }
        while (!isCellValid);

        desk[y][x] = humanSymbol;
        return new Cell(x, y);
    }

    private static void aiStep(char[][] desk, char aiSymbol, char emptySymbol, char humanSymbol, Cell lastHumanStep) {
        int size = desk.length;

        // ищем ход соперника, который приведет к победе
        Cell next = GetWinCell(desk, humanSymbol, emptySymbol, lastHumanStep);

        if (next != null) {
            desk[next.getY()][next.getX()] = aiSymbol;
            return;
        }

        Random random = new Random();
        int x;
        int y;

        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (!isCellValid(x, y, desk, emptySymbol));

        desk[y][x] = aiSymbol;
    }

    // проверка, свободная ли ячейка
    private static boolean isCellValid(int col, int row, char[][] desk, char emptySymbol) {
        int size = desk.length;
        return (col >= 0) && (col < size) && (row >= 0) && (row < size) && desk[row][col] == emptySymbol;
    }

    private static boolean isGameOver(char[][] desk, char activeSymbol) {
        int size = desk.length;
        /* проверяем строки */
        for (int i = 0; i < size; i++) {
            if (isRowWin(i, desk, activeSymbol)) {
                return true;
            }
        }

        /* проверяем столбцы */
        for (int i = 0; i < size; i++) {
            if (isColumnWin(i, desk, activeSymbol)) {
                return true;
            }
        }

        /* проверяем дигональ 1 */
        if (isDiagonalLeftWin(desk, activeSymbol)) {
            return true;
        }

        /* проверяем дигональ 2 */
        if (isDiagonalRightWin(desk, activeSymbol)) {
            return true;
        }

        return false;
    }

    private static Cell GetWinCell(char[][] desk, char activeSymbol, char emptySymbol, Cell prevCell) {
        int counter = 0;
        int size = desk.length;
        int prevX = prevCell.getX();
        int prevY = prevCell.getY();
        Cell emptyCell = null;

        // check row
        for (int i = 0; i < size; i++) {
            char value = desk[prevY][i];
            if ((value == emptySymbol)) {
                if (emptyCell == null) {
                    emptyCell = new Cell(i, prevY);
                } else {
                    emptyCell = null;
                    break;
                }
            } else if (value != activeSymbol) {
                emptyCell = null;
                break;
            }
        }

        if (emptyCell != null) {
            return emptyCell;
        }

        // check column
        for (int i = 0; i < size; i++) {
            char value = desk[i][prevX];
            if ((value == emptySymbol)) {
                if (emptyCell == null) {
                    emptyCell = new Cell(prevX, i);
                } else {
                    emptyCell = null;
                    break;
                }
            } else if (value != activeSymbol) {
                emptyCell = null;
                break;
            }
        }

        if (emptyCell != null) {
            return emptyCell;
        }

        // check diagonal 1
        for (int i = 0; i < size; i++) {
            char value = desk[i][i];
            if ((value == emptySymbol)) {
                if (emptyCell == null) {
                    emptyCell = new Cell(i, i);
                } else {
                    emptyCell = null;
                    break;
                }
            } else if (value != activeSymbol) {
                emptyCell = null;
                break;
            }
        }
        if (emptyCell != null) {
            return emptyCell;
        }
        // check diagonal 2
        for (int i = 0; i < size; i++) {
            char value = desk[i][size - i - 1];
            if ((value == emptySymbol)) {
                if (emptyCell == null) {
                    emptyCell = new Cell(i, size - i - 1);
                } else {
                    emptyCell = null;
                    break;
                }
            } else if (value != activeSymbol) {
                emptyCell = null;
                break;
            }
        }

        if (emptyCell != null) {
            return emptyCell;
        }
        return null;
    }

    private static void printWinner(char activeSymbol, char ai, char human) {
        if (activeSymbol == ai) {
            System.out.println("Вы проиграли");
        } else if (activeSymbol == human) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Непоняточка!");
        }
    }

    private static boolean isColumnWin(int rowNumber, char[][] desk, char symbol) {
        return isAllElementsEqual(desk[rowNumber], symbol);
    }

    private static boolean isRowWin(int colNumber, char[][] desk, char symbol) {
        int size = desk.length;
        char[] checkArray = new char[size];

        for (int i = 0; i < size; i++) {
            checkArray[i] = desk[i][colNumber];
        }
        return isAllElementsEqual(checkArray, symbol);
    }

    private static boolean isDiagonalLeftWin(char[][] desk, char symbol) {
        int size = desk.length;
        char[] checkArray = new char[size];

        for (int i = 0; i < size; i++) {
            checkArray[i] = desk[i][i];
        }
        return isAllElementsEqual(checkArray, symbol);
    }

    private static boolean isDiagonalRightWin(char[][] desk, char symbol) {
        int size = desk.length;
        char[] checkArray = new char[size];

        for (int i = 0; i < size; i++) {
            checkArray[i] = desk[i][size - i - 1];
        }
        return isAllElementsEqual(checkArray, symbol);
    }

    private static boolean isAllElementsEqual(char[] arr, char symbol) {
        int size = arr.length;
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == symbol) {
                counter++;
            }
        }
        return counter == size;
    }
}
