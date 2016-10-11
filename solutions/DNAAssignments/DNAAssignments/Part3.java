
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public static Boolean twoOccurrences(String stringa, String stringb){
        int timeOne = stringb.indexOf(stringa);
        if(timeOne == -1){
            return false;
        }else {
            int timeTwo = stringb.indexOf(stringa,timeOne+stringa.length());
            if(timeTwo == -1){
                return false;
            }
            return true;
        }
    }
    public void testing(){
        System.out.println(twoOccurrences("by","A story by Abby Long"));
        System.out.println(twoOccurrences("a","banana"));
        System.out.println(twoOccurrences("atg","ctgtatgta"));
        System.out.println(lastPart("by","theway"));
        System.out.println(lastPart("an","banana"));
    }
   
    public static String lastPart(String stringa, String stringb){
        int occ = stringb.indexOf(stringa);
        String result ="";
        if(occ == -1){
            result = "The part of the string after "+ stringa+" in "+ stringb+" is "+stringb;
        }else{
            String after = stringb.substring(occ+stringa.length());
            result = "The part of the string after "+ stringa+" in "+ stringb+" is "+after;
        }
        return result;
    }
    
    
}
