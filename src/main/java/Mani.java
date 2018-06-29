public class Mani {
    public static String decoded;

    public static void main(String[] args) {
        Encoder str = new Encoder();
        String str1 = str.consent();
        System.out.println(str1);
        decoded = Decoder.decorer(str1);
        System.out.printf(decoded);
    }
}
