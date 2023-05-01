package level1;

import org.junit.jupiter.api.Test;

class 신고_결과_받기Test {
    @Test
    void one() {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = 신고_결과_받기.solution(id_list, report, k);
        int[] answer = new int[]{2, 1, 1, 0};
    }
}