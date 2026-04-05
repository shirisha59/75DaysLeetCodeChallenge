class Solution {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        int len=moves.length();
        for(int i=0;i<len;i++){
            if(moves.charAt(i)=='L') x++;
            else if(moves.charAt(i)=='R') x--;
            else if(moves.charAt(i)=='U') y++;
            else y--;
        }
        return x==0 && y==0;
    }
}