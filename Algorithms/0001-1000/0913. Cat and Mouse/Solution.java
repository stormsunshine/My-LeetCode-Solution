class Solution {
    public int catMouseGame(int[][] graph) {
        int nodes = graph.length;
        int[][][] memo = new int[nodes * 2][nodes][nodes];
        for (int i = nodes * 2 - 1; i >= 0; i--) {
            for (int j = nodes - 1; j >= 0; j--) {
                for (int k = nodes - 1; k >= 0; k--)
                    memo[i][j][k] = -1;
            }
        }
        return catMouseGame(graph, memo, 0, 1, 2);
    }

    public int catMouseGame(int[][] graph, int[][][] memo, int step, int mouse, int cat) {
        int nodes = graph.length;
        if (step == nodes * 2)
            return 0;
        else if (memo[step][mouse][cat] != -1)
            return memo[step][mouse][cat];
        else if (mouse == cat) {
            memo[step][mouse][cat] = 2;
            return 2;
        } else if (mouse == 0) {
            memo[step][mouse][cat] = 1;
            return 1;
        } else {
            if (step % 2 == 0) {
                boolean catWin = true;
                int[] nextMouseNodes = graph[mouse];
                for (int nextMouse : nextMouseNodes) {
                    int nextResult = catMouseGame(graph, memo, step + 1, nextMouse, cat);
                    if (nextResult == 1) {
                        memo[step][mouse][cat] = 1;
                        return 1;
                    } else if (nextResult == 0)
                        catWin = false;
                }
                if (catWin)
                    memo[step][mouse][cat] = 2;
                else
                    memo[step][mouse][cat] = 0;
            } else {
                boolean mouseWin = true;
                int[] nextCatNodes = graph[cat];
                for (int nextCat : nextCatNodes) {
                    if (nextCat != 0) {
                        int nextResult = catMouseGame(graph, memo, step + 1, mouse, nextCat);
                        if (nextResult == 2) {
                            memo[step][mouse][cat] = 2;
                            return 2;
                        } else if (nextResult == 0)
                            mouseWin = false;
                    }
                }
                if (mouseWin)
                    memo[step][mouse][cat] = 1;
                else
                    memo[step][mouse][cat] = 0;
            }
            return memo[step][mouse][cat];
        }
    }
}