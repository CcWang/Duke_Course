
/**
 * Write a description of commonWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class commonWords {
    
    
    
    public void countShakespeare(){
        String[] plays={"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        
        String common = getCommon();
        int[] counts = new int[common.length];
        for(int i=0;i<plays.length;i++){
            FileResource resource=new FileResource("CommonWordsData/"+plays[k]);
            countWords(resource, common,counts);
            System.out.println("done with"+plays[k]);
        };
        for (int k=0;k<common.length;k++){
            System.out.println(common[k]+"\t"+counts[k]);
        };
    };
}
