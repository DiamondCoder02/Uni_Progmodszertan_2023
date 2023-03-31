package Lesson8_test;

public class T1_CharString {
    public static void main(String[] args) {
        String str;
        char ch;
        str = "asdasdasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        ch = 'a';
        System.out.println("Let's see how many \"" + ch + "\" is in: \"" + str + "\"");
        // count how many times ch is in str
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println("\"" + ch + "\" is in it \"" + count + "\" times");
        // 69 - Nice 
        if (count==69) { System.out.println(" Nice ;D"); }
    }
}
