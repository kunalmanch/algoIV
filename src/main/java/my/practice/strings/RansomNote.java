package my.practice.strings;

/**
 * Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines, 
 * write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;
 *  otherwise,  it  will  return  false.   
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) return true;

        char[] arr = new char[256];
        int count = 0;
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i)]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (arr[magazine.charAt(i)] == 0) continue;
            arr[magazine.charAt(i)]--;
            count++;
            if (count == ransomNote.length()) break;
        }
        return count == ransomNote.length();
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.err.println(rn.canConstruct("aa", "aab"));
        System.err.println(rn.canConstruct("a", "b"));
        System.err.println(rn.canConstruct("aa", "baa"));
        System.err.println(rn.canConstruct("", "a"));
    }
}
