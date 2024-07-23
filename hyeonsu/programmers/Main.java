package hyeonsu.programmers;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        길_찾기_게임 game = new 길_찾기_게임();

        int[][] input = {{5 ,3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] otherInput = {{8, 6}, {3, 5}, {11, 5}, {7, 4}};
        int[][] oneInput = {{0, 0}};
        Integer[][] output = game.solution(input);

        System.out.println(Arrays.toString(output[0]));
        System.out.println(Arrays.toString(output[1]));
    }
}
