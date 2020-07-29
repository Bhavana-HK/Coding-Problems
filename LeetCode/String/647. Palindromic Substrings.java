// https://leetcode.com/problems/palindromic-substrings/

class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        if(s == null || s.length() == 0)
            return count;
        
        for(int i = 0; i < s.length(); i++){
            count += checkPalindrome(s, i, i); // odd length string
            count += checkPalindrome(s, i, i+1); // even length string
        }
        
        return count;
    }
    
    public int checkPalindrome(String s, int left, int right){
        // start from center and grow the substring outward
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++; count++;
        }
        return count;
    } 
}
/* 
 * string = aabaa
 * 
 * In the for loop, we are taking each index i as a mid point
 * In first function call, i is taken as the mid point of an odd string
 * i=0 -> checkPalindrome finds that only "a" can be a palindrome
 * i=1 -> checkPalindrome finds that only "a" can be a palindrome
 * i=2 -> checkPalindrome finds that "b", "aba", "aabaa" can be palindromes
 * i=3 -> checkPalindrome finds that only "a" can be a palindrome
 * i=3 -> checkPalindrome finds that only "a" can be a palindrome
 *
 * In second function call, i and i+1 are taken as the center of the palindrome substring
 * i=0 -> checkPalindrome finds that "aa" can be a palindrome
 * i=1 -> checkPalindrome finds that "ab" cannot be a palindrome
 * i=2 -> checkPalindrome finds that "ba" cannot be a palindrome
 * i=3 -> checkPalindrome finds that "aa" can be a palindrome
 * i=3 -> checkPalindrome returns 0 as right is not < s.length()
*/