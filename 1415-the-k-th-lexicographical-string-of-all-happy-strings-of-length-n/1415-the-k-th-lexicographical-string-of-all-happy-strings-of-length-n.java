import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack("", n);
        if(k > list.size()) return "";
        return list.get(k - 1);
    }

    void backtrack(String s, int n) {
        if(s.length() == n) {
            list.add(s);
            return;
        }

        for(char c : new char[]{'a','b','c'}) {
            if(s.length() == 0 || s.charAt(s.length()-1) != c) {
                backtrack(s + c, n);
            }
        }
    }
}