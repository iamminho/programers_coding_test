package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_번째_수 {
    /*
     * commands
     * 1. commands 의 [0],[1]만큼 subString 한다.
     * 2. subString한 값을 정렬한다.
     * 3. 정렬한 값중 commands[2]의 값을 출력한다.
     * */


    public static void main(String[] args) {
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] array = {1, 5, 2, 6, 3, 7, 4};


        List<Integer> results = solution(commands, array);
        System.out.println("results = " + results);


    }

    private static List<Integer> solution(int[][] commands, int[] array) {
        List<Integer> results = new ArrayList<>();
        for (int[] command : commands) {
            results.add(command(command, array));
        }
        return results;
    }

    private static int command(int[] cmd, int[] array) {
        int[] destArray = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]);
        Arrays.sort(destArray);
        return destArray[cmd[2] - 1];
    }
}


