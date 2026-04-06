import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();

        // Store obstacles (using normal loop)
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            set.add(x + "," + y);
        }

        int[][] dirs = {
            {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        int x = 0, y = 0;
        int dir = 0; // North
        int maxDist = 0;

        // Loop through commands (normal loop)
        for (int i = 0; i < commands.length; i++) {
            int cmd = commands[i];

            if (cmd == -1) {
                dir = (dir + 1) % 4; // right
            } 
            else if (cmd == -2) {
                dir = (dir + 3) % 4; // left
            } 
            else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if (set.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}