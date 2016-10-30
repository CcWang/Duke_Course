import edu.duke.*;
/**
 * Write a description of commonWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class commonWords {
    //change common.txt words to an array
    public String[] getCommon(){
        FileResource resource = new FileResource("CommonWordsData/common.txt");
        String[] common = new String[20];
        int idx = 0;
        for(String s:resource.words()){
            common[idx]=s;
            idx+=1;
        }
        return common;
    };
    public int indexOf(String[] common, String word){
      for(int k=0;k<common.length;k++){
        if(common[k].equals(word)){
            return k;
        }
        
        
      };
      return -1;
    }
    public void countWords(FileResource resource, String[] common, int[] counts){
        for(String word:resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if(index !=-1){
                counts[index] +=1;
            };
        }
    };
    
    public void countShakespeare(){
        String[] plays={"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int i=0;i<plays.length;i++){
            FileResource resource=new FileResource("CommonWordsData/"+plays[i]);
            countWords(resource, common,counts);
            System.out.println("done with"+plays[i]);
        };
        for (int k=0;k<common.length;k++){
            System.out.println(common[k]+"\t"+counts[k]);
        };
    };
}
