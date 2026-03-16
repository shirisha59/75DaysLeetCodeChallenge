import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortedstring = new String(chars);

            if(!map.containsKey(sortedstring)){
                map.put(sortedstring, new ArrayList<>());
            }

            map.get(sortedstring).add(str);
        }

        result.addAll(map.values());
        return result;
    }
}