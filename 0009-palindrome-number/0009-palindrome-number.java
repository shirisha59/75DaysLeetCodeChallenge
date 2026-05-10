class Solution {
    public boolean isPalindrome(int n) {
        int rev=0;
        int x=n;
        while(n>0){
            int rem = n%10;
            rev=rev*10+rem;
            n=n/10;
        }
        if(x==rev) return true;
        else return false;
    }
}