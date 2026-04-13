/*3. Longest Substring Without Repeating Characters
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/

/*
*(On part des petites sous-chaînes aux grandes)*

**a. Pour n = 1 → longueur de chaîne**
- Retrouver / Compter toutes les sous-chaînes de longueurs n.
- Pour chaque sous-chaîne de longueur n, trouver :
  - Compter les répétitions.
  - Si ∃ en a, on fait rien
  - Si il n'y en a pas : max = n, la sous-chaîne est la solution
  - On peut continuer.

Si max = n (donc on a trouvé) on continue avec la boucle.
Si max < n, on sort, plus besoin de continuer.*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class C3_Longest_Substring_Without_Repeating_Characters {

    public static int lengthOfLongestSubstring(String s) {
        String souschaine;
        int max = 1;
        Map<Character,Integer> compteur = new HashMap<>();

        if (s.length()>1){for (int indicedebut = 0; indicedebut<(s.length()-1); indicedebut++){

            for (int indicedefin = indicedebut+2; indicedefin<= s.length() + 1 ;indicedefin++){

                souschaine = s.substring(indicedebut,indicedefin);
                for (int i=0; i<souschaine.length();i++){
                    compteur.merge(souschaine.charAt(i),1,Integer::sum);
                }

                if (!(Collections.max(compteur.values())>1)){
                    max = souschaine.length() -1;
                }

                compteur.clear();

            }
        }
            }

        return max;

    }


    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
