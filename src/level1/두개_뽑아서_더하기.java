package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두개_뽑아서_더하기 {
    public static void main(String[] args) {
        int[] numbers = {5, 0, 2, 7};
        solution(numbers);
    }

    private static void solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);
    }
}
