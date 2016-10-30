import java.util.Random;
/**
 * Write a description of DiceRolling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiceRolling {
    public void simulate(int rolls){
        Random rand=new Random();
        //use 2-12 as the 2nd to 12th element
        int [] counts = new int [13];
        for (int i=0;i<rolls;i++){
            int d1=rand.nextInt(6)+1;
            int d2=rand.nextInt(6)+1;
            counts[d1+d2]+=1;
        };
        for(int k=2;k<counts.length;k++){
            System.out.println(k + "'s=\t" + counts[k] +"\t" +100.0*counts[k]/rolls+"\n");
        }
        
    };

}
