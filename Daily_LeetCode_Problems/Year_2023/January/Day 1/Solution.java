// https://leetcode.com/problems/word-pattern/description/

class Solution {
	public boolean wordPattern(String pattern, String s) {
		String[] arr = s.split(" ");
		if(arr.length != pattern.length()) return false;   //Base Condition

		for(int i = 0; i < pattern.length()-1; i++){
			for(int j = i+1; j < pattern.length(); j++) {              // Check from next element
				if(pattern.charAt(i) == pattern.charAt(j)) {        // if 2 character equals
					if( !arr[i].equals(arr[j])) {                   // will check whether it is equal in the array or not
						return false;
					}
				} else {                               //it means character are not equal from pattern  
					if(arr[i].equals(arr[j])) {     //Will check for whether elements from array are equal  
						return false;
					}
				}
			}
		}
		return true;
	}
}
