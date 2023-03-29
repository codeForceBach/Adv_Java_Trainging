package dataStructureAlgorithms.algorithmsEx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmsQuestions {

    public int romanToInt(String s){
          /* https://leetcode.com/problems/roman-to-integer/
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two one's added together.
        12 is written as XII, which is simply X + II.
        The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right.
        However, the numeral for four is not IIII.
        Instead, the number four is written as IV.
        Because the one is before the five we subtract it making four.
        The same principle applies to the number nine, which is written as IX.
        There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.

        Example 1:

        Input: s = "III"
        Output: 3
        Explanation: III = 3.
        Example 2:

        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.
        Example 3:

        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

        Constraints:
        1 <= s.length <= 15
        s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
        It is guaranteed that s is a valid roman numeral in the range [1, 3999].

        https://leetcode.com/problems/roman-to-integer/discuss/1840467/JAVA-oror-Easy-oror-Basic-oror-Simple
     */
        int totalValue = 0;
        //03-11-2022
        //MCMXCIV = 1000(M), 100(C), 1000(M), 10(X), C(100), I(1), V(5)
        //1000, 900(CM), 90(XC), 4(IV)
        char [] romanNumeric = s.toUpperCase().toCharArray();
        int [] romanConvert = new int [romanNumeric.length];
        for(int index = 0; index < romanNumeric.length ; index++) {
            Character c = romanNumeric[index];
            switch (c) {
                case 'M':
                    romanConvert[index] = 1000;
                    break;
                case 'D':
                    romanConvert[index] = 500;
                    break;
                case 'C':
                    romanConvert[index] = 100;
                    break;
                case 'L':
                    romanConvert[index] = 50;
                    break;
                case 'X':
                    romanConvert[index] = 10;
                    break;
                case 'V':
                    romanConvert[index] = 5;
                    break;
                case 'I':
                    romanConvert[index] = 1;
                    break;
            }
        }

        //ierate over romanConvert array to compare and sum up
        for (int i = 0; i < romanConvert.length; i++){
                int currentValue = romanConvert[i];
            //if it is not first index, compare with previous value and determind subtraction
            if(i > 0){
                if(romanConvert[i-1] < romanConvert[i]){
                    totalValue += romanConvert[i] - romanConvert[i-1]*2;
                } else {
                    totalValue += currentValue;
                }

            }else {
                totalValue += currentValue;
            }
        }

        return totalValue;
    }//end romanToInt method

    public String intToRoman(int num){
         /* https://leetcode.com/problems/integer-to-roman/

    ## I didn't fully understand the roman conversion logic thus not able to execute algorithm.
    ## need more practice with treeMap iteration
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given an integer, convert it to a roman numeral.

        Example 1:
        Input: num = 3
        Output: "III"
        Explanation: 3 is represented as 3 ones.

        Example 2:
        Input: num = 58
        Output: "LVIII"
        Explanation: L = 50, V = 5, III = 3.

        Example 3:
        Input: num = 1994
        Output: "MCMXCIV"
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

        Example 4:
        Input: num = 2957
        Output: "MMCMLVII"

        solution: using treemap with order -> https://leetcode.com/problems/integer-to-roman/discuss/1884349/Java-solution-using-TreeMap
        using hashMap with array -> https://leetcode.com/problems/integer-to-roman/discuss/1884842/Look-at-this-(java-simple-sol)
     */
        /*
        // create a treemap to add all int value as key and roman number as value pair( included 9 & 4 value conversion)
        Map<Integer, String> intToRoman = new TreeMap<>(Comparator.reverseOrder());
        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");

        //while iterating the treeMap, check input parameter divided by numeric value is not zero(since it would check the input is length of digit)
        //start with generic Map with entry call that defined key and value type, initiallize iterate map name, with semi colon, call entrySet() of the treeMap
        for(Map.Entry<Integer, String> entry : intToRoman.entrySet()){
            //if the current number is within length of numeric value, repeat same process in this while clause!!
            while(num / entry.getKey() != 0){
                //append the String to the output value
                romanNo += entry.getValue();
                //subtract the current value by length of the nemeric value to reduce one digit
                num -= entry.getKey();
            }
        }
         */
        String romanNo = "";
        // retry without any help!!
        return romanNo;
    }//end intToRoman

    public List filterList(final List<Object> list){
    /*
        List<Integer> filteredList = new ArrayList<>();

        for(Object obj : list){
            if (obj instanceof Integer) {
                if((Integer) obj >= 0){
                    filteredList.add((Integer)obj);
                }
            }
        }

        return filteredList;

    */
        //try stream with filter of lambda expression and collect in return statement
        return list.stream()
                .filter(c -> c instanceof Integer)//in order to use the lambda expression, it is required to defines type of List as above
                .collect(Collectors.toList());

    }//end filteredList

    public String hydrate(String drinkString){

        int shot = 0;
        char[] stlist = drinkString.trim().toCharArray();
        for(char ch : stlist){
            if(Character.isDigit(ch)){
                shot += Integer.parseInt(String.valueOf(ch));
            }
        }
        if(shot > 1){
            return shot+ " glasses of water";
        } else {
            return shot + " glass of water";
        }
    }//end hydrate

    public int absoluteDiagonalDiff(int[][] matrix){
            /* EXPD_codeHire_problem
    Given a square matrix of size NxN, calculate the absolute difference between the sums of its diagonals.

    Input Format
    The input is a two-dimensional array of length and width N. Each nested array represents a row of the matrix. For example:
        int[][] matrix = {
            {5, 4, -11},
            {2, -8, 9},
            {3, 14, 9}
        };

        // diagonal 1: 5 + -8 + 9 = 6, diagonal 2: 3 + -8 + -11 = -16
        // absolute difference: abs(-16 - 6) = 22

    Expected output: 22

        int[][] matrix = {
                {5, 4, -11, 17},
                {2, -8, 9, -1},
                {3, 14, 9, 13},
                {7, 14, -15, 16}
            };
          //matrix[i][j] = [0][2], [1][1], [2][0] ->
          //[0][3], [1][2], [2][1], [3][0] ->(length = 4) [0][lenght-1 = j], [i][length-2= j], [i][length-3]
    Output Format
    Print the absolute difference between the two sums of the matrix's diagonals as a single integer.
     */
        int diff = 0;
        int reverseDiff = 0;
        for(int i = 0; i < matrix.length; i++){
            int revCnt = matrix[i].length - (1 + i);
            for(int j = 0 ; j < matrix[i].length; j++){
                if (i == j){
                    diff += matrix[i][j];
                    //System.out.println("after add " + matrix[i][j] +" the new sum is " + diff);
                }

                if (revCnt == j) {
                    reverseDiff += matrix[i][j];
                    //System.out.println("after add " + matrix[i][j] + " the new sum of reverseDiff is " + reverseDiff);
                }//end if
            }//end inner for loop
        }//end outter for loop

        return Math.abs(diff - reverseDiff);
    }

    public int [] mergeSort(int [] a, int [] b, int [] c){
        /* EXPD_codeHire_problem
    You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge Array B into Array A in sorted order.

    # merge A into B in sorted order
    # A and B are both sorted
    # A will hold the contents of A and B after being sorted

    # A [1, 3] [6, 7], [2, 5]
    # B [2] [5]


    # A [1, 3, 6, x, 6, 7]
    #B [2, 5]
     */
        int [] merged = new int[0];

        return merged;
    }

    public int lengthOfLongestSubstring(String s) {
        /*https://leetcode.com/problems/longest-substring-without-repeating-characters/
        Given a string s, find the length of the longest substring without repeating characters.

        Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

        Example 3:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.

        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        https://www.code-recipe.com/post/longest-substring-without-repeating-characters

     */
        int result = 0, i = 0, j = 0;
        Map<Character, Integer> subS = new HashMap<>();
        /*
        //iterate through string,
        for(int i = 0; i <s.length(); i++){
            if (!subS.containsKey(s.charAt(i))){
                subS.put(s.charAt(i), i);
                result = Math.max(result, subS.size());
            } else{
                //subS.clear();
                //subS.remove(s.charAt(i));
                subS.put(s.charAt(i), i);
            }
        }

         */
        /*
        by utilizing while loop instead of for loop,
        there is flexability in how many times to increment j based on the duplicate charater
         */
        while (i < s.length()) {
            if (!subS.containsKey(s.charAt(i))) {
                subS.put(s.charAt(i), i++);
                //System.out.println("count i :" + i);
                result = Math.max(result, subS.size());
            } else {
                subS.remove(s.charAt(j++));
            }
        }

        return result;
        //try out with set instead.
    }

    //failed complete time comlexity test -  need to revise the code
    public int[] platesBetweenCandles(String s, int[][] queries) {
        /*https://leetcode.com/problems/plates-between-candles/
    2055. Plates Between Candles
    There is a long table with a line of plates and candles arranged on top of it. You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.

        You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles that are in the substring. A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.

        For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
        Return an integer array answer where answer[i] is the answer to the ith query.

        Example 1:
        ex-1
        Input: s = "**|**|***|", queries = [[2,5],[5,9]]
        Output: [2,3]

        Explanation:
        - queries[0] has two plates between candles.
        - queries[1] has three plates between candles

        Example 2:
        ex-2
        Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
        Output: [9,0,0,0,0]
        Explanation:
        - queries[0] has nine plates between candles.
        - The other queries have zero plates between candles.

        Constraints:

        3 <= s.length <= 105
        s consists of '*' and '|' characters.
        1 <= queries.length <= 105
        queries[i].length == 2
        0 <= lefti <= righti < s.length
     */
        int[] plateCnt = new int[queries.length];
        List<String> trimplate = new ArrayList<>();
        //iterate s number of time of queries.length, so that

        /*
        for(int i = 0; i < queries.length; i++){
            //within a loop, extract out substring of s between 2nd array of queries
            int begin = queries[i][0];
            int end = queries[i][1]+1;
            String plate = s.substring(begin, end);

            while(plate.startsWith("*")){
                begin++;
                plate = s.substring(begin, end);
            }
            while(plate.endsWith("*")){
                end--;
                plate = s.substring(begin, end);
            }

            System.out.println("substraing extracted within | : " + plate);
            trimplate.add(plate);
        }//end for
        */

        for(int i = 0; i < queries.length; i++) {
            //within a loop, extract out substring of s between 2nd array of queries
            int begin = queries[i][0];
            int end = queries[i][1] + 1;
            String plate = s.substring(begin, end);

            while(plate.endsWith("*")){
                end--;
                plate = s.substring(begin, end);
            }
            trimplate.add(plate);
        }

        System.out.println(trimplate);
        int i = 0;
        for(String plates: trimplate){
            int count = 0;
            boolean hitCandle = false;
            for(int j = 0; j < plates.length(); j++){
                if(plates.charAt(j) =='|'){
                    hitCandle = true;
                }
                if (hitCandle == true && plates.charAt(j) =='*'){
                    count++;
                }
            }
            plateCnt[i++] = count;
        }

        return plateCnt;
    }


}


