package backtracking;

public class KnapsackProblem {
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }
}

class KnapsackProblemWithCache {
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3}; // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    private boolean[][] cache = new boolean[5][10];

    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (cache[i][cw]) {
            return; // 重复状态, 之前算过了
        }
        cache[i][cw] = true; // 记录状态
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }
}

class KnapsackProblemWithValue {
    private int maxV = Integer.MIN_VALUE;
    private int[] weight = {2, 2, 4, 6, 3};
    private int[] value = {3, 4, 8, 9, 6};
    private int n = 5;
    private int w = 9;

    public void f(int i, int cw, int cv) { // 调用f(0,0,0)
        if (cw == w || i == n) {
            if (cv > maxV) {
                maxV = cv;
            }
            return;
        }
        f(i + 1, cw, cv); // 选择不装第i件物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], cv + value[i]); // 选择装第i件物品
        }

    }
}