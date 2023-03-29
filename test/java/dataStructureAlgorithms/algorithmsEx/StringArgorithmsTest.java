package dataStructureAlgorithms.algorithmsEx;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StringArgorithmsTest {

    private StringArgorithms stArg = new StringArgorithms();

    @Test
    void isUpperCaseTest(){
        Boolean upperCase = StringArgorithms.isUpppercase("HELLO");
        assertTrue(upperCase);
    }

    //validate specific properties of a string.
    @Test
    @DisplayName("Testing password criteria with method reference!")
    void isPasswordComplexTest(){
        assertFalse(StringArgorithms.isPasswordComplex("falsePassword"));
        assertFalse(StringArgorithms.isPasswordComplex("Sh0r1"));
        assertFalse(StringArgorithms.isPasswordComplex("WowThat1sLong"));
        assertTrue(StringArgorithms.isPasswordComplex("P@ssing1word"));

    }

    @Test
    @DisplayName("Testing reverse int value for validate palindrome")
    void isPalindromeTest(){
        assertTrue(StringArgorithms.isIntPalindrome(121));
        assertFalse(StringArgorithms.isIntPalindrome(2345));
        assertFalse(StringArgorithms.isIntPalindrome(-121));
    }
    @Test
    void StriingCompareTest(){
        //https://www.javatpoint.com/string-comparison-in-java
        String t1 = "Interview";
        String t2 = "Interview";
        String t3 = new String("Interview");
        String t4 = "interview";
        assertTrue(t1==t2);
        assertTrue(t1.equals(t2));
        assertTrue(t1.hashCode() == t2.hashCode());
        assertTrue(t1.equals(t3));

        assertFalse(t1==t3);
        assertFalse(t1==t4);
        assertTrue(t1.equalsIgnoreCase(t4));

        //lexicographical compare
        assertEquals(-32, t1.compareTo(t4));
        assertEquals(32, t4.compareTo(t1));

    }

    @Test
    @DisplayName("tests String mutability")
    void StringConcatTest(){
        String s1 = "seattle, ";
        s1.concat("Washington, ");
        s1.concat("U.S.A.");
        String s2 = s1.concat("WA");
        assertEquals("seattle, ", s1);
        assertEquals("seattle, WA", s2);
    }

    @Test
    @DisplayName("String concat Test")
    void StringTestwithPlusOperator(){
        String s1 = "java" + 1000 + 2000 + 3000;
        String s2 = 1000 + 2000 + 3000 + "java";
        String s3 = 1000 + 2000 + "java" + 3000;
        assertEquals("java100020003000", s1);
        assertEquals("6000java", s2);
        assertEquals("3000java3000", s3);
    }

    @Test
    @DisplayName("Stirng intern method validation test")
    void StringInternMethodTests(){
        String s1 = new String("java11");
        String s2 = new String("java11");
        //
        assertFalse(s1==s2);
        assertTrue(s1.equals(s2));
        assertFalse(s1 == s2.intern());
        assertTrue(s1.intern() == s2.intern());
    }

    @Test
    @DisplayName("https://www.baeldung.com/java-strings-concatenation -> Variouse String concatenate test")
    void StringConcatMethodTest(){
        String blob = "This".concat(" whole")
                .concat(" sentence")
                .concat(" doesn't")
                .concat(" make")
                .concat(" sense!");
        assertFalse(blob =="This whole sentence doesn't make sense!");
        assertTrue(blob.equals("This whole sentence doesn't make sense!"));

        String blob2 = String.format("%s %s %s %s %s %s", "I", "don't", "care", "what", "you", "say.");
        assertEquals(blob2, "I don't care what you say.");
        assertTrue(blob2.equals("I don't care what you say."));
        assertFalse(blob2 == "I don't care what you say.");

        String[] sentence = {"I'm", "running", "out", "of", "patience."};
        String verbiage = String.join(" ", sentence);
        assertTrue(verbiage.equals("I'm running out of patience."));

        StringJoiner wordPlus = new StringJoiner(", ");
        wordPlus.add("Java");
        wordPlus.add("react");
        wordPlus.add("spring-boot");
        assertEquals("Java, react, spring-boot", wordPlus.toString());

        List<String> animal = Arrays.asList("Jaguar", "Armadillo", "crocodail");
        String animals = animal.stream()
                .collect(Collectors.joining(", "));
        assertEquals("Jaguar, Armadillo, crocodail", animals);
        assertFalse("Jaguar, Armadillo, crocodail" == animals);
        assertTrue("Jaguar, Armadillo, crocodail".equals(animals));

    }

    @Test
    @DisplayName("test differences between String, StringBuffer & StringBuilder")
    void StringApiCompareTest(){
        /*
        https://www.techiedelight.com/difference-between-string-stringbuilder-java/#:~:text=We%20can%20use%20the%20equals,to%20compare%20two%20StringBuilder%20objects.
        We can use the equals() method for comparing two strings in java since the String class overrides the equals(0 method of the Object class
        while StringBuilder doesn't override the equals(0 method of the object class
        hence equals() method cannot be used to compare two StringBuilder objects
         */
        String java = "Java";
        StringBuffer sBuffer = new StringBuffer(java);
        StringBuilder sBuilder = new StringBuilder(java);
        System.out.println("StringBuffer value: " + sBuffer);
        assertFalse(java.equals(sBuffer));
        assertFalse("Java".equals(sBuilder));
        assertFalse(sBuffer.equals(sBuilder));
    }

    @Test
    @DisplayName("test String.indexOf()")
    void stirngIndexOfMethodTest(){
        String blob = "Java String interview priactice";
        assertEquals(17, blob.indexOf("view"));
        assertEquals(18, blob.indexOf("a") + blob.indexOf("view"));
        assertEquals(25, blob.indexOf('a', 5));
    }

    @Test
    @DisplayName("Testing StringBuffer methods")
    void stringBufferAndStringBuilderTest(){
        StringBuffer blobBuff = new StringBuffer("01234");

        String stBlob = new String(blobBuff.append(1.1).append('A').append(false).append("null"));
        assertEquals("012341.1Afalsenull", stBlob);

        StringBuilder stB = new StringBuilder("0123456789");
        String stBlob2 = new String(stB.delete(3, 6).deleteCharAt(4).deleteCharAt(5));
        assertEquals("01268", stBlob2);

        String stb2 = "123321123";
        stb2 = stb2.replaceFirst("123", "321").replaceAll("12", "21").substring(3, 6);
        assertEquals("321", stb2);

        StringBuffer stBuf = new StringBuffer("11111");
        String convertS = new String(stBuf.insert(3, false).insert(5, 3.3).insert(7, "One"));
        assertEquals("111fa3.One3lse11", convertS);

        StringBuffer sbRv = new StringBuffer("one two three four five six");
        int reverseS = sbRv.reverse().indexOf("two");
        assertEquals(-1, reverseS);
    //Q 60 - 05/12/2022

    }

    @Test
    @DisplayName("test StringBuilder non comparable that throws ClassCastException.")
    void stringBuilderComparableTest() {
        StringArgorithms.stringBuilderComparable();
        /*Exception exception = assertThrows(ClassCastException.class, StringArgorithms.stringBuilderComparable());

        //String exceptionMsg = "java.lang.StringBuilder";
        //String actualMsg = exception.getMessage();

        assertTrue(exception.getMessage().contains("cannot be cast"));
*/
    }


    @Test
    void groupAnagramsTest() {

    }

    @Test
    void isStringPalindromeTest() {
        assertEquals("amanaplanacanalpanama", stArg.isStringPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void isPalindromeTowPointTest() {
        assertEquals(true, stArg.isPalindromeTowPoint("A man, a plan, a canal: Panama"));
        assertEquals(false, stArg.isPalindromeTowPoint("This - text ! has \\ /allot # of % special % characters"));
    }


    @Test
    void reverseStringStackTest() {
        //assertEquals("sretcarahclaicepsfotollasahtxetsihT", stArg.reverseStringStack("This - text ! has \\ /allot # of % special % characters"));
        //assertEquals("sretcarahclaicepsfotollasahtxetsihT", stArg.reverseStringStackStBuilder("This - text ! has \\ /allot # of % special % characters"));
        //assertEquals("sretcarahclaicepsfotollasahtxetsihT", stArg.reverseStringCollectionReverse("This - text ! has \\ /allot # of % special % characters"));
        assertEquals("sretcarahclaicepsfotollasahtxetsihT", stArg.reverseRecurse("This - text ! has \\ /allot # of % special % characters"));
    }

    //https://www.geeksforgeeks.org/compare-two-strings-in-java/

}//end test class