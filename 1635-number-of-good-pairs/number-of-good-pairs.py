class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        count = Counter()
        result = 0
        for num in nums:
            result += count[num]
            count[num] += 1
        return result