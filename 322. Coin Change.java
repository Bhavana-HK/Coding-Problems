// https://leetcode.com/problems/coin-change/

import java.util.*;

class CoinChange {
  // solve using DP
  // find the minNumber of coins required for amount = 0, amount=1, amount=2, ....
  // amount=amount -> tracked as "i"
  // for each amount, run the loop for each coin. update minNumber of coins with
  // the min value of whats already calulated
  // andddd
  // 1 (cause we are using that coin) + minimum of of coins required to make up
  // the (amount - coin) value (rest of the value) the for loop tests for each
  // coin, so we can be sure that the minimum or the best result of including that
  // coin or not is taken
  // to cut short the loop, we can sort the coins and then stop scanning when the
  // coin value > amount needed
  // to initialize the dp array, we can use amount+1 cause even if the coin has
  // value of 1, it wont take us more than amount no of coins
  // and finally, check if the dp[amount] is > amount(no sol'n found) else return
  // dp[amount]

  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount == 0)
      return 0;
    // dp stores the minimum no of coins required to make up 'index' amount
    int[] dp = new int[amount + 1];

    Arrays.sort(coins);
    Arrays.fill(dp, amount + 1);

    // i is the amount that we need to calulate for
    // DONT forget to initialize the initial no of coins for amount = 0 => 0!
    dp[0] = 0;
    for (int i = 0; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {

        if (i >= coins[j]) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
          // i-coins[j] is remaing amount to be made up and dp[i-coins[j]] gives us that
        } else {
          break;
          // since the array is sorted, coins[j] is only getting bigger and amount 'i' is
          // already less. so break the loop
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];

  }

  public static void main(String[] args) {
    CoinChange c = new CoinChange();
    System.out.println(c.coinChange(new int[] { 186, 419, 83, 408 }, 6249)); // 20
  }
}