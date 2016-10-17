import edu.duke.*;

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
 public static int findStopCodon(String dna, int startIdx, String stopStr){
     int currentIdx = dna.indexOf(stopStr, startIdx+3);
     while(currentIdx !=-1){
         if((currentIdx-startIdx)%3==0){
             return currentIdx;
         }else{
             currentIdx = dna.indexOf(stopStr,currentIdx+1);
         }
     }
     return -1;
 }
 
 public void testFindStopCodon(){
     String dna1="xxxyyyxxxhhh";
     String dna2="ATGxxxyyyaaaTAGuuuzzzTAAmmmlllTGAjjjddd";
     String dna3="ATGxxxyyaaaTAGuuuzzzTAAmmmlTGAjjjdd";
     System.out.println("Testing first dna "+dna1);
     System.out.println("dna1: "+findStopCodon(dna1,0,"ATG"));
     System.out.println("Testing first dna "+dna2);
     System.out.println("dna2 TAG index: "+findStopCodon(dna2,0,"TAG"));
     System.out.println("dna2 TAA: "+findStopCodon(dna2,0,"TAA"));
     System.out.println("dna2 TGA: "+findStopCodon(dna2,0,"TGA"));
     System.out.println("Testing first dna "+dna3);
     System.out.println("dna3 ATG index: "+findStopCodon(dna3,0,"TAG"));
     System.out.println("dna3 TAA: "+findStopCodon(dna3,0,"TAA"));
     System.out.println("dna3 TGA: "+findStopCodon(dna3,0,"TGA"));
 
 }
 
 public static String findGene(String dna, int where){
     int startIdx = dna.indexOf("atg", where);
     if(startIdx == -1){
         return "";
     }
     
     int taaIdx = findStopCodon(dna,startIdx,"taa");
     int tagIdx = findStopCodon(dna,startIdx,"tag");
     int tgaIdx = findStopCodon(dna,startIdx,"tga");
     int minIdx = 0;
     if(taaIdx == -1 ||(tagIdx !=-1 && tagIdx <taaIdx)){
         minIdx = tagIdx;
     }else {
         minIdx = taaIdx;
     }
     
     if(minIdx ==-1 || (tgaIdx !=-1 && tgaIdx<minIdx)){
        minIdx = tgaIdx;
        }
     if(minIdx ==-1){
         return "";
     }else{
        return dna.substring(startIdx,minIdx+3);
        }
     
 }
 public void printTest(String dna){
     System.out.println("dna is: "+dna);
     String result = findGene(dna,0);
     if(result.isEmpty()){
         System.out.println(result+"is empty");
        }else{
            System.out.println("dna gene found is "+result);
        }
 }
 public void testFindGene(){
     String dna1="xxxyyyxxxhhh";
     String dna2="xxxATGyyyxxxTAGhhh";
     String dna3="ATGxxxyyyaaaTAAuuuzzzTAGmmmlllTGAjjjddd";
     String dna4="ATGxxxyyaaaTAGuuuzzzTAAmmmlTGAjjjdd";
     String dna5="ATGxxxyyaaaTAGuuuzzzTAAmmmTGAjjjdd";
     printTest(dna1);
     printTest(dna2);
     printTest(dna3);
     printTest(dna4);
     printTest(dna5);
 }
 public void printAllGenes(String dna){
    int startIdx = 0;
    while(true){
       String currentGene=findGene(dna,startIdx);
       if(currentGene.isEmpty()){
           break;
        }
       System.out.println(currentGene);
       startIdx = dna.indexOf(currentGene,startIdx)+currentGene.length();
    }
 }
 
  public static StorageResource getAllGenes(String dna){
      int startIdx = 0;
      
    StorageResource geneList = new StorageResource();
    while(true){
       String currentGene=findGene(dna,startIdx);
       if(currentGene.isEmpty()){
           break;
        }
       geneList.add(currentGene);
    
       startIdx = dna.indexOf(currentGene,startIdx)+currentGene.length();
    }
    return geneList;
 }
 
 public void testPrintAll(){
    String dna3="ATGxxxyyyaaaTAAATGzzzTAGmmmATGlllTGAjjjddd";
    String dna1 = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
    String dna2 ="";
    System.out.println("testing dna: "+dna3);
    printAllGenes(dna3);
     System.out.println("testing dna: "+dna1);
    printAllGenes(dna1);
     System.out.println("testing dna: "+dna2);
    printAllGenes(dna2);
 }
  
 public void testetAllGenes(){
    String dna3="ATGxxxyyyaaaTAAATGzzzTAGmmmATGlllTGAjjjddd";
    String dna1 = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
    String dna2 ="";
     URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
     String dna = fr.asString();
    System.out.println("testing dna3: "+dna);
    StorageResource list = getAllGenes(dna);
    for(String g:list.data()){
        System.out.println(g);
    }
    //System.out.println("testing dna1: "+dna1);
    //System.out.println("testing dna2: "+dna2);
    
    
 }
}
