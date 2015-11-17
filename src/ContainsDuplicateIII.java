import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author cassie9082
 * 
 */
public class ContainsDuplicateIII {
	/* Notes--------------
	Treeset.floor(c):
	Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
	Treeset.ceiling(c):
	Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
	*/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Time O(NlogK), Space O(k)
        if(k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int c = nums[i];
            if(set.floor(c) != null && set.floor(c) >= c - t 
            || set.ceiling(c) != null && set.ceiling(c) <= c + t){
                return true;
            }else{
                set.add(c);
                if(i >= k){
                    //keep a sliding window containing k elements of nums
                    set.remove(nums[i - k]);
                }
            }
        }
        return false;
    }
    
    
    
    //会用到TreeSet中的subSet(leftboundary, rightboundary）方法，返回SortedSet
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
    	if (k < 1 || t < 0)
    		return false;
     
    	SortedSet<Long> set = new TreeSet<Long>();
     
    	for (int j = 0; j < nums.length; j++) {
    		long leftBoundary = (long) nums[j] - t;
    		long rightBoundary = (long) nums[j] + t + 1;
    		SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);
     
    		if (!subSet.isEmpty())
    			return true;
     
    		set.add((long) nums[j]);
     
    		if (j >= k) {
    			set.remove((long) nums[j - k]);
    		}
    	}
     
    	return false;
    }
}



