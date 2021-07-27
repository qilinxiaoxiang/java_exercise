package recursive.subdomain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: 项峥
 * @Date: 2021/7/7 22:14
 */
public class Solution {
    private Map<String, Integer> result = new HashMap<>();

    public List<String> subdomainVisits(String[] cpdomains) {
        Arrays.stream(cpdomains).forEach(e -> {
            String[] elements = e.split(" ");
            count(elements[1], Integer.parseInt(elements[0]));
        });
        return result.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
    }

    private void count(String domain, int count) {
        if (result.containsKey(domain)) {
            result.put(domain, result.get(domain) + count);
        } else {
            result.put(domain, count);
        }
        int index = domain.indexOf('.');
        if (index != -1) {
            count(domain.substring(index + 1), count);
        }
    }
}
