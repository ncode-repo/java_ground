package challenge;

import java.util.Arrays;

class MinCoinChallenge {
    public static int coinChange(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1; i < amount + 1; i++)
        {
            for(int coin : coins)
            {
                if(i - coin >= 0)
                {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }

        }
        return dp[amount]> amount  ?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        int minCoins=coinChange(coins,11);
        System.out.printf("Min coins required="+minCoins);
    }
}