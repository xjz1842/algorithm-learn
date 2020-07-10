package comalgorithms.tree;


public class TransfomerTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 9, 6};

        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        //头节点
        int mid = l + (r - l) / 2;

        TreeNode head = new TreeNode(nums[mid]);
        head.left = buildTree(nums, l, mid - 1);
        head.right = buildTree(nums, mid + 1, r);

        return head;
    }

}


