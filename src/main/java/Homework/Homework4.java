package Homework;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static char [][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("WIN MAN");
                break;
            }
            if (isMapFull()) {
                System.out.println("DRAW");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("WIN AI");
                break;
            }
            if (isMapFull()) {
                System.out.println("DRAW");
                break;
            }
        }System.out.println("GAME OVER");

    }

    public static void initMap () {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map [i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap (){
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" "+ (i+1) + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map [i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static Scanner sc = new Scanner(System.in);
    public static boolean isCellValid (int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }
    public static void  humanTurn (){
        int x, y;
        do {
            System.out.println("YOUR MOVE: X_Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map [x][y] = DOT_X;
    }
    public static Random rand = new Random();
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("AI MADE A MOVE " + (x+1) + " " + (y +1));
        map[x][y] = DOT_O;
    }
    public static boolean checkWin (char symb) {
       if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb ) return true;
       if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb ) return true;
       if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb ) return true;
       if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb ) return true;
       if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb ) return true;
       if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb ) return true;
       if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb ) return true;
       if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb ) return true;
            return false;
            //for (int i = 0; i < SIZE; i++) {
            //for (int j = 0; j < SIZE; j++) {
               // if (i==j || j==0 & i== rand.nextInt(SIZE))
                  //  map [i][j]= symb;
                 //   return true;
          //  }
       // }return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}
