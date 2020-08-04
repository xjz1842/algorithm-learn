package comalgorithms.leetcode;

public class Jump_45 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     */
    private static int jump(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];

        //base case
        dp[0] = 0;

        for (int i = 1, j = 0; i < len; i++) {

            while (j < i && (j + nums[j]) < i) j++;

            dp[i] = dp[j] + 1;
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};

        System.out.println(jump(arr));
    }

}
