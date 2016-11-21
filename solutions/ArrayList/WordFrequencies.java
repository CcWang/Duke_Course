import edu.duke.*;
import java.util.ArrayList;
/*ß
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public void WordFrenquencies(){
        myFreqs = new ArrayList<Integer>();
        myWords = new ArrayList<String>();
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        for (String s : resource.words()){
            s=s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index ==-1){
                myWords.add(s);
                myFreqs.add(1);
            }else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }
    }
    
    public void tester(){
        findUnique();
       for(int k=0;k<myWords.size();k++){
           System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
        }
    }
}
