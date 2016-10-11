
/**
 * Write a description of FindGeneSimpleAndTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna){
        // start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(startIndex != -1 && stopIndex !=-1){
            result = dna.substring(startIndex, stopIndex+3);
            return result;
        }else{
            return " NOT Found";
        }
        
    }
    
    public void test(){
        String dna = "ATCCTCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is "+ dna);
        String gen = findGeneSimple(dna);
        System.out.println("Gene is" + gen);
    }
}
