public class StringManipulatorTest{
    public static void main(String[]  args){
        StringManipulator str = new StringManipulator();
        String S = str.trimAndconcat("  Hello  ","  World  ");
        System.out.println(S);
        char letter ='o';
        Integer a = str.getIndexOrNull("Coding", letter);
        Integer b = str.getIndexOrNull("Hello World", letter);
        Integer c = str.getIndexOrNull("Hi" , letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        String word = "Hello";
        String substring = "llo";
        String notSubString = "world";
        Integer d = str.getIndexOrNull(word, substring);
        Integer e = str.getIndexOrNull(word, notSubString);
        System.out.println(d);
        System.out.println(e);

    }
}



