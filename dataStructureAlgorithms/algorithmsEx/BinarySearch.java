package dataStructureAlgorithms.algorithmsEx;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

    }

    public int searchRotatedSortArray(int [] nums, int target){

        /*
        33. Search in Rotated Sorted Array - https://www.youtube.com/watch?v=U8XENwh8Oy8
        here is an integer array nums sorted in ascending order (with distinct values).

        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
        such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        Given the array nums after the possible rotation and an integer target,
        return the index of target if it is in nums, or -1 if it is not in nums.

        Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4

        Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1

        Example 3:
        Input: nums = [1], target = 0
        Output: -1

        You must write an algorithm with O(log n) runtime complexity. - > b
         */
        //find middle index in the array
        int left = 0;
        int right = nums.length - 1; //7


        while (left <= right) {
            int mid = (right + left) / 2; //3
            //check if the middle value is equals to target value and return
            if (nums[mid] == target) {
                return mid;
            }

            //check if the array is sorted
            if (nums[left] <= nums[mid]) {
                //check target is within the left portion
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //check right sorted portion
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }//if else
        }//end while
        return -1;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
    	/*
    	 * 74. Search a 2D Matrix - https://leetcode.com/problems/search-a-2d-matrix/
    	 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
			Integers in each row are sorted from left to right.
			The first integer of each row is greater than the last integer of the previous row.
			
			Example 1:
			Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
			Output: true
			
			Example 2:
			Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
			Output: false
			
				m == matrix.length
				n == matrix[i].length
				1 <= m, n <= 100
				-104 <= matrix[i][j], target <= 104
			https://leetcode.com/problems/search-a-2d-matrix/discuss/2307684/Not-concise-but-easy-to-understand-Double-Binary-search
    	 */
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        //serach for the rows whether the target value is greater than lower row or upper row.
        int topR = 0;
        int botR = row;
        int midR = 0;
        while(topR <= botR) {
            midR = (topR + botR) / 2;
            //if target value is greater than last value in the midR,
            // the value is more likely the bottom half from the midR -  so move the top next to midR

            if (target > matrix[midR][col]) {
                topR = midR + 1;
            //if the target value is less than first value in the midR
            //the value is more likely in the top half of the matrix - so move the bottom to the less than midR
            } else if (target < matrix[midR][0]){
                botR = midR - 1;
            //if the target is not either of above condition, it mean the target value is within the row - so braek out of the while loop
            } else {
                break;
            }
        }

        if(topR > botR) {
            return false;
        }

        //search the values( in column) for that midR row if midR where the target value is includes .
        int left = 0;
        int right = col;
        int midC = 0;
        while(left <= right){
            midC = left - (right + left) / 2;
            if(target > matrix[midR][midC]){
                left = midC+ 1;
            }else if (target < matrix[midR][midC]){
                right = midC -1;
            }
            else if (target == matrix[midR][midC]){
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixCondense(int[][] matrix, int target){
        //https://leetcode.com/problems/search-a-2d-matrix/discuss/2276990/JavaSolution-or-Beats-100-of-rest-or-Uses-simple-binary-search

        int row =matrix.length;
        int col=matrix[0].length;
        int low=0;
        int high= (row*col) -1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (matrix[mid/col][mid%col]==target){
                return true;
            }
            else if (matrix[mid/col][mid%col]<target){
                low=mid+1;
            }
            else if (matrix[mid/col][mid%col]>target){
                high=mid-1;
            }
        }
        return false;
    }

    public int minEatingSpeed(int [] piles, int h){
        /*
        875. Koko Eating Bananas - https://leetcode.com/problems/koko-eating-bananas/
        https://www.youtube.com/watch?v=U2SozAs9RzA - neet code
        Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
        If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
        Return the minimum integer k such that she can eat all the bananas within h hours.

        Example 1:
        Input: piles = [3,6,7,11], h = 8
        Output: 4

        Example 2:
        Input: piles = [30,11,23,4,20], h = 5
        Output: 30

        Example 3:
        Input: piles = [30,11,23,4,20], h = 6
        Output: 23

        Constraints:
        1 <= piles.length <= 104
        piles.length <= h <= 109
        1 <= piles[i] <= 109
         */

        //1. find a max value in the array - https://www.geeksforgeeks.org/java-program-for-program-to-find-largest-element-in-an-array/
        int max = Arrays.stream(piles).max().getAsInt();
        //Arrays.sort(piles);
        //int max2 = piles[piles.length -1];
        //2. binary search to find rate
        int left = 1;
        int right = max;

        int result = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int hour = 0;
            for(int p : piles){
                hour += Math.ceil((double)p/mid);
                //https://www.programiz.com/java-programming/library/math/ceil
            }
            if(hour <= h){
                result = Math.min(hour, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return result;
    }

    public int minRotatedSortedArray(int[] nums){
        /*
        153. Find Minimum in Rotated Sorted Array
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
        https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/2372262/Java-Solution-Using-Binary-Search-oror-100-faster
        Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
        For example, the array nums = [0,1,2,4,5,6,7] might become:

        [4,5,6,7,0,1,2] if it was rotated 4 times.
        [0,1,2,4,5,6,7] if it was rotated 7 times.
        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
        Given the sorted rotated array nums of unique elements, return the minimum element of this array.
        You must write an algorithm that runs in O(log n) time.

        Example 1:
        Input: nums = [3,4,5,1,2]
        Output: 1
        Explanation: The original array was [1,2,3,4,5] rotated 3 times.

        Example 2:
        Input: nums = [4,5,6,7,0,1,2]
        Output: 0
        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

        Example 3:
        Input: nums = [11,13,15,17]
        Output: 11
        Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
         */
        int min = nums[0];
        int left = 0;
        int right = nums.length-1;

            //if the section of array is sorted then pick left most value as minimum
            if(nums[left] <= nums[right]){
                return min;
            }

        while(left <= right){
            int mid = left + (right - left) / 2;
            //min = Math.min(nums[mid], nums[left]);
            //if the value after the mid is smaller that mid, the value after mid is where the rotation occured
            //thus that is the smallest value in the sorted array
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            else if(nums[left] <= nums[mid]){
                left = mid + 1;
                //min = Math.min(min, nums[left]);
            } else {
                right = mid -1;

            }

        }
        return -1;

    }

}
