package leetcode.editor.cn;

/**
 * 题目标题 省份数量
 * 题目标记 number-of-provinces
 * 题目编号 547
 * 时间 2023-10-07 16:56:44
 * 已提交
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        // int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};// 2
        // int[][] isConnected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};// 3
        int[][] isConnected = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};// 1

        int n = solution.findCircleNum(isConnected);
        System.out.println(n);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            if (isConnected == null || isConnected.length == 0) {
                return 0;
            }

            // 先构建一下数组
            int length = isConnected.length;

            // 初始化并查集对象
            UnionFind unionFind = new UnionFind(length);

            // 开始合并操作
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    // 有连接的城市才需要合并
                    if (isConnected[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }

            return unionFind.getCount();
        }
    }

    class UnionFind {
        int[] cities;
        int[] levels;

        int count;

        public UnionFind(int size) {
            cities = new int[size];
            levels = new int[size];
            count = size;

            for (int i = 0; i < size; i++) {
                cities[i] = i;// 先初始化 自己是自己的根
                levels[i] = 1;// 先初始化 层级全都置为1
            }
        }

        public int find(int city) {
            if (city == cities[city]) {
                return city;
            }

            // 这一句就是传说中的 路径压缩，第一次直接找到根后面就不用一层一层的找了，降低了时间复杂度
            return cities[city] = find(cities[city]);
        }


        public void union(int x, int y) {
            int cityX = find(x);
            int cityY = find(y);
            if (cityX != cityY) {
                // 根不同，开始合并，先判断层级
                if (levels[cityX] > levels[cityY]) {
                    // 如果x比y的层级高，则把y的根置成x的根，相当于小的往大的合并
                    cities[cityY] = cities[cityX];
                } else if (levels[cityX] < levels[cityY]) {
                    cities[cityX] = cities[cityY];
                } else {
                    cities[cityY] = cities[cityX];
                    levels[cityX] += 1;
                }

                // 合并的时候直接就减了，不用再遍历一下找根的数量了
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}
