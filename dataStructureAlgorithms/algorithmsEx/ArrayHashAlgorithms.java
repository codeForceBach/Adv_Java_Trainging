package dataStructureAlgorithms.algorithmsEx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class ArrayHashAlgorithms {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate( int [] nums){
        /*
          217. Contains Duplicate - https://leetcode.com/problems/contains-duplicate/
        */
        /*
        iterate through the Arrays to store in the set,
        if the element is duplicate set return true otherwise keep add to the set
        solved with my own but a bit clrumsy code
         */
        return false;
    }

    public boolean containsNearByDuplicateSlide(int [] nums, int k){

        /*
        219. Contains Duplicate II - https://leetcode.com/problems/contains-duplicate-ii/
        Given an integer array nums and an integer k,
        return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
        **the index of the two element need to be less or equals to K  after the subtraction (absolute value)
         //https://leetcode.com/problems/contains-duplicate-ii/discuss/2727210/Java-oror-Explained-in-Detailoror-Simple-and-Fast-Solutionoror-HashMap-oror-Sliding-Window
         */

        if(k==0) return false;

        Set <Integer> slideSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            //Since the Set only contain number of elements that are equal or less then K
            //if there are duplicate, simply return true.
            if(slideSet.contains(nums[i])){
                return true;
            }
            //If element nums[i] is not in the Set, but index of the element is equal or greater than K( as long as the size of the set is greater than k), remove the element stored in set
            if(i >= k){
                slideSet.remove(nums[i-k]);
            }
            slideSet.add(nums[i]);
        }
        return false;
    }

    public boolean containNearByDuplicateMap(int [] nums, int k){
        /*
        219. Contains Duplicate II - https://leetcode.com/problems/contains-duplicate-ii/
        Given an integer array nums and an integer k,
        return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
        **the index of the two element need to be less or equals to K  after the subtraction (absolute value)
         https://leetcode.com/problems/contains-duplicate-ii/discuss/2727210/Java-oror-Explained-in-Detailoror-Simple-and-Fast-Solutionoror-HashMap-oror-Sliding-Window
       */

        //if K is 0, i and k can not be distinct so return false
        if(k == 0)
            return false;
        //inintialize hashMap to keep track of value of an element as key and index as value
        HashMap <Integer, Integer> indexMap = new HashMap();

        //iterate over array for each element with index
        for(int i = 0; i < nums.length; i++){
            int mapKey = nums[i];

            //if the hashMap contains the element in array and if the absolute value of two index is less than or equals to k return true
             if(indexMap.containsKey(mapKey) && (i - indexMap.get(mapKey) <= k)){
                 return true;
             }
            //otherwise, put the value of current array as key, or update current index of the array as new value n the hashMap
            //** since map doesn't allow duplicate key, if the key is already exist in the map, it would just update the value.
            indexMap.put(mapKey, i);
        }
        //if there is no duplicate element within k distance, return false
        return false;
    }

    public boolean arrayStringsAreEquals(String[] word1, String[] word2){
    /*
    1662. Check If Two String Arrays are Equivalent -
    https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
    A string is represented by an array if the array elements concatenated in order to forms the string.

    solved 06/01/2022 ---------------------------------------------------------
    1. StringBuilder to concatenate all the string in the array to String builder and compare 2 new strings from StingBuilder
    2. Simply append String array to new String then compare 2 String.
    3. use String.join([delemiter], {List of String}) then compare two String
    ** return compare directly
     */
        return false;
    }

    public int removeDuplicates (int[] nums){
        /*
    https://leetcode.com/problems/remove-duplicates-from-sorted-array
     */
        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[pointer]){
                pointer++;
                nums[pointer] = nums[i];
            }
        }
        return pointer + 1;
    }

    public int removeTripletandBeyond(int [] nums){
         /*
        https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
         */
        int pointer = 2;
        int bridge = 2 ;
        while (bridge < nums.length){
            if(nums[bridge] == nums[pointer - 2]){
                bridge++;
            } else {
                nums[pointer++] = nums[bridge++];
            }
        }
        return pointer;
    }

    public List<List<Integer>> generatePascalTrialgle(int numRows){
        /*
        118. Pascal's Triangle - https://leetcode.com/problems/pascals-triangle/
        Given an integer numRows, return the first numRows of Pascal's triangle.
        In Pascal's triangle, each number is the sum of the two numbers directly above it

        Example 1:
        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

        Example 2:
        Input: numRows = 1
        Output: [[1]]
         */

        List<List<Integer>> triangleP = new ArrayList<>();
        if(numRows == 0){
            return triangleP;
        }
        //initialize first sub List and add to outter array as first element
        List<Integer> rows = new ArrayList<>();
        rows.add(1);
        triangleP.add(rows);

        //if numRows > 1, iterate number of time as long as the iteration is less than numRows
        for(int i = 1; i < numRows; i++){
            //initialize new ArrayList
            List<Integer> temp = new ArrayList<>();
            //get the previous Rows
            List<Integer> prev = triangleP.get(i-1);
            //add first and last element
            temp.add(1);
            //if numRows > 2, iterate over the sub array to add element
            for(int j = 1; j < prev.size(); j++){
                //add an element with value of previous row's current j and j-1
                temp.add(prev.get(j-1) + prev.get(j));
            }
            temp.add(1);
            triangleP.add(temp);
        }

        return triangleP;

    }//end pascalTriangle
    
    public List<Integer> PascalTriangleRow(int rowIndex){
    	/*
    	 * https://leetcode.com/problems/pascals-triangle-ii/discuss/2232939/Java-or-In-depth-Explanation-or-Easy-to-Implement
    	 */
    	 List<List<Integer>> triangleP = new ArrayList<>();
         
         //initialize first sub List and add to outter array as first element
         List<Integer> rows = new ArrayList<>();
         rows.add(1);
         triangleP.add(rows);

         //if numRows > 1, iterate number of time as long as the iteration is less than numRows
         //as to accomodate rowIndex = 0 use "i <= rowIndex"
         for(int i = 1; i <= rowIndex; i++){
             //initialize new ArrayList
             List<Integer> temp = new ArrayList<>();
             //get the previous Rows
             List<Integer> prev = triangleP.get(i-1);
             //add first and last element
             temp.add(1);
             //if numRows > 2, iterate over the sub array to add element
             for(int j = 1; j < prev.size(); j++){
                 //add an element with value of previous row's current j and j-1
                 temp.add(prev.get(j-1) + prev.get(j));
             }
             temp.add(1);
             triangleP.add(temp);
         }
         
         return triangleP.get(rowIndex);
    	
    }
    
    public List<Integer> pascalTriangleRowII(int rowIndex){
        //description
        /*
         * 119. Pascal's Triangle II - https://leetcode.com/problems/pascals-triangle-ii/
         * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

            In Pascal's triangle, each number is the sum of the two numbers directly above it
            * Could you optimize your algorithm to use only O(rowIndex) extra space?
            * Constraints:  0 <= rowIndex <= 33

            Example 1:
            Input: rowIndex = 3
            Output: [1,3,3,1]

            Example 2:
            Input: rowIndex = 0
            Output: [1]

            Example 3:
            Input: rowIndex = 1
            Output: [1,1]
         */

        /* https://leetcode.com/problems/pascals-triangle-ii/discuss/2256149/Java-or-easy-to-understand-or-combination
             public List<Integer> getRow(int rowIndex) {
                  //ncr=n!/(n-r)!*r!
                  //nc(r+1)=n!/(n-r-1)!*(r+1)!
                  //nc(r+1)=n!*(n-r)/(n-r)*(n-r-1)!*(r+1)*r!
                  //nc(r+1)=n!*(n-r)/(n-r)!*r!*(r+1)
                  //nc(r+1)=ncr*(n-r)/(r+1)
                    List<Integer> ans=new ArrayList<>();
                    for(Integer r=0;r<=rowIndex;r++){
                        List<Integer> list=new ArrayList<>();
                        Integer v=1;
                        for(Integer c=0;c<=r;c++){
                            list.add(v);
                            v=(int)((long)v*(r-c)/(c+1));
                        }
                        ans=list;
                    }
                    return ans;
                }
         */

        /*
        https://www.youtube.com/watch?v=iVhmR1bzKoo&t=275s
        most optimal solution so far I have seen, utilize ArrayList API
        Should study and have better understanding give efficiency and optimization
        the method add(index, value) add value to specific index of the list and push existing value to right
        i = 0 -> 1
        i = 1 -> 1, 1
        then start at size <= 2, iterate through list start with index 1 to set value as sum of itself plus next value
         i = 2 -> 1, 1, 1   ->   1, (1 + 1), 1
         i = 3 -> 1, 1, 2, 1    ->   1, (1 + 2), (2 + 1), 1
         i = 4 -> 1, 1, 3, 3, 1     ->   1, (1 + 3), (3 + 3), (3 + 1) , 1
         i = 5 -> 1, 1, 4, 6, 4, 1  ->   1, (1 + 4), (4 + 6), (6 + 4) , (4 + 1), 1
         */
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i<=rowIndex; i++){
            result.add(0, 1);
            for(int j = 1; j < result.size()-1; j++){
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }
        return result;
    }

    public int rotatedSortArraySearch(int [] nums, int target){
        /*
        33. Search in Rotated Sorted Array
        https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/2259130/JAVA-Solution-or-Effiecient-or-Explanatory-or-Binary-Search-Easy-Solution
        There is an integer array nums sorted in ascending order (with distinct values).

        Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
        such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
        For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

        You must write an algorithm with O(log n) runtime complexity.

            Example 1:
            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4

            Example 2:
            Input: nums = [4,5,6,7,0,1,2], target = 3
            Output: -1

            Example 3:
            Input: nums = [1], target = 0
            Output: -1
        https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/2259130/JAVA-Solution-or-Effiecient-or-Explanatory-or-Binary-Search-Easy-Solution
         */
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
                while (left <= right){
                    mid = left + (right - left) / 2;
                    if(nums[mid] == target){
                        return mid;
                    }
                    //if left value is smaller that middle value,-> all values are ascending order
                    if(nums[left] <= nums[mid]) {
                        //if the target is out of range in left side of the array
                        //target is smaller that left( which should be smallest),
                        //or target is bigger than mid(which should be largest half)
                        if (target > nums[mid] || target < nums[left]) {
                            //since the target is not there, move the left side to next to middle of the total array

                            left = mid + 1;
                        } else {
                            //if target is within the left side of the middle,
                            //move the right to before mid
                            right = mid - 1;
                        }
                    }
                    //which mean this left half portion is not sorted so then go check out right half of the array
                    else{
                        //if target is smaller that mid(which is left most value in the half of the array,
                        //or target is bigger than right

                        if(target < nums[mid] || target > nums[right]){
                            //since target id out of range in the array then go to left half of the array
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }

                }
                return -1;
    }

    public int[] topKFrequent(int[] nums, int k){
        /*
        347. Top K Frequent Elements
        https://www.youtube.com/watch?v=YPTqKIgVk-k
        Bucket Sort, Max heap
        Given an integer array nums and an integer k, return the k most frequent elements.
        You may return the answer in any order.
        https://leetcode.com/problems/top-k-frequent-elements/discuss/2070546/Java-O(N)-Time-O(N)-Space-Simple-Solution-With-Comments

            Example 1:
            Input: nums = [1,1,1,2,2,3], k = 2
            Output: [1,2]

            Example 2:
            Input: nums = [1], k = 1
            Output: [1]
         */

        //create a map for the nums in the incoming array and frequency
        Map<Integer, Integer> map = new HashMap<>();

        //add nums to map increment as key repeat
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //create an arraylist with Integer array as elements - this would reverse the key and value in the map
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        //iterate through the map to put the value as key and key as value in the arrayList
        for (Integer i : map.keySet()){
            int key = i;
            int value = map.get(i);
            if(bucket[value] == null){
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        //creats an array of length K to store most frequent Integer in the bucket
        int result[] = new int[k];
        int counter = 0;
        int temp = k;

        //check the bucket array with the total length of nums array
        //if each decrement of the length if bucket matches key vlaue of the arraylist add them to new result array until the count matches K
        for(int i= nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Integer j : bucket[i]) {
                    if (temp == 0) {
                        break;
                    }
                    result[counter] = (int) j;
                    counter++;
                    temp--;
                }
            }
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        /*
    242. Valid Anagram - https://leetcode.com/problems/valid-anagram/
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
    typically using all the original letters exactly once.

    solved 05/3/12022 --------------------------
     convert both string s & t as arrays and compare two sorted array since all the value should be same order and length
     which compare method would you use?
     aArray == tArray
     aArray.equals(tArray)
     Arrays.equals(aArray, tArray);

     https://leetcode.com/problems/valid-anagram/discuss/2795241/Stupid-easy-5-liner.-No-thinking-required.-Beat-85-runtime.
     */
        return false;
    }

    public List<Integer> findAnagrams(String s, String p){
        /*
        438. Find All Anagrams in a String - M
        https://leetcode.com/problems/find-all-anagrams-in-a-string/
        Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

        Input: s = "cbaebabacd", p = "abc"
        Output: [0,6]
        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".


        Input: s = "abab", p = "ab"
        Output: [0,1,2]
        Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".
         */
        int endIndex = p.length();
        //sort String p as an array
        char [] pArray = p.toCharArray();
        List<Integer> anagram = new ArrayList<>();
        // iterate over subString of String s length of P
        for(int i = 0 ; i <= s.length()-endIndex; i++){

            char[] subSetS = s.substring(i, i + endIndex).toCharArray();
            Arrays.sort(subSetS);
            if(Arrays.equals(subSetS, pArray)){
                anagram.add(i);
            }
        }
        //sort the substring and compare with sorted p
        //if the subset of string is anagram, add index to the list
        return anagram;
    }

    public boolean isValidSudoku(char [][] board){
        /*
        https://www.youtube.com/watch?v=TjFXEUCMqI8
        https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
        Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

        Note: A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.

        Input: board =
            [["5","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]
            Output: true

         Input: board =
            [["8","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]
            Output: false

            Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
            Since there are two 8's in the top left 3x3 sub-box, it is invalid.
         */
        /*
        https://leetcode.com/problems/valid-sudoku/discuss/2397764/Java-simple-solution-or-HashSet
         */
        //HashSet return true if element is not present in HashSet else return false
        Set seen = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    char curr = board[i][j];
                    if(!(seen.add(curr + " found in row " + i))
                    || !(seen.add(curr + " found in column " + j))
                    || !(seen.add(curr + " found in sub box " + i/3 + "-" + j/3))){
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public int longestConsecutive(int [] nums){
        /*
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        You must write an algorithm that runs in O(n) time.

        Example 1:
            Input: nums = [100,4,200,1,3,2]
            Output: 4
            Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

         Example 2:
            Input: nums = [0,3,7,2,5,8,4,6,0,1]
            Output: 9
         */


        //https://leetcode.com/problems/longest-consecutive-sequence/discuss/2439862/Java-or-16-ms-faster-than-96.72-or-O(n-log-(n))
        Arrays.sort(nums);

        if(nums.length == 0){
            return 0;
        }

        int count = 1;
        int max = 1;
        //check each item if the value is equals to increment of previous value

            for (int i = 1; i < nums.length; i++) {
                if(nums[i] == nums[i-1]){
                    continue;
                }
                if(nums[i] == nums[i-1] + 1){
                    count++;//as long as it is consecutive number from previous value, increment count
                }else {
                    count = 1;//reset count for next sequence
                }
                max = Math.max(max, count);
            }
            return max;
    }

    public int longestConsecutiveSet(int[] nums){
        /*utilize jave Collections Framework to convert array to set.
        https://leetcode.com/problems/longest-consecutive-sequence/discuss/2421923/Easy-Java-ApproachororTC-greaterO(n)ororSC-greaterO(n)
        https://www.geeksforgeeks.org/convert-array-to-hashset-in-java/
        only works for String not Integer
        Set<String> sequence = Arrays.stream(nums).collect(Collectors.toSet());
         */
        //https://stackoverflow.com/questions/12030661/java-int-array-to-hashsetinteger
        //Set<Integer> setNum = new HashSet(Arrays.asList(nums));
        //-> it converts array as single element
        //because primitive to wrapper coercion (ie. int[] to Integer[]) is not built into the language (not sure why they didn't do this, but they didn't
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        //or first convert int[] to Integer[]
        Integer[] numsInt = IntStream.of(nums).boxed().toArray(Integer[]::new);
        //then convert
        Set<Integer> setNum = new HashSet(Arrays.asList(numsInt));
        //or
        Set<Integer> sequenceNum = Arrays.stream(numsInt).collect(Collectors.toSet());


        /*Set<Integer> setNum = new HashSet<>();
        for(int no : nums){
            setNum.add(no);
        }

         */

        int max = 0;
        for(int no : nums){
            //if this is the beginning of the new sequence...
            if(!setNum.contains(no-1)){
                int newNo = no;
                int count = 1;
                //as long as the next num is found in set, increment value and count of sequence

                while(setNum.contains(newNo + 1)){
                    newNo++;
                    count++;

                }
                max = Math.max(max, count);
            }
        }
        return max;

    }

    public int longestConsecutiveMap(int [] nums){
        /*
        https://leetcode.com/problems/longest-consecutive-sequence/discuss/2426361/Simple-Java-Solution
         */
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int max = 0;

        for(int num : nums){
            if(!numMap.containsKey(num)){
                int left = numMap.getOrDefault(num -1, 0);
                int right = numMap.getOrDefault(num + 1, 0);
                int sum = left + right + 1;
                max = Math.max(max, sum);
                numMap.put(num, sum);
                numMap.put(num-left, sum);
                numMap.put(num+right, sum);
            } else {
                 continue;
            }
        }
        return max;
    }

    public int[] productExceptSelf(int [] nums){
        /*
        238. Product of Array Except Self - https://leetcode.com/problems/product-of-array-except-self/
        https://www.youtube.com/watch?v=bNvIQI2wAjk
        https://leetcode.com/problems/product-of-array-except-self/discuss/2456498/A-VERY-SIMPLE-JAVA-APPROACH-TCO(N)
            Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
            The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
            You must write an algorithm that runs in O(n) time and without using the division operation.
         */
        int[] answer = new int[nums.length];

        int pref = 1;
        for(int i = 0; i < nums.length ; i++){
            answer[i] = pref;
            pref *= nums[i];
        }

        int postf = 1;
        for(int i = nums.length -1; i >= 0; i--){
            answer[i] *= postf;
            postf *= nums[i];
        }
        return answer;
    }

    public String encodeString(List<String> str){
        String combine = "";
        for(String s : str){
            combine += s.length() + "*" + s;
        }
        return combine;
    }

    public List<String> decodeString(String str){
        List<String> split = new ArrayList<>();
        int start = 0;
        int num = 0;
        while(start < str.length()){

            while(str.substring(start) !="*"){
                num = parseInt(str.substring(start));
                start++;
            }
            int wordLength = parseInt(str.substring(start+ 1, num));

            split.add(str.substring(start+=1, wordLength));
            start = wordLength;
        }

        return split;

    }

}
