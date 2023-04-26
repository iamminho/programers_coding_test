package level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    public static class Word {
        String name;
        int order;

        public Word(String name, int order) {
            this.name = name;
            this.order = order;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = solution(begin, target, words);
        System.out.println("answer = " + answer);
    }

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<Word> que = new LinkedList<>();
        que.add(new Word(begin, 0));
        int min = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            Word w = que.poll();
            String w_name = w.name;
            int w_order = w.order;

            if (w_name.equals(target)) {
                min = Math.min(min, w.order);
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(w_name, words[i])) {
                    que.add(new Word(words[i], w_order + 1));
                    visited[i] = true;
                }
            }
        }

        if (min > 50) return 0;
        return min;
    }

    private static boolean canChange(String begin, String word) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) count++;
        }

        return count == 1;
    }
}
