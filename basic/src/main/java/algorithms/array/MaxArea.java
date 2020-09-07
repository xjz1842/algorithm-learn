package algorithms.array;

public class MaxArea {


    //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //说明：你不能倾斜容器，且 n 的值至少为 2。
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
    // 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    public static int maxArea(int[] height) {

        if (height.length == 0 || height.length == 1) return 0;


        int l = 0;
        int r = height.length - 1;

        int ans = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, (r - l) * height[l]);
                l++;
            } else {
                ans = Math.max(ans, (r - l) * height[r]);
                r--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        int[] strs = new int[]{1, 2, 1};

        System.out.println(maxArea(strs));
    }
}
