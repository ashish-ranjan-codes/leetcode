/**
 * @param {number[]} power
 * @return {number}
 */
var maximumTotalDamage = function(power) {
    const count = new Map();
    for(const damage of power){
        count.set(damage, (count.get(damage) || 0) + 1);
    }

    const uniqueDamages = Array.from(count.keys()).sort((a,b) => a-b);
    const n = uniqueDamages.length;

    const dp = Array.from({ length:n }, () => [0,0]);

    for(let i=0; i<n; i++){
        const damage = uniqueDamages[i];
        const totalDamage = damage * count.get(damage);

        if(i === 0){
            dp[0][0] = 0;
            dp[0][1] = totalDamage;
            continue;
        }
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        dp[i][1] = totalDamage;

        //corner cases
        if (i >= 1 && uniqueDamages[i - 1] !== damage - 1 && uniqueDamages[i - 1] !== damage - 2) {
            dp[i][1] += Math.max(dp[i - 1][0], dp[i - 1][1]);
        } else if (i >= 2 && uniqueDamages[i - 2] !== damage - 2) {
            dp[i][1] += Math.max(dp[i - 2][0], dp[i - 2][1]);
        } else if (i >= 3) {
            dp[i][1] += Math.max(dp[i - 3][0], dp[i - 3][1]);
        }
    }
    return Math.max(dp[n - 1][0], dp[n - 1][1]);
};