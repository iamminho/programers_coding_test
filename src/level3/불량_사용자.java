package level3;

import java.util.*;

/*
 *  frodo crodo / frodo crodo / abc123 frodoc
 *  frodo , crodo, abc123
 *  frodo, crodo, frodoc
 *
 * 1. frodo, crodo, abc123, frodoc

 * 3. 재귀로 돌며 각 ban_id가 선택할 수 있는 단어들을 선택한다.
 * 4. 종료조건: 각 ban_id가 모두 선택했을때
 *
 *
 * */

public class 불량_사용자 {
    private static List<String> items;
    private static Set<Set<String>> set = new HashSet<>();

    public static void main(String[] args) {
        String[] user_id = {"12345", "12453", "aaaaa"};
        String[] banned_id = {"*****", "*****"};
        int result = solution(user_id, banned_id);
        System.out.println("result = " + result);
    }

    private static int solution(String[] user_id, String[] banned_id) {
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        items = getItems(bans);
        recursion(0, bans, new HashSet<>());

        return set.size();
    }

    private static List<String> getItems(String[][] bans) {
        Set<String> set = new HashSet<>();
        for (String[] ban : bans) {
            for (String s : ban) {
                set.add(s);
            }
        }
        return new ArrayList<>(set);
    }

    private static void recursion(int layer, String[][] bans, Set<String> banSet) {
        if (layer == bans.length) {
            System.out.println("banSet = " + banSet);
            set.add(new HashSet<>(banSet)); // set에 그냥 banSet을 add하면 테스트케이스에서 실패가 뜬다. 아마 얕은복사, 깊은복사 때문일 것이다.
            // 그러므로 새로운 객체에 담아서 add해준다.
            return;
        }

        String[] arr = bans[layer];
        for (int i = 0; i < arr.length; i++) {
            if (items.contains(arr[i])) {
                items.remove(arr[i]);
                banSet.add(arr[i]);
                recursion(layer + 1, bans, banSet);
                items.add(arr[i]);
                banSet.remove(arr[i]);
            }
        }
    }
}
