class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        //handling sign
        if((numerator < 0) ^ (denominator < 0))
            sb.append("-");

        //working with absolute values
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        sb.append(n/d);
        n %= d;
        //no fraction part
        if(n == 0) return sb.toString();

        //if you are here, it means there is fraction part
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(n!=0){
            if(map.containsKey(n)){
                int pos = map.get(n);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
            map.put(n, sb.length());
            n *= 10;
            sb.append(n/d);
            n %= d;
        }
        return sb.toString();
    }
}