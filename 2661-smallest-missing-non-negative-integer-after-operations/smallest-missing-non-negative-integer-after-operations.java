class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] arr = new int[value];
        for(int num : nums){
            int v = ((num % value) + value) % value;
            arr[v]++;
        }

        int mex = 0;
        while(arr[mex % value] > 0){
            arr[mex % value]--;
            mex++;
        }
        return mex;
    }
}