package Palindromic;

//Given a string s, return the longest palindromic substring in s.
public class Main {
    public static void main(String[] args){

        String s = "bbbcbbbabba";
        System.out.println(biggerPali(s));
	}

    private static boolean verifiePali(String s){
        char arrayS[] = new char[s.length()];
        s.getChars(0, s.length(), arrayS, 0);
        boolean key = true;
        
        for (int i = 0; i < arrayS.length/2; i++) {
            if (Character.compare(arrayS[i], arrayS[arrayS.length - 1 -i]) != 0 ){
                key = false;
            }
        }
        return key;
    }

    private static String biggerPali(String s){
        int bigger = 0;
        String biggerPali ="";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i < s.length() - 1 -j){
                    if (verifiePali(s.substring(i,s.length() - 1 -j))){
                        if (s.substring(i,s.length() - 1 -j).length() > bigger){
                            bigger = s.substring(i,s.length() - 1 -j).length();
                            biggerPali = s.substring(i,s.length() - 1 -j);
                        }
                    }
                }
            }
        }

        return biggerPali;
    }

}
