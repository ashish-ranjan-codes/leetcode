class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int curr = 1, prev = 0, ans = 0;

        for(int i=1; i<n; i++){
            if(nums.get(i) > nums.get(i-1)){
                ++curr;
            }else{
                prev = curr;
                curr = 1;
            }
            ans = Math.max(ans, Math.min(prev, curr));
            ans = Math.max(ans, curr/2);
        }
        return ans;
    }
}