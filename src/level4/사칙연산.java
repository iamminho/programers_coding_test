package level4;

public class 사칙연산 {
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "-", "3", "+", "5", "-", "8"};
        int result = solution(arr);
        System.out.println("result = " + result);
    }

    private static int solution(String[] arr) {
        return max(0, arr.length, arr);
    }

    private static int max(int start, int end, String[] arr) {
        //종료조건
        if (end - start == 1) return Integer.parseInt(arr[start]);
        int max = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = max(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = max(i + 1, end, arr);
                v = l + r;
            } else {
                int r = min(i + 1, end, arr);
                v = l - r;
            }
            if (v > max) max = v;
        }
        return max;
    }

    private static int min(int start, int end, String[] arr) {
        if (end - start == 1) return Integer.parseInt(arr[start]);
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i += 2) {
            int l = min(start, i, arr);
            int v;
            if (arr[i].equals("+")) {
                int r = min(i + 1, end, arr);
                v = l + r;
            } else {
                int r = max(i + 1, end, arr);
                v = l - r;
            }
            if (v < min) min = v;
        }
        return min;
    }
}
