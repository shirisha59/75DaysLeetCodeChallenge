import java.util.*;

class Solution{
    public long minNumberOfSeconds(int mountainHeight,int[] workerTimes){
        long l=1,r=(long)1e18,ans=r;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(canReduce(mid,mountainHeight,workerTimes)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }

    boolean canReduce(long time,int height,int[] workerTimes){
        long total=0;
        for(int i=0;i<workerTimes.length;i++){
            int t=workerTimes[i];
            long x=(long)((Math.sqrt(1+8.0*time/t)-1)/2);
            total+=x;
            if(total>=height) return true;
        }
        return false;
    }
}