
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public static int howMany(String a, String b){
        int startIdx= b.indexOf(a);
        int currentIdx = startIdx;
        int howMany = 0;
        while(currentIdx !=-1){
            howMany ++;
            currentIdx = b.indexOf(a,(currentIdx+a.length()));
        }
        return howMany;
    }
    public void testHowMany(){
        System.out.println("How many times o showing in hello - "+ howMany("o","hello"));
        System.out.println("How many times a showing in hello - "+howMany("a","hello"));
        System.out.println("How many times GAA shows "+howMany("GAA","ATGAACGAAXXGAAXXGAA"));
    }
}
