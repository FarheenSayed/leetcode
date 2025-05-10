class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int maxI = values[0];
        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxI + values[j] - j);
            maxI = Math.max(maxI, values[j] + j);
        }
        return maxScore;
    }
}
