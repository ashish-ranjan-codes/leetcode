class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longestStreak = 0;

        for(int num : nums){
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);

                int sum = left + right + 1;
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);

                longestStreak = Math.max(longestStreak, sum);
            }
        }
        return longestStreak;
    }
}