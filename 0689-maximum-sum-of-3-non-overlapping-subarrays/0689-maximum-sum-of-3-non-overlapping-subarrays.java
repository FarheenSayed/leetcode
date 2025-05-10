class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum_k = new int[n - k + 1];
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        sum_k[0] = currentSum;
        for (int i = 1; i <= n - k; i++) {
            currentSum += nums[i + k - 1] - nums[i - 1];
            sum_k[i] = currentSum;
        }

        int[] left_max = new int[sum_k.length];
        int[] right_max = new int[sum_k.length];

        int best = 0;
        for (int i = 0; i < sum_k.length; i++) {
            if (sum_k[i] > sum_k[best]) {
                best = i;
            }
            left_max[i] = best;
        }

        best = sum_k.length - 1;
        for (int i = sum_k.length - 1; i >= 0; i--) {
            if (sum_k[i] >= sum_k[best]) {
                best = i;
            }
            right_max[i] = best;
        }

        int maxSum = 0;
        int[] result = new int[3];
        for (int j = k; j < sum_k.length - k; j++) {
            int i = left_max[j - k];
            int l = right_max[j + k];
            int total = sum_k[i] + sum_k[j] + sum_k[l];
            if (total > maxSum) {
                maxSum = total;
                result[0] = i;
                result[1] = j;
                result[2] = l;
            }
        }

        return result;
    }
}
