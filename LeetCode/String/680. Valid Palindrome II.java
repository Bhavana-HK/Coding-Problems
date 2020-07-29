// https://leetcode.com/problems/valid-palindrome-ii/

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i=0, j=s.length()-1;
        
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return palindrome(s, i+1, j) || palindrome(s, i, j-1);
            i++; j--;
        }
                
        return true;
    }
    
    public boolean palindrome(String s, int i, int j){
        while(i <= j)
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}