class Solution:
    def findClosestNumber(self, nums):
        close = nums[0]
        for x in nums:
            if abs(x) < abs(close) or (abs(x) == abs(close) and x > close):
                close = x
        return close
