class Solution {
    class DSU {
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
        }
        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }
        boolean union(int a,int b){
            int pa=find(a), pb=find(b);
            if(pa==pb) return false;
            parent[pa]=pb;
            return true;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        int left=1, right=200000, ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(can(n,edges,k,mid)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    boolean can(int n,int[][] edges,int k,int target){
        DSU dsu=new DSU(n);
        int used=0, upgrades=0;
        // mandatory edges
        for(int[] e:edges){
            if(e[3]==1){
                if(e[2] < target) return false;
                if(!dsu.union(e[0],e[1])) return false;
                used++;
            }
        }
        //optional edges without upgrade
        for(int[] e:edges){
            if(e[3]==0 && e[2]>=target){
                if(dsu.union(e[0],e[1]))
                    used++;
            }
        }
        //optional edges with upgrade
        for(int[] e:edges){
            if(e[3]==0 && e[2]<target && 2*e[2]>=target){
                if(dsu.union(e[0],e[1])){
                    upgrades++;
                    used++;
                    if(upgrades>k) return false;
                }
            }
        }
        return used==n-1;
    }
}