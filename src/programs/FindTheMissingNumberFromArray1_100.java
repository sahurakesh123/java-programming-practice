package programs;

public class FindTheMissingNumberFromArray1_100 {

	public static void main(String[] args) {
		 int[] arr = { 1, 2, 3, 5, 7 };
	        int n = 7;
	       missingNumber(n, arr);
	}
	
	public static void missingNumber(int n, int[] arr)
    {
        // Create hash array of size n+1
        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < n - 1; i++) {
        	try {
        		hash[arr[i]]++;
        	}catch(Exception e) {
        		break;
        	}
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                System.out.println(i);
            }
        }

        // Edge case handling (though problem guarantees a
        // solution)
        //return -1;
    }
		
	 public static int missingNumberFromFormula(int n, int[] arr)
	    {
	        int sum = 0;

	        // Calculate the sum of array elements
	        for (int i = 0; i < n - 1; i++) {
	            sum += arr[i];
	        }

	        // Calculate the expected sum
	        int expectedSum = (n * (n + 1)) / 2;

	        // Return the missing number
	        return expectedSum - sum;
	    }

}
