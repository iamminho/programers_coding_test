package level1;
public class 시저암호 {
    public static void main(String[] args) {
        int n = 4;
        String s = "y W";
        solution(n, s);
    }

    public static void solution(int n, String s) {
        StringBuilder builder = new StringBuilder();

        for (char v: s.toCharArray()) {
            char moved;
            if (v == ' ') moved = ' ';
            else {
                int offset = getOffset(v);
                moved = move(n, v, offset);
            }
            builder.append(moved);
        }

        System.out.println("result = " + builder.toString());
    }

    public static int getOffset(char c) {
        return Character.isUpperCase(c) ? (int) 'A' : (int) 'a';
    }

    public static char move(int n, char c, int offset) {
        return (char) ((c + n - offset) % 26 + offset);
    }
}
