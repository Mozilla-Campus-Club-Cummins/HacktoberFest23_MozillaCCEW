package hacktoberfest;
import java.util.*;

public class LongestSubstring {

	public static int longestSubstring(String str) {

		// Base case
        if(str.length() == 0) {
             return 0;
        }
        
        // To keep track of maximum length of substring
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        
        int left = 0;
        
        // Outer loop for traversing the string
        for (int right = 0; right < str.length(); right++) { 
        	
        	// If any duplicate element is found
            if (set.contains(str.charAt(right))) { 
                while (left < right && set.contains(str.charAt(right))) {
                    set.remove(str.charAt(left));
                    left++;
                }
            }
            
            set.add(str.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
	
	// Driver code
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		// Input string
        System.out.print("Enter a string = ");
        String str = sc.next();
        
        // Call the method
        int ans = longestSubstring(str);
        System.out.println("Length of the longest substring is = " + ans);
        
        sc.close();

    }

}

