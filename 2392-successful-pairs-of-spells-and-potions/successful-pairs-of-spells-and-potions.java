class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++){
            int spell = spells[i];
            int left = 0;
            int right = m;

            while(left < right){
                int mid = (left + right)/2;
                if((long) spell * potions[mid] >= success){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            result[i] = m - left;
        }
        return result;
    }
}