// https://leetcode.com/problems/detect-capital/description/

class Solution {
		public boolean detectCapitalUse(String word) {
			if(allCaps(word) || allLower(word) || titleCase(word)) {
				return true;
			}
		return false;
	}

	private boolean allCaps(String word) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(Character.isUpperCase(ch)) {
				count++;
			}
		}
		if(count == word.length()) {
			return true;
		}
		return false;
	}

	private boolean allLower(String word) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(Character.isLowerCase(ch)) {
				count++;
			}
		}
		if(count == word.length()) {
			return true;
		}
		return false;
	}

	private boolean titleCase(String word) {
		char ch = word.charAt(0);
		String sub_str = word.substring(1);
		if(Character.isUpperCase(ch) && allLower(sub_str)) {
			return true;
		} 
		return false;
	}
}
