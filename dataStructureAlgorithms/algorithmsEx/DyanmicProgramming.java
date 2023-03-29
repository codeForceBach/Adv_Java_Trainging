package dataStructureAlgorithms.algorithmsEx;

//memoization
public class DyanmicProgramming {

    public int ClimbStairs(int n){
        /*
        70. Climbing Stairs - https://leetcode.com/problems/climbing-stairs/
        https://leetcode.com/problems/climbing-stairs/discuss/2110782/java-solution-using-dynamic-programming
        basic pibonnaci bottom up memoization dynamic programming
            You are climbing a staircase. It takes n steps to reach the top.
            Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

            Example 1:
            Input: n = 2
            Output: 2
            Explanation: There are two ways to climb to the top.
            1. 1 step + 1 step
            2. 2 steps

            Example 2:
            Input: n = 3
            Output: 3
            Explanation: There are three ways to climb to the top.
            1. 1 step + 1 step + 1 step
            2. 1 step + 2 steps
            3. 2 steps + 1 step


        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i <= n ; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
        */
        return 0;
    }

    public int minCostClimbStairs(int [] cost){
        /*
        746. Min Cost Climbing Stairs - https://leetcode.com/problems/min-cost-climbing-stairs/
        You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
        Once you pay the cost, you can either climb one or two steps.
        You can either start from the step with index 0, or the step with index 1.
        Return the minimum cost to reach the top of the floor.

        Example 1:
            Input: cost = [10,15,20]
            Output: 15
            Explanation: You will start at index 1.
            - Pay 15 and climb two steps to reach the top.
            The total cost is 15.

        Example 2:
            Input: cost = [1,100,1,1,1,100,1,1,100,1]
            Output: 6
            Explanation: You will start at index 0.
            - Pay 1 and climb two steps to reach index 2.
            - Pay 1 and climb two steps to reach index 4.
            - Pay 1 and climb two steps to reach index 6.
            - Pay 1 and climb one step to reach index 7.
            - Pay 1 and climb two steps to reach index 9.
            - Pay 1 and climb one step to reach the top.
            The total cost is 6.

        Constraints:
            2 <= cost.length <= 1000
            0 <= cost[i] <= 999
         */
        /*
        start index 2 to compare previous two value and add up mininum value to current value
        iterate through all the array to update values.
        after iteration, return mininum value of two value

        https://www.youtube.com/watch?v=ktmzAZWkEZ0 - python solution
        https://www.youtube.com/watch?v=OoGswqFU-zs - java solution video
         */
        /*
        https://www.youtube.com/watch?v=OoGswqFU-zs
        for(int i = 2 ; i < cost.length; i++){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);

        OR
        int x = 0;
        int y = 0;

        for (int i = cost.length-1; i >= 0 ; i--){
            int curr_value = cost[i] + Math.min(x, y);
            x = y;
            y = curr_value;
        }
        return Math.min(x, y);
         */
        return 0;
    }

    public int rob(int [] nums) {
        /*
        198. House Robber - https://leetcode.com/problems/house-robber/
        https://www.youtube.com/watch?v=73r3KWiEvyk - Python solution
        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
        Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

        Example 1:
        Input: nums = [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.

        Example 2:
        Input: nums = [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        Total amount you can rob = 2 + 9 + 1 = 12.
         */
        /*
        https://www.youtube.com/watch?v=ZwDDLAeeBM0 - java video
        it is maximum value of previous two value??
         */
        if(nums == null){
            return 0;
        }

        if (nums.length  <= 1) {
            return nums[nums.length-1];
        }
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < nums.length; i++){
            int curr_max = Math.max(y, x + nums[i]);
            x = y;
            y = curr_max;

        }
        return y;
    }

}
