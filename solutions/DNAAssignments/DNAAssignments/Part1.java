
/**
 * Write a description of StringsFirstAssignments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public static String findSimpleGene(String dna){
        int start = dna.indexOf("ATG");
        int stop = dna.indexOf("TAA",start+3);
        if (start ==-1 || stop ==-1){
            return "";
        }else{
            String result = dna.substring(start,stop+3);
            int between = stop-start;
            if(between%3 == 0){
                return result;
            }else {
                return "";
            }
        }
    }
    
    public void testSimpleGene(){
        String dna0= "ATCCTCTTCGGCTGCTCTAATATGGT";
        String dna1= "ATCCTCTTCGGCTGCTCDDTATGGAT";
        String dna2="ATCCTCTTCGGCTGCTCTAGGGT";
        String dna3="ATGCTCTTCGGCTGCTCTTAATATGGT";
        String dna4="ATGCTCTTCGGCTGCTCTAATATGGT";
        System.out.println("Original DNA is "+dna0);
        String gen0=findSimpleGene(dna0);
        System.out.println("Gene is "+gen0);
        System.out.println("Original DNA is "+dna1);
        String gen1=findSimpleGene(dna1);
        System.out.println("Gene is "+gen1);
        System.out.println("Original DNA is "+dna2);
        String gen2=findSimpleGene(dna2);
        System.out.println("Gene is "+gen2);
        System.out.println("Original DNA is "+dna3);
        String gen3=findSimpleGene(dna3);
        System.out.println("Gene is "+gen3);
        System.out.println("Original DNA is "+dna4);
        String gen4=findSimpleGene(dna4);
        System.out.println("Gene is "+gen4);
;    }
}
