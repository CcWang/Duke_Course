import edu.duke.*;

/**
 * Write a description of FindingWebLinks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindingWebLinks {
    public void printURL(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        int i=0;
        for(String l:ur.lines()){
            if(l.indexOf("youtube.com") !=-1){
                int startIndex = l.indexOf("\"");
                int stopIndex = l.indexOf("\"",startIndex+1);
                System.out.println(l.substring(startIndex+1,stopIndex));
                
                i++;
            }
        }
        System.out.println(i);
    }
}
