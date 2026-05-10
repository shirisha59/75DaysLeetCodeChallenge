class Solution {
    public boolean isPalindrome(String s) {
        String t=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left=0;
        int right=t.length()-1;
        while(left<right){
            if(t.charAt(left)!=t.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}