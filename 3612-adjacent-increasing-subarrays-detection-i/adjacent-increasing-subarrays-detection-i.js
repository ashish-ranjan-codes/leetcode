/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var hasIncreasingSubarrays = function(nums, k) {
    const n = nums.length;
    let curr = 1, prev = 0, ans = 0;

    for(let i=1; i<n; i++){
        if(nums[i] > nums[i-1]){
            ++curr;
        }else{
            prev = curr;
            curr = 1;
        }
        ans = Math.max(ans, Math.min(prev, curr));
        ans = Math.max(ans, Math.floor(curr/2));
    }
    return ans >= k;
};