import java.util.*;

class Solution {

    int n;
    int[] count;
    int[] ans;
    List<List<Integer>> tree;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        count = new int[n];
        ans = new int[n];
        tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }
    private void dfs1(int node, int parent) {
        count[node] = 1;
        for (int nei : tree.get(node)) {
            if (nei == parent) continue;
            dfs1(nei, node);
            count[node] += count[nei];
            ans[node] += ans[nei] + count[nei];
        }
    }
    private void dfs2(int node, int parent) {
        for (int nei : tree.get(node)) {
            if (nei == parent) continue;
            ans[nei] = ans[node] - count[nei] + (n - count[nei]);
            dfs2(nei, node);
        }
    }
}