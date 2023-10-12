package leetcode.editor.cn;

import java.util.*;

/**
 * 题目标题 奖励最顶尖的 K 名学生
 * 题目标记 reward-top-k-students
 * 题目编号 2512
 * 时间 2023-10-11 20:59:32
 * 已提交
 */
public class RewardTopKStudents {
    public static void main(String[] args) {
        Solution solution = new RewardTopKStudents().new Solution();

        String[] positive_feedback = new String[]{"smart", "brilliant", "studious"};
        String[] negative_feedback = new String[]{"not"};
        String[] report = new String[]{"this student is studious", "the student is smart"};
        int[] student_id = new int[]{1, 2};
        int k = 2;

        // String[] positive_feedback = new String[]{"smart", "brilliant", "studious"};
        // String[] negative_feedback = new String[]{"not"};
        // String[] report = new String[]{"this student is not studious", "the student is smart"};
        // int[] student_id = new int[]{1, 2};
        // int k = 2;

        List<Integer> answers = solution.topStudents(positive_feedback, negative_feedback, report, student_id, k);

        System.out.println(answers);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 这个方法是融和了几个解决方案，用java的api来做的，几个方案都有可取之处，这里我优化整合了一下
         */
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            Queue<StudentInfo> studentQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1.score != o2.score) {
                    return o2.score - o1.score;
                }
                // 若分数相同 则按学生id排序
                return o1.id - o2.id;
            });

            // 这个哈希表用的非常巧妙
            Map<String, Integer> words = new HashMap<>();
            for (String s : positive_feedback) {
                words.put(s, 3);
            }
            for (String s : negative_feedback) {
                words.put(s, -1);
            }

            for (int i = 0; i < report.length; i++) {
                String[] split = report[i].split(" ");
                int score = 0;
                for (String s : split) {
                    // 这个哈希表用的非常巧妙
                    score += words.getOrDefault(s, 0);
                }
                StudentInfo studentInfo = new StudentInfo(student_id[i], score);
                studentQueue.offer(studentInfo);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(studentQueue.poll().id);
            }

            return result;
        }
    }

    /**
     * 也可以用二维数组做，但是java语言，面向对象更方便清晰
     */
    class StudentInfo {
        int id;
        int score;

        public StudentInfo(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
