// https://leetcode.com/problems/letter-case-permutation/

import java.util.*;

class LetterCasePermutation {
  public void generatePermutations(int index, char[] chars, List<String> permuatations) {
    if (index == chars.length)
      permuatations.add(new String(chars));
    else {
      if (Character.isLetter(chars[index])) {
        chars[index] = Character.toLowerCase(chars[index]);
        generatePermutations(index + 1, chars, permuatations);
        chars[index] = Character.toUpperCase(chars[index]);
      }
      generatePermutations(index + 1, chars, permuatations);
    }
  }

  public List<String> letterCasePermutation(String S) {
    List<String> permuatations = new ArrayList<>();

    generatePermutations(0, S.toCharArray(), permuatations);

    return permuatations;
  }

  public static void main(String[] args) {
    LetterCasePermutation l = new LetterCasePermutation();
    System.out.println(l.letterCasePermutation("a1b2"));
  }
}