class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int empties = numBottles;

        while(empties >= numExchange){
            empties -= numExchange;
            totalDrunk += 1;
            empties += 1;
            numExchange += 1;
        }
        return totalDrunk;
    }
}