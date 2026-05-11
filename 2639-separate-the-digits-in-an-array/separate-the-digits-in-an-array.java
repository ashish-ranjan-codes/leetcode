class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int x: nums){
            List<Integer> digits = new ArrayList<>();
            while(x > 0){
                digits.add(x % 10);
                x /= 10;
            }
            Collections.reverse(digits);
            res.addAll(digits);
        }
        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}