
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
      String vowels = "aeiouAEIOU";
      int idx = vowels.indexOf(ch);
      if(idx !=-1){
        return true;
      }else{
        return false;
      }
    };
    public String replaceVowels(String phrase, char ch){
        // example replaceVowels("Hello",'*'); will return "H*ll*"
        StringBuilder sb = new StringBuilder(phrase);
        String vowels = "aeiouAEIOU";
        for(int i=0;i<sb.length();i++){
            char currChar = sb.charAt(i);
            int idx = vowels.indexOf(currChar);
            if(idx !=-1){
                sb.setCharAt(i,ch);
            };
        };
        return sb.toString();
    };
    
    public String emphasize(String phrase,char ch){
        //example emphasize("dna ctgaaactga", 'a'); will return "dn* ctg+*+ctg+"
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++){
            
            if(sb.charAt(i)==ch && i%2==0){
                
                sb.setCharAt(i,'+');
            }else if(sb.charAt(i)==ch && i%2==1){
                sb.setCharAt(i,'*');
            }
        };
        
        return sb.toString();
    };
    
}
