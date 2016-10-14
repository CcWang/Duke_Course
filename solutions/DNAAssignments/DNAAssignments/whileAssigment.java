import edu.duke.*;
/**
 * Write a description of whileAssigment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class whileAssigment {
    public static String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex ==-1){
            return " ";
        }
        int currentIndex = dna.indexOf("TAA", startIndex+3);
        while(currentIndex !=1){
            if ((currentIndex-startIndex)%3 ==0){
                return dna.substring(startIndex,currentIndex+3);
            }else {
                currentIndex = dna.indexOf("TAA",currentIndex+3);
            }
        }
        return " ";
    }
    
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currentIndex = dnaStr.indexOf(stopCodon, startIndex+3);
        while(currentIndex !=-1){
            if((currentIndex-startIndex)%3==0){
                return currentIndex;
            }else{
                currentIndex = dnaStr.indexOf(stopCodon, currentIndex+1);
            }
        }
        return -1;
    }
    public String findGenes(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex ==-1){
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex= 0;
        if(taaIndex == -1 || (tgaIndex !=-1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }else{
            minIndex = taaIndex;
        }
        
        if(minIndex ==-1 || (tgaIndex !=-1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        
        if(minIndex ==-1){
            return "";
        }
        
        return dna.substring(startIndex,minIndex+3);
        
    }
    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
            String currentGene = findGenes(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene,startIndex)+currentGene.length();
        }
    }
   public void testFindStop(){
    String dna ="xxxATGzzzTAAxxyyyzzzTAAxx";
    System.out.println(findGenes(dna,0));
    }
    
    public void testFIndGene(){
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGenes(dna,0);
        if(!gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("tests finished");
    }
    public void testOn(String dna){
        System.out.println("Testing printAllGenes on "+ dna);
        //printAllGenes(dna);
        StorageResource genes = getAllGenes(dna);
        for(String s:genes.data()){
            System.out.println(s);
        }
    }
    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    
    public StorageResource getAllGenes(String dna){
       //create an empty StorageResource
       StorageResource geneList = new StorageResource();
       int startIndex = 0;
        while(true){
            String currentGene = findGenes(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene,startIndex)+currentGene.length();
        }
        return geneList;
    }
    
    
}
