// https://leetcode.com/problems/climbing-stairs/

class ClimbingStairs {
  public int climbStairs(int n) {
    // bottom-up DP solution
    // base case: when there are 0 stairs: only 1 way, 1 stairs: only 1 way
    // for rest of the stairs: you can climb from the stair below it or 2 the stairs below it
    // therefore, no of ways will be no of ways you climbedd the star below it and 2 stairs below it
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    
    for(int i=2; i<=n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];

  }

  public static void main(String[] args) {
    ClimbingStairs stairs = new ClimbingStairs();
    System.out.println(stairs.climbStairs(35)); // 14930352
  }
}