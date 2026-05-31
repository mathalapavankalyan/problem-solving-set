package recursioncodes.arrays.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] nums = {2,7,11,15};
//		solution.twoSum(nums, 9);
//		
//		boolean ans = solution.isPalindrome("race a car");
//		System.out.println(ans);
		
//		int[] nums = {2,1,-1};
//		int index = solution.pivotIndex(nums);
//		System.out.println(index);
//		int[] nums = {0,1,1,3,3};
//		double ans = solution.findMaxAverage(nums , 4);
//		System.out.println(ans);
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(solution.threeSum(nums));
		
		
		
	}
	
	// Two Sum
	
	public int[] twoSum(int[] nums, int target) {
		int[] emptyCase = {-1,-1};
		HashMap<Integer , Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int rem = target - nums[i];
			Integer idx = map.get(rem);
			if(idx != null) {
				return new int[] {map.get(rem) , i};
			}
			else {
				map.put(nums[i],i );
			}
		}
		return emptyCase;
	}
	
	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	public int maxProfit(int[] prices) {
        int max_profit= 0;
       int mini = prices[0];
       for(int i = 1;i<prices.length;i++) {
       	mini = Math.min(prices[i], mini);
       	max_profit = Math.max(max_profit,prices[i] - mini );
       }
       
       return max_profit;
   }

	
	 public int maxSubArray(int[] nums) {
		 
//		 int current_sum = 0;
//		 int max_sum = Integer.MIN_VALUE;
//		 for(int i:nums) {
//			 if(current_sum <0) {
//				 current_sum = 0;
//			 }
//			 current_sum+=i;
//			 max_sum = Math.max(max_sum, current_sum);
//		 }
//		 return max_sum;
		  int currentSum = nums[0];
	        int maxSum = nums[0];

	        for (int i = 1; i < nums.length; i++) {
	            currentSum = Math.max(nums[i], currentSum + nums[i]);
	            maxSum = Math.max(maxSum, currentSum);
	        }

	        return maxSum;
	        
	    }
	 
	  // https://leetcode.com/problems/move-zeroes/
	    public void moveZeroes(int[] nums) {
	    	
	    	int index = 0;
	    	for(int i=0;i<nums.length;i++) {
	    		if(nums[i]!=0) {
	    			int temp = nums[index];
	    			nums[index] = nums[i];
	    			nums[i] = temp;
	    			index++;
	    		}
	    	}
	    }
	    
	     // https://leetcode.com/problems/valid-palindrome/
//	    public boolean isPalindrome(String s) {
//	    	int start  =0;
//	    	int end = s.length()-1;
//	    	while(start <end) {
//	    		char ch = s.charAt(start);
//	    		char endCh = s.charAt(end);
//	    		if(!Character.isLetterOrDigit(ch)) {
//	    			start++;
//	    		}
//	    		else if(!Character.isLetterOrDigit(endCh)) {
//	    			 end--;
//	    		}
//	    		else if(Character.toLowerCase(ch)!= Character.toLowerCase(endCh)) {
//	    			return false;
//	    		}
//	    		else {
//	    			start++;
//		    		end--;
//	    		}
//	    		
//	    	}
//	        return true;
//	    }
//	    
	    public boolean isPalindrome(String s) {
	        return check(s, 0, s.length() - 1);
	    }

	    private boolean check(String s, int left, int right) {
	        if (left >= right) {
	            return true;
	        }

	        if (!Character.isLetterOrDigit(s.charAt(left))) {
	            return check(s, left + 1, right);
	        }

	        if (!Character.isLetterOrDigit(s.charAt(right))) {
	            return check(s, left, right - 1);
	        }

	        if (Character.toLowerCase(s.charAt(left)) !=
	            Character.toLowerCase(s.charAt(right))) {
	            return false;
	        }

	        return check(s, left + 1, right - 1);
	    }
	    
	    // https://leetcode.com/problems/find-pivot-index/
	    public int pivotIndex(int[] nums) {
	        int prefix_sum = 0;
	        for(int i:nums){
	            prefix_sum+=i;
	        }
	        int current_sum = 0;
	        for(int i=0;i<nums.length;i++){
	            if(current_sum == prefix_sum-nums[i]-current_sum){
	                return i;
	            }
	            current_sum+=nums[i];
	        }
	        return -1;
	    }
	    
	    // https://leetcode.com/problems/maximum-average-subarray-i/
//	    public double findMaxAverage(int[] nums, int k) {
//	    	if(nums.length < k) {
//	    		return 0.0;
//	    	}
//	    	double current_sum  = 0;
//	    	for(int i=0;i<k;i++) {
//	    		current_sum+=nums[i];
//	    	}
//	    	double max_average = current_sum/k;
//	    	
//	    	for(int i=1;i+k-1<nums.length;i++) {
//	    		current_sum = current_sum - nums[i-1]+nums[i+k-1];
//	    		max_average = Math.max(max_average,current_sum/k);
//	    	}
//	        return max_average;
//	    }
	    
	        public double findMaxAverage(int[] nums, int k) {
	            if (nums.length < k) {
	                return 0.0;
	            }

	            double windowSum = 0;

	            // Initial window
	            for (int i = 0; i < k; i++) {
	                windowSum += nums[i];
	            }

	            double maxAverage = windowSum / k;

	            // Slide the window
	            for (int right = k; right < nums.length; right++) {
	                windowSum += nums[right];
	                windowSum -= nums[right - k];

	                maxAverage = Math.max(maxAverage, windowSum / k);
	            }

	            return maxAverage;
	        }
	        
	        // https://leetcode.com/problems/squares-of-a-sorted-array/
	        public int[] sortedSquares(int[] nums) {
	            int left = 0;
	            int right = nums.length-1;
	            int pos = nums.length-1;
	            int[] result = new int[nums.length];
	            while (left<=right){
	                if(Math.abs(nums[left]) > Math.abs(nums[right])){
	                    result[pos] = nums[left] * nums[left] ;
	                    left+=1;
	                }
	                else{
	                     result[pos] = nums[right] * nums[right];
	                     right-=1;
	                }
	                pos-=1;
	            }

	            return result;

	        }
	        
	        // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	        public int removeDuplicates(int[] nums) {
	            int j=1;
	            for(int i=1;i<nums.length;i++){
	                if(nums[i]!=nums[i-1]){
	                    nums[j] = nums[i];
	                    j+=1;
	                }
	            }
	            return j;
	        }
	        
	        // https://leetcode.com/problems/container-with-most-water/
	        public int maxArea(int[] height) {
	            int left = 0;
	            int right = height.length-1;
	            int max_container = 0;

	            while(left < right){
	                int current_container = (right - left) * Math.min(height[left] , height[right]);
	                max_container = Math.max(current_container , max_container);
	                if(height[left] <= height[right]){
	                  left++;
	                }
	                else{
	                 right--;
	                }
	            }
	            return max_container;
	         }
	        
	        // https://leetcode.com/problems/3sum/
//	        public List<List<Integer>> threeSum(int[] nums) {
//	            List<List<Integer>> pairs = new ArrayList<>();
//	            int window_sum = 0;
//	            int n = nums.length;
//	            if(n<3){
//	               
//	                return new ArrayList<>();
//	            }
//	            Set<Integer> uniqueSet = new HashSet<>();
//	            for(int i = 0;i<3;i++){
//	                window_sum+=nums[i];
//	            }
//	            if(window_sum == 0){
//	                uniqueSet.add(nums[0]);
//	                uniqueSet.add(nums[1]);
//	                uniqueSet.add(nums[2]);
//	                pairs.add(new ArrayList<>(Arrays.asList(nums[0] ,nums[1] , nums[2])));
//	            }
//	            
//	            for(int i=3;i<n;i++) {
//	            	window_sum+=nums[i];
//	            	window_sum-=nums[i-3];
//	            	if(window_sum == 0) {
//	            		if(!uniqueSet.contains(nums[i])) {
//	            			pairs.add(new ArrayList<>(Arrays.asList(nums[i-2] ,nums[i-1] , nums[i])));
//	            			uniqueSet.add(nums[i]);
//	            		}
//	            	}
//	            }
//	            return pairs;
//
//	        }
	        
	        public List<List<Integer>> threeSum(int[] nums) {
	            List<List<Integer>> result = new ArrayList<>();

	            Arrays.sort(nums);

	            for (int i = 0; i < nums.length - 2; i++) {

	                if (i > 0 && nums[i] == nums[i - 1]) {
	                    continue; // skip duplicates
	                }

	                int left = i + 1;
	                int right = nums.length - 1;

	                while (left < right) {

	                    int sum = nums[i] + nums[left] + nums[right];

	                    if (sum == 0) {

	                        result.add(Arrays.asList(
	                                nums[i],
	                                nums[left],
	                                nums[right]));

	                        while (left < right &&
	                               nums[left] == nums[left + 1]) {
	                            left++;
	                        }

	                        while (left < right &&
	                               nums[right] == nums[right - 1]) {
	                            right--;
	                        }

	                        left++;
	                        right--;

	                    } else if (sum < 0) {
	                        left++;
	                    } else {
	                        right--;
	                    }
	                }
	            }

	            return result;
	        }
	    
	    
}
