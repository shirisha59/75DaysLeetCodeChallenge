class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int start =0;
        int end=0;
        int max_length=0;
        List<Character> ls=new ArrayList<Character>();
        while(end<s.length()){
            if(!ls.contains(s.charAt(end))){
                ls.add(s.charAt(end));
                end++;
                max_length=Math.max(max_length,ls.size());

            }
            else{
                ls.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max_length;
    }
}