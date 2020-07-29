有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/burst-balloons
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int maxCoins(int[] nums) {
       int n=nums.length;
       int[] arr=new int[n+2];
       for(int i=0;i<n;i++){
           arr[i+1]=nums[i];
       }
       arr[0]=1;
       arr[n+1]=1;
       int[][] dp=new int[n+2][n+2];
       for(int i=n+1;i>=0;i--){
           for(int j=i+2;j<=n+1;j++){
               for(int k=i+1;k<j;k++){
                   dp[i][j]=Math.max(dp[i][j],
                            dp[i][k]+dp[k][j]+arr[i]*arr[j]*arr[k]);
               }
           }
       }
       return dp[0][n+1];
    }
}