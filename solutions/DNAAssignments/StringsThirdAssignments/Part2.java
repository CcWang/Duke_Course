
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public static double cgRatio(String dna){
        double cg = 0.0;
        for(int i=0;i<dna.length();i++){
            
            if(String.valueOf(dna.charAt(i)).equals("C") || String.valueOf(dna.charAt(i)).equals("G")){
                cg++;
            }
            
            
           //System.out.println(String.valueOf(dna.charAt(i)).equals("C"));
        };
        double length = dna.length();
        return cg/length;
    }
    public static int countCTG(String dna){
        int times = 0;
        for(int i=0;i<dna.length();i++){
            if(String.valueOf(dna.charAt(i)).equals("C") || String.valueOf(dna.charAt(i)).equals("G")|| String.valueOf(dna.charAt(i)).equals("T")){
                times++;
            }
        };
        return times;
    }
    public void test(){
        double result = cgRatio("ATGCCATAG");
        System.out.println("resting"+result);
    }
}
