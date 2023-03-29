package dataStructureAlgorithms.algorithmsEx;

import org.junit.jupiter.api.function.Executable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringArgorithms {

    /*
    https://www.linkedin.com/learning/java-algorithms/validate-strings-in-java-all-or-nothing-properties?autoAdvance=true&autoSkip=false&autoplay=true&resume=true&u=26281682
     */
    public static boolean isUpppercase(String s) {
        /*
    isUppercase
     */
        return s.chars().allMatch(Character::isUpperCase);
    }

    public static boolean isPasswordComplex(String s) {
        /*
    validate specific properties of a string.
    one number, upppercase, special character
     */
        Pattern p = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher m = p.matcher(s);

        return s.chars().anyMatch(Character::isDigit)
                && s.chars().anyMatch(Character::isUpperCase)
                && m.find()
                && s.length() > 8;
    }//End isPasswordComplex method

    public static String StringNormalize(String s) {
        /*
    Before processing a String, normalize the string to a common form can be helpful
    Search for a letter to uppercase or lowercase prior search or limit the input to only certain type.
    build algorithem to be flexable enough to handle different contents
     */
        return s.toLowerCase().trim().replace(",", "");
    }

    public static boolean isIntPalindrome(int x) {
        //https://stackoverflow.com/questions/3806126/java-reverse-an-int-value-without-using-array
    /*
        Java reverse an int value - Principles
        Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
        Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (5 * 10) = 50
        Dividing an integer by 10 will remove the rightmost digit. (75 / 10) = 7

        Java reverse an int value - Pseudocode:
        a. Extract off the rightmost digit of your input number. (1234 % 10) = 4
        b. Take that digit (4) and add it into a new reversedNum.
        c. Multiply reversedNum by 10 (4 * 10) = 40, this exposes a zero to the right of your (4).
        d. Divide the input by 10, (removing the rightmost digit). (1234 / 10) = 123
        e. Repeat at step a with 123
     */
        Boolean palindrome = false;
        int reverseNum = 0;
        int input = x;
        while (input != 0) {
            reverseNum = reverseNum * 10 + input % 10;
            input = input / 10;
        }

        //for int negative value never be a pelindrome. though if the input parameter type is String different approchi is needed.
        if (reverseNum == x && 0 <= x) {
            palindrome = true;
        }

        return palindrome;
    }

    public static Executable stringBuilderComparable() {

        Set<String> colors = new TreeSet<>();

        colors.add(new String("RED"));
        colors.add(new String("BLUE"));
        colors.add(new String("PURPLE"));
        colors.add(new String("GREEN"));

        Set<StringBuilder> colorCode = new TreeSet<>();

        try {
            colorCode.add(new StringBuilder("#008200"));
            colorCode.add(new StringBuilder("#ff0000"));
            colorCode.add(new StringBuilder("#006400"));

        } catch (ClassCastException exception) {
            System.out.println(exception.getMessage());

        }
        //return null;
        return null;
    }

    public List<List<String>> groupAnagramsMy(String[] strs) {
        // --------------- my solution ---------------------------------------
        //initialize List of list<String> to hold each set of anagram list
        List<List<String>> groupAnagram = new ArrayList<>();
        //initialize Hashmap to store set of anagram based on the sorted String key
        Map<String, List<String>> uniqueAna = new HashMap<>();

        //iterate over the input parameter
        for (String s : strs) {
            //convert each string to charArray
            char[] charkey = s.toCharArray();
            //sort the String in the order
            Arrays.sort(charkey);
            //initialize and store sorted String as key
            String mapKey = new String(charkey);
            //also initialize List<String> for Map value
            List<String> stList;
            //if the sorted String key is already in the map key
            if (uniqueAna.containsKey(mapKey)) {
                //get the List<String> from the map and add current String to the list
                stList = uniqueAna.get(mapKey);
                stList.add(s);
            } else {
                stList = new ArrayList<String>();
                stList.add(s);
            }
            uniqueAna.put(mapKey, stList);
        }
        //once iterating through the map, transfer all the List<string> from the map to List
        for (Map.Entry<String, List<String>> entryMap : uniqueAna.entrySet()) {
            groupAnagram.add(entryMap.getValue());
        }
        return groupAnagram;
    }

    public List<List<String>> groupAnagramsCharArray(String[] strs) {

        Map<String, List<String>> groupAnagram = new HashMap();

        for (String s : strs) {

            char[] sortS = s.toCharArray();
            Arrays.sort(sortS);
            String sortKey = new String(sortS);
            //by check false, adding new List to the map
            if (!groupAnagram.containsKey(sortKey)) {
                groupAnagram.put(sortKey, new ArrayList<>());
            }
            //after the condition to insure new arraylist or get already existing arraylist to add this string to map s value
            groupAnagram.get(sortKey).add(s);
        }
        //use inherited interface Map method values() to extract all the values in the map
        return new ArrayList(groupAnagram.values());

    }

    public List<List<String>> groupAnagramsMapDefault(String[] strs) {
        /*
        https://leetcode.com/problems/group-anagrams/discuss/2097342/JAVA-or-O(n*-m-log-m)-time
        utilize Map interface method
         */
        Map<String, List<String>> groupAnagram3 = new HashMap();
        for (String s : strs) {

            char[] sortS = s.toCharArray();
            Arrays.sort(sortS);
            String sortKey = new String(sortS);

            /*getOrDefault(Object key, V defaultValue) in the hashMap returns value associated with the key.
             if the value is not mapped with key, it returns default value (given parameter).
             https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/
             */
            List<String> anaGroup = groupAnagram3.getOrDefault(sortKey, new ArrayList<>());
            anaGroup.add(s);
            groupAnagram3.put(sortKey, anaGroup);
        }
        //use inherited interface Map method values() to extract all the values in the map
        return new ArrayList(groupAnagram3.values());
    }

    public List<List<String>> groupAnagramsHash(String[] strs) {
        /*
        simplified:
        https://leetcode.com/problems/group-anagrams/discuss/2093154/Java-solution-O(MN)-using-simple-string-hash-that-ignores-char-order
        iterate String[] strs to store to the map directly instead of initialize the List
         */

        Map<Long, List<String>> groupAnagram2 = new HashMap();

        for (String s : strs) {

            long hash = 0;
            for(char c : s.toCharArray()){
                hash += c*c; //c*c: integer multiplication implicitly cast to long
            }

            if (!groupAnagram2.containsKey(hash)) {
                groupAnagram2.put(hash, new ArrayList<>());
            }
            groupAnagram2.get(hash).add(s);
            //----------------------------------------------------------------------
        }
        //use inherited interface Map method values() to extract all the values in the map
        return new ArrayList(groupAnagram2.values());

    }

    public String isStringPalindrome(String s){
        /*
        https://leetcode.com/problems/valid-palindrome/
        125. Valid Palindrome
        A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
        it reads the same forward and backward.
        Alphanumeric characters include letters and numbers.
        */
        /*
            Example 1:
                Input: s = "A man, a plan, a canal: Panama"
                Output: true
                Explanation: "amanaplanacanalpanama" is a palindrome.

            Example 2:
                Input: s = "race a car"
                Output: false
                Explanation: "raceacar" is not a palindrome.

             Example 3:
                    Input: s = " "
                    Output: true
                    Explanation: s is an empty string "" after removing non-alphanumeric characters.
                    Since an empty string reads the same forward and backward, it is a palindrome.
         */
        //https://javarevisited.blogspot.com/2016/02/how-to-remove-all-special-characters-of-String-in-java.html#axzz7V5hqvjVG
        //https://javarevisited.blogspot.com/2012/01/how-to-reverse-string-in-java-using.html#axzz7V5hqvjVG
        //https://javarevisited.blogspot.com/2018/11/top-5-data-structures-and-algorithm-online-courses.html#axzz7V5hqvjVG
        StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]", ""));
        String originS = sb.toString();
        return sb.reverse().toString();

    }

    public boolean isPalindromeTowPoint(String s){
        //https://leetcode.com/problems/valid-palindrome/discuss/2095066/Java-Solution-oror-two-pointer
        String reS = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        if(s.length() == 0){
            return true;
        }

        char[] chars = reS.toCharArray();
        int j = reS.length()-1;
        for(int i = 0; i < j ; i++){
            if(chars[i] != chars[j]){
                return false;
            }
            j--;
        }
        System.out.println();
        return true;

    }

    public String zigzagConvert(String s, int numRows){
        /*
    https://leetcode.com/problems/zigzag-conversion/
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"

        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string s, int numRows);


        Example 1:
        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
        Explanation:
        p A H N (1 space in between)
        APLSIIG
        Y I R (1 space in between)
        Chart[3][] = {{P(0), , A(4), , H(8), , N(12)},-> (3 + 1)
                      {A(1),P(3),L(5), S(7),I(9), N(11),G(13)},
                      {Y(2), , I(6), , R(10)}}

        Example 2:
        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:
        P     I    N    (2 spaces) (4 + 2)
        A   L S  I G    ( 1 & no space)
        Y A   H R       (no space & 1 space)
        P     I         (2 spaces)
        sequence (n - 1) * 2
        (0)     (6)        (12)
        (1)  (5)(7)    (11)(13)
        (2)(4)  (8)(10)    (14)
        (3)     (9)        (15)

        (n - 1) * 2
        if i < numRows keep increment i and add chat to each sub array

        (0[0][0])            (8[0][4])                 (16[0][8])       low [n] [n + length] -> [0][0]
        (1[1][0])   (7[1][3])(9[1][4])       (15[1][7])(17[1][8])       low [n][n+length-n] 0r [n][n+length]
        (2[2][0])  (6[2][2])  (10[2][4])   (14[2][6])  (18[2][8])
        (3[3][0]) (5[3][1])   (11[3][4])(13[3][5])     (19[3][8])
        (4[4][0])             (12[4][4])               (20[4][8])

        Example 3:
        Input: s = "A", numRows = 1
        Output: "A"

        constraints:
        1 <= s.length <= 1000
        1 <= numRows <= 1000
        s consists of English letters (lower-case and upper-case), ',' and '.'.

        **BR->  patter : [i][j] -> each count increment ex) 15 = [i] + [j] * 2
     */
        String zigZagWord = null;

        if(numRows == 1){
            zigZagWord = s;
        } else {
            int cols = 0;
            int rows = numRows - 1;

            char[] inputS = s.toCharArray();
            int arrayRotation = inputS.length % rows;
            //determind the max length of 2nd(sub) array
            int mod = inputS.length % numRows;
            if(mod > 0) {
                cols = inputS.length / numRows + 1;
            } else {
                cols = inputS.length / numRows;
            }
            //ex)  festival, 3 -> 7/3 = 2 + mod(1), festivity , 3 -> 9/3 =3 + mod supercaliascaliousoutousity, 6 27/6 = 4 + 3

            //create a 2 dimensional array of char based on the input and rows
            char[][]zigZag = new char[rows][cols];

            //iterate input string of each char
            for(int i = 0; i < inputS.length; i++){
                /* [x][y]
                   (0[0][0])            (8[0][4])                 (16[0][8])
                   (1[1][0])   (7[1][3])(9[1][4])       (15[1][7])(17[1][8])
                   (2[2][0])  (6[2][2])  (10[2][4])   (14[2][6])  (18[2][8])
                   (3[3][0]) (5[3][1])   (11[3][4])(13[3][5])     (19[3][8])
                   (4[4][0])             (12[4][4])               (20[4][8])

                   (0[i/rows][i % rows])     (8[i % rows-2][8-8])                            (16[1 % rows - 3][8])
                   (1[i/rows][i % rows])   (7[8-7][i % rows]) (9[i/rows][4])       (15[i-14][7])(17[1][8])
                   (2[i/rows][i % rows])  (6[8-6][i % rows])  (10[i/rows][4])   (14[1-12][6])  (18[2][8])
                   (3[i/rows][i % rows]) (5[8-5][i % rows])   (11[i/rows][4])(13[i-10][5])     (19[3][8])
                   (4[i/rows][i % rows])                      (12[i/rows][4])               (20[4][8])

                 */
                //as long as the mode is less than rows keep increament the index of the inputS to store char to zigZag
                //until i increment to 4 (which means i / numRows + 1 == 0),y stays 0
                int x = i % (cols + 1);
                int y = i / (cols + 1);

                //if i == 5 (which means 1 / numRows == 1 (as odd number??)), then

            }
        }

        return zigZagWord;
    }//end zigZagConvert


    //---------------------Reverse String---------------------------------

    //https://www.techiedelight.com/10-ways-reverse-a-string-java/
    public String reverseStringStack(String s){

        if(s.length() == 0){
            return s;
        }

        Stack <Character>reverseS = new Stack<>();
        char[] sChar = s.replaceAll("[^0-9a-zA-Z]", "").toCharArray();
        for(char c : sChar){
            reverseS.push(c);
        }

        int k = 0;
        while(!reverseS.empty()){
            sChar[k++] = reverseS.pop();
        }
        return String.valueOf(sChar);

    }

    public String reverseStringWithStBuffer(String s){
        /*
    https://javaconceptoftheday.com/java-program-to-reverse-a-string/
    */
        String reverseS ="";

        return reverseS;
    }

    public String reverseStringStackStBuilder(String s){
        //use string.charAt instead of toCharArray

        if(s.length()==0){
            return s;
        }
        String sRev = s.replaceAll("[^0-9a-zA-Z]", "");
        Stack<Character> reverseCh = new Stack<>();
        for(int i = 0 ; i < sRev.length(); i++){
            reverseCh.push(sRev.charAt(i));
        }
        int k = 0;
        StringBuilder reverseS = new StringBuilder();

        while(!reverseCh.empty()){
            reverseS.append(reverseCh.pop());
        }

        return reverseS.toString();
    }

    public String reverseStringCollectionReverse(String s){
        if(s.length() <= 1){
            return s;
        }
        String s2 = s.replaceAll("[^0-9a-zA-Z]", "");
        List<Character> reverseList = new ArrayList<>();
        for(int i = 0; i < s2.length() ; i++){
            reverseList.add(s2.charAt(i));
        }
        /*
        for(char c : s2.toCharArray()){
            reverseList.add(c)
         */
        Collections.reverse(reverseList);
        /* instead of iterate through the list, simply convert to string of char list and remove all the special characters of spring representation of an array
        StringBuilder builder = new StringBuilder();

        for(char c : reverseList){
            builder.append(c);
        }
        return builder.toString();
         */
        return reverseList.toString().replaceAll("[^a-zA-Z0-9]", "");

    }

    public String reverseRecurse(String str){
        //https://javarevisited.blogspot.com/2012/01/how-to-reverse-string-in-java-using.html#axzz7V5hqvjVG

        if(str.length() < 2){
            return str;
        }

        return reverseRecurse(str.replaceAll("[^0-9a-zA-Z]", "").substring(1)) + str.charAt(0);

    }



}//End class

