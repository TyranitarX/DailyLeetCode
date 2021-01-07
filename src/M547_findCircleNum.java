public class M547_findCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] vis = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]){
                vis = dfs(isConnected, vis, i);
                count++;
            }
        }
        return count;
    }

    public boolean[] dfs(int[][] isConnected, boolean[] vis, int now) {
        vis[now] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[now][i] != 0 && !vis[i] && now != i) {
                vis = dfs(isConnected, vis, i);
            }
        }
        return vis;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        System.out.println(new M547_findCircleNum().findCircleNum(isConnected));
    }
}
