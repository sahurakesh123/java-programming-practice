//https://prepinsta.com/goldman-sachs/technical-test/coding-questions/
/*
 *
 A taxi can take multiple passengers to the railway station at the same time.On the way back to the starting point,the taxi driver may pick up additional passengers for his next trip to the airport.A map of passenger location has been created,represented as a square matrix.

The Matrix is filled with cells,and each cell will have an initial value as follows:

A value greater than or equal to zero represents a path.
A value equal to 1 represents a passenger.
A value equal to -1 represents an obstruction.
The rules of motion of taxi are as follows:

The Taxi driver starts at (0,0) and the railway station is at (n-1,n-1).Movement towards the railway station is right or down,through valid path cells.
After reaching (n-1,n-1) the taxi driver travels back to (0,0) by travelling left or up through valid path cells.
When passing through a path cell containing a passenger,the passenger is picked up.once the rider is picked up the cell becomes an empty path cell. 
If there is no valid path between (0,0) and (n-1,n-1),then no passenger can be picked.
The goal is to collect as many passengers as possible so that the driver can maximize his earnings.
For example consider the following grid,

           0      1
          -1     0

Start at top left corner.Move right one collecting a passenger. Move down one to the destination.Cell (1,0) is blocked,So the return path is the reverse of the path to the airport.All Paths have been explored and one passenger is collected.

Returns:

Int:maximum number of passengers that can be collected.
Sample Input 0

4  -> size n = 4
4 -> size m = 4
0 0 0 1 -> mat
1 0 0 0
0 0 0 0
0 0 0 0
Output 0

2
Explanation 0

The driver can contain a maximum of 2 passengers by taking the following path
(0,0) → (0,1) → (0,2) → (0,3) → (1,3) → (2,3) → (3,3) → (3,2) → (3,1) → (3,0) → (2,0) → (1,0)  → (0,0)

Sample Input 1

 STD IN                  Function 

————              ————-

   3     →  size  n=3
   3    →  size m=3
   0 1 -1 → mat 
   1 0 -1
   1 1 1
Sample Output 1

5
Explanation 1

The driver can contain a maximum of 5 passengers by taking the following path
(0,0) → (0,1) → (1,1) → (2,1) → (2,2) → (2,1) → (2,0) → (1,0) → (0,0) 
 *
 */
package programs;
import java.util.*;
class TaxiDriverMatrixProblem {
  public static int cost(int grid[][], int row1, int col1, int row2, int col2) {
    if (row1 == row2 && col1 == col2) {
      if (grid[row1][col1] == 1)
        return 1;
      return 0;
    }
    int ans = 0;
    if (grid[row1][col1] == 1)
      ans++;

    if (grid[row2][col2] == 1)
      ans++;
    return ans;
  }

  public static int solve(int n, int m, int grid[][], int dp[][][], int row1, int col1, int row2) {
    int col2 = (row1 + col1) - (row2);

    if (row1 == n - 1 && col1 == m - 1 && row2 == n - 1 && col2 == m - 1)
      return 0;

    if (row1 >= n || col1 >= m || row2 >= n || col2 >= m)
      return -1 * Integer.MAX_VALUE;

    if (dp[row1][col1][row2] != -1)
      return dp[row1][col1][row2];

    int ch1 = -1 * Integer.MAX_VALUE, ch2 = -1 * Integer.MAX_VALUE;
    int ch3 = -1 * Integer.MAX_VALUE, ch4 = -1 * Integer.MAX_VALUE;

    if (grid[row1][col1 + 1] != -1 && grid[row2 + 1][col2] != -1)
      ch1 = cost(grid, row1, col1 + 1, row2 + 1, col2) + solve(n, m, grid, dp, row1, col1 + 1, row2 + 1);

    if (grid[row1][col1 + 1] != -1 && grid[row2][col2 + 1] != -1)
      ch2 = cost(grid, row1, col1 + 1, row2, col2 + 1) + solve(n, m, grid, dp, row1, col1 + 1, row2);

    if (grid[row1 + 1][col1] != -1 && grid[row2][col2 + 1] != -1)
      ch3 = cost(grid, row1 + 1, col1, row2, col2 + 1) + solve(n, m, grid, dp, row1 + 1, col1, row2);

    if (grid[row1 + 1][col1] != -1 && grid[row2 + 1][col2] != -1)
      ch4 = cost(grid, row1 + 1, col1, row2 + 1, col2) + solve(n, m, grid, dp, row1 + 1, col1, row2 + 1);

    return dp[row1][col1][row2] =
      Math.max(ch1, Math.max(ch2, Math.max(ch3, ch4)));
  }

  public static void initializeDp(int dp[][][], int item) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < 5; k++)
          dp[i][j][k] = item;
    }
  }

  public static int collectMax(int n, int m, int grid[][]) {
    int ans = 0;
    int dp[][][] = new int[6][6][6];
    initializeDp(dp, -1);
    if (grid[n - 1][m - 1] == -1 || grid[0][0] == -1)
      ans = -1 * Integer.MAX_VALUE;
    if (grid[0][0] == 1)
      ans++;
    grid[0][0] = 0;

    if (grid[n - 1][m - 1] == 1)
      ans++;
    grid[n - 1][m - 1] = 0;
    ans += solve(n, m, grid, dp, 0, 0, 0);
    return Math.max(ans, 0);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int arr[][] = new int[n + 1][m + 1];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        arr[i][j] = sc.nextInt();
    System.out.println(collectMax(n, m, arr));
  }
}