class Solution {
    public int[] separateDigits(int[] nums) {
        //String method
        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            String s = String.valueOf(num);
            for(char c: s.toCharArray()){
                res.add(c - '0');
            }
        }

        //final conversion to array
        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}