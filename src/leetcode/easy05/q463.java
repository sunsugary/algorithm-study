package leetcode.easy05;

/**
 * @ClassName: q463
 * @Author: 5753
 * @Date: 2022/11/17 15:28
 * @Description: TODO
 */
public class q463 {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    //由于题目限制只有一个岛屿，所以只要遍历到第一个土地就可以开始走了
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    public int islandPerimeter2(int[][] grid) {
        //两个土地相邻则会损失2两个长度
        //一块土地是四个长度
        //总周长 = land * 4 - border * 2;

        int land = 0;
        int border = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1){
                    land++;
                    if (r+1 < grid.length && grid[r+1][c] == 1 ){
                        border++;
                    }
                    if (c+1 < grid[r].length && grid[r][c+1] == 1){
                        border++;
                    }
                }
            }
        }
        return land * 4 - border * 2;
    }

    public int dfs(int[][] grid, int r, int c) {
        //r代表横坐标 c代表右左标
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[r].length)) {
            //定义这个网格的边界，如果超过了边界，那就是走到了边界
            return 1;
        }
        if (grid[r][c] == 0) {
            //走到了水域
            return 1;
        }
        if (grid[r][c] != 1) {
            //1为土地 0水域
            return 0;
        }

        grid[r][c] = 2; //2代表已走过

        return dfs(grid, r - 1, c) //下
                + dfs(grid, r + 1, c)//上
                + dfs(grid, r, c - 1)//左
                + dfs(grid, r, c + 1);//右
    }

}
