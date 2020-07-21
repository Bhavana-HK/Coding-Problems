// https://leetcode.com/problems/verifying-an-alien-dictionary/

class AlienDictonay{
    
    public static boolean greaterThan(String word1, String word2, int[] alphabet){
        int i=0;
        while(i < word1.length() && i < word2.length()){
            int char1 = word1.charAt(i) - 'a';
            int char2 = word2.charAt(i) - 'a';
            if(alphabet[char2] < alphabet[char1])
                return true;
            else if(alphabet[char2] > alphabet[char1])
                return false;
            else i++;
        }
        if(i < word1.length())
            return true;
        return false;
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphabet = new int[26];
        for(int i=0; i < 26; i++)
            alphabet[order.charAt(i) - 'a'] = i;
        
        for(int i=0; i < words.length-1; i++)
            if(greaterThan(words[i], words[i+1], alphabet))
                return false;
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new AlienDictonay().isAlienSorted(new String[]{}, ""));
    }
}