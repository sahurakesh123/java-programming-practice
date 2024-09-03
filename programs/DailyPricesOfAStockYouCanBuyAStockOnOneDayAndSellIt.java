/*
 * 
https://prepinsta.com/goldman-sachs/technical-test/coding-questions/
Question : 2
You are given a list of daily prices of a stock. You can buy a stock on one day and sell it later on another day after the day you bought the stock. You can perform the above operation only once. What is the maximum loss possible?

Example

Prices=[10,4,2,9]

The greatest loss is incurred when you buy at a price of 10 and sell at a price of 2.Return the difference:9.

Example

Price=[1,2,3,4] 

The Price went up everyday.Return 0.

Sample Input for Custom Testing

 STDIN                   Function 

———–               ————–

   7   →     prices []  size n=7
   1 →       prices =[1,8,4,2,10,3,2] 
   8
   4
   2
  10
   3
   2
Sample Output

  8
 Explanation

Using zero-based index notation,the correct answer is a[4]-a[6]=10-2=8.There is a greater difference between 10 and 1 but that would imply selling before buying,and short selling is not allowed in this problem.
 *
 *
 **/

package programs;
import java.util.*;
class DailyPricesOfAStockYouCanBuyAStockOnOneDayAndSellIt {
  public static int solve(ArrayList < Integer > list) {
    int n = list.size();
    if (n == 0)
      return 0;
    int max = list.get(0);
    for (int i = 1; i < n; i++)
      max = Math.max(max, list.get(i));
    if (max <= 0)
      return 0;
    int maxSum = 0;
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum = sum + list.get(i);
      if (sum < 0)
        sum = 0;
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    ArrayList < Integer > list = new ArrayList();

    for (int i = n - 2; i >= 0; i--)
      list.add(arr[i] - arr[i + 1]);
    int res = solve(list);

    if (res < 0)
      System.out.println(0);
    else
      System.out.println(res);
  }
}