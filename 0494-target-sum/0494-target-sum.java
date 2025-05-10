class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return calculate(nums, 0, 0, target, memo);
    }

    private int calculate(int[] nums, int index, int currentSum, int target, Map<String, Integer> memo) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = index + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = calculate(nums, index + 1, currentSum + nums[index], target, memo);
        int subtract = calculate(nums, index + 1, currentSum - nums[index], target, memo);
        
        memo.put(key, add + subtract);
        return add + subtract;
    }
}
