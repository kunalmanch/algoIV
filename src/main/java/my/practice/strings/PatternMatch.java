package my.practice.strings;

import java.util.HashMap;

/**
 * Check if string follows order of characters defined by a pattern or not
 */
public class PatternMatch {

    public static boolean match(String t, String p) {
        for (int i = 0; i < p.length() - 1; i++) {
            int last = t.lastIndexOf(p.charAt(i));
            int first = t.indexOf(p.charAt(i + 1));
            //if last occ of char[i] is after first occ of char[i + 1], there is no match.
            if (last == -1 || first == -1 || last > first) return false;
        }
        return true;
    }

    public static boolean hasPattern(String str, String pattern){
        if(str == null){
            return false;
        }
        if(pattern == null){
            return true;
        }
        int current = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            hm.put(pattern.charAt(i), i+1);
        }
        for(int i = 0; i < str.length(); i++){
            if(hm.containsKey(str.charAt(i))){
                if(hm.get(str.charAt(i)) == current){
                    continue;
                }
                else if(hm.get(str.charAt(i)) > current){
                    current = hm.get(str.charAt(i));
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.err.println(match("engineers rock", "er"));
        System.err.println(match("engineers rock", "esr"));
        System.err.println(hasPattern("engineers rock", "er"));
        System.err.println(hasPattern("engineers rock", "esr"));
    }
}
