package SubstringProject;

import java.util.HashSet;

public class Main {
    
	public static void main(String[] args){

        String s = "abcabcbb";

        int valeur = lengthOfLongestSubstring(s);

        System.out.println(valeur);
	}
    private static int lengthOfLongestSubstring(String s) {

        char arrayS[] = new char[s.length()];
        s.getChars(0, s.length(), arrayS, 0);
        int bigger = 0;
        int counter = 0;
        HashSet <String> bloc = new HashSet<String>();

        for (int i = 0; i < s.length(); i++){
            if(bloc.contains(String.valueOf(arrayS[i]))){
                if (counter > bigger){
                    bigger = counter;
                }
                bloc.remove(String.valueOf(arrayS[i]));
                counter = 0;
            }else{
                bloc.add(String.valueOf(arrayS[i]));
                counter++;
                if (counter > bigger){
                    bigger = counter;
                }
            }
        }
        return bigger;
    }

}