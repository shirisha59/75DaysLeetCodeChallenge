class Solution {


    private List<Integer>[] graph;
    private int []inDegree;
    private void buildGraph(int n, int [][]edges) {
        graph = new ArrayList[n]; inDegree = new int[n];
        for(int i = 0; i < n; i += 1) graph[i] = new ArrayList<>();
        inDegree = new int[n];
        for(int []edge : edges) {
            int from = edge[0], to = edge[1]; 
            graph[from].add(to); inDegree[to] += 1;
        }
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        buildGraph(n, edges);

        char []ch = colors.toCharArray();

        Queue<Integer> queue = new LinkedList<>();
        int [][]cache = new int[n][26];
        int processed = 0;
        for(int i = 0; i < n; i += 1) {
            if(inDegree[i] == 0) {
                queue.add(i);
                cache[i][ch[i] - 'a'] = 1;
            }
        }
        int largestColoring = -1;
        while(!queue.isEmpty()) {
            int node = queue.remove();
            processed += 1;

            for(int child : graph[node]) {
                for(int color = 0; color < 26; color += 1) {
                    cache[child][color] = Math.max(cache[child][color],
                    cache[node][color] + ((color == (ch[child] - 'a')) ? 1 : 0));
                }
                inDegree[child] -= 1;
                if(inDegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        if(processed != n) return -1;
        for(int node = 0; node < n; node += 1) {
            for(int color = 0; color < 26; color += 1) {
                largestColoring = Math.max(largestColoring, cache[node][color]);
            }
        }
        return largestColoring;
    }
}