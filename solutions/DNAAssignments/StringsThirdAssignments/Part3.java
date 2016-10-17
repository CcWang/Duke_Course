import edu.duke.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
 };
 public static String findGene(String dna, int where){
     int startIdx = dna.indexOf("ATG", where);
     if(startIdx == -1){
         return "";
     }
     
     int taaIdx = findStopCodon(dna,startIdx,"TGA");
     int tagIdx = findStopCodon(dna,startIdx,"TAG");
     int tgaIdx = findStopCodon(dna,startIdx,"TGA");
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
     
 };
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
 };
 public void processGenes(StorageResource sr){
    int count =0;
    int longerThan60=0;
    int cgRatio=0;
    int longest=0;
    int timesCTG=0;
    for(String s:sr.data()){
        System.out.println(s);
        count++;
        if(s.length()>60){
        longerThan60++;
        };
        if(s.indexOf("CTG") !=-1){
            timesCTG++;
        }
        double cgCount=0.0;
        for(int i=0; i<s.length();i++){
            
            if(String.valueOf(s.charAt(i)).equals("C") || String.valueOf(s.charAt(i)).equals("G")){
                cgCount++;
            }
        }
        double length=s.length();
        if(cgCount/length > 0.35){
            cgRatio++;
        }
        if(longest < s.length()){
            longest = s.length();
        }
    };
    System.out.println("Numbers of Genes: "+count);
    System.out.println("Numbers of Genes is Longer than 60: "+longerThan60);
    System.out.println("cgRation is greater than 0.35 "+ cgRatio);
    System.out.println("The longest genes is "+longest);
    System.out.println("CTG "+timesCTG);
    }; 
 public void testProcessGenes(){
     URLResource fr = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
     String dna = fr.asString();
     StorageResource gList = getAllGenes(dna);
     processGenes(gList);
    }  
    
}
