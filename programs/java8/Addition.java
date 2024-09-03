package programs.java8;
interface AdditionInterf {

    Integer getSum(int a, int b);
}

public class Addition{ 

private static void printSum(int a, int b, AdditionInterf addObject) {
    System.out.println(addObject.getSum(a, b));
}

public static void main(String[] args) {
    printSum(2, 3, (a, b) -> a + b);
}
}

