package programs;
public class SubstringCountUsingIndexOf {
    public static void main(String[] args) {
        String input = "Java is great. Java is fun. Java is powerful.";
        String substring = "Java";

        int count = 0;
        int index = 0;

        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        System.out.println("Number of occurrences using indexOf(): " + count);
    }
}