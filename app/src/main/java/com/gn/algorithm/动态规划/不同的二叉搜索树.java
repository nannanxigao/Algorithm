package com.gn.algorithm.动态规划;

public class 不同的二叉搜索树 {
    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * 输入: 3
     * 输出: 5
     * 解释:
     * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * <p>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 以i为根 i-1为左子树， n-为右子树
//    G（n） 为结果
//    G（n）= （i = 1~n 之和）F（i，n）以i为根
//    F（i，n）= G(i-1)*G(n-i);
//    G（n）= （i = 1~n 之和）G(i-1)*G(n-i)

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int result = 0;

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {  // Gn取决于Gi=2、Gi=3.。。Gi=n  所以加2-n的循环
            for (int j = 1; j <= i; j++) {  // Gi 取决于 Gj=1...Gj=i 所以加 1~i的循环
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return result;
    }

}
