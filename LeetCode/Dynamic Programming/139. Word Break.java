// https://leetcode.com/problems/word-break/

import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isWordBreak = new boolean[s.length() + 1];
        isWordBreak[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!isWordBreak[j])
                    continue;
                if (wordDict.contains(s.substring(j, i))) {
                    isWordBreak[i] = true;
                    break;
                }
            }
        }

        return isWordBreak[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<String>();
        String[] words = new String[] { "cats", "dog", "sand", "and", "cat" };
        wordDict = Arrays.asList(words);

        System.out.println(new WordBreak().wordBreak("catsandog", wordDict));
    }
}