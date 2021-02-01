package Problem.P0200T0299;

public class P0238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, ls = 0, rs = len-1;
        int[] L = new int[len], R = new int[len], answer = new int[len];
        L[0] = nums[0];
        for (int i = 1; i < len; i++)
            L[i] = L[i-1] * nums[i];
        R[rs] = nums[rs];
        for (int i = rs-1; i >= 0; i--)
            R[i] = R[i+1] * nums[i];
        answer[0] = R[1];
        answer[rs] = L[rs-1];
        for (int i = 1; i < rs; i++)
            answer[i] = L[i-1] * R[i+1];
        return answer;
    }
    public static void main(String[] args) {
        P0238 solution = new P0238();
        int[] nums1 = {2, 1, 1, 2};
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(solution.productExceptSelf(nums1));
        System.out.println(solution.productExceptSelf(nums2));
    }
}
