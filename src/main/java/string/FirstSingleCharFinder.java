package string;

import java.util.HashMap;

public class FirstSingleCharFinder {
    public int getFirstSingleChar(String str) {
        int len = str.length();
        if (len == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
