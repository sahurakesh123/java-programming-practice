package programs;
public class SubstringCountUsingSplit {
    public static void main(String[] args) {
        String input = "Java is great. Java is fun. Java is powerful.";
        String substring = "Java";

        // Use split() to divide the input based on the substring
        String[] parts = input.split(substring, -1);

        // The count of occurrences of the substring is the number of parts minus one
        int count = parts.length - 1;

        System.out.println("Number of occurrences using split(): " + count);
    }
}