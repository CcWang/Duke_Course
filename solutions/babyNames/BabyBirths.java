import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.Map;
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyBirths {
    public void printNames(){
        FileResource fr=new FileResource();
        for(CSVRecord rec:fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <=100){
                 System.out.println("Name "+rec.get(0)+ " Gender " + rec.get(1)+" Number born "+rec.get(2));
            };
           
        };
    }
    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalM=0;
        int totalF=0;
        for(CSVRecord rec:fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths +=numBorn;
            if(rec.get(1).equals("F")){
                totalF+=numBorn;
            }else{
                totalM+=numBorn;
            };
        }
        System.out.println("Total Born: "+totalBirths+" Total Female: "+totalF+" Total Male: "+totalM);
    };
    public int getRank(int year, String name, String gender){
        FileResource fr=new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
       int nameBorn = 0;
        int rank=1;
       for(CSVRecord rec:fr.getCSVParser(false)){
           if(rec.get(1).equals(gender)){
             if(rec.get(0).equals(name)){
                nameBorn = Integer.parseInt(rec.get(2)); 
             }else{
                 if(Integer.parseInt(rec.get(2)) > nameBorn){
                    rank++;
                 }
             }
           };
       };
       if(nameBorn ==0){
           return -1;
        }else{
              System.out.println(nameBorn);
            return rank;
        }
      
       
    };
    
    public static String getName(int year, int rank, String gender){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        int count=0;
        for(CSVRecord rec:fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                count++;
                System.out.println(count+" "+rec.get(0));
                if(rank == count){
                    return rec.get(0);
                }
                    
                
            };
        };
        return "NO NAME";
    };
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year,name,gender);
        if(rank == -1){
            System.out.println("your name is not showing in file");
        }else{
            String newName = getName(newYear, rank, gender);
            System.out.println(name+ " born in "+year+" would be "+newName+" if born in "+ newYear);
        }
    };
    public void testTotalBirths(){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob2014.csv");
        totalBirths(fr);
    };
    public void testGetRank(int year, String name, String gender){
        int result = getRank(year,name,gender);
        if(result == -1){
            System.out.println("name cannot find in "+year);
        }else{
            System.out.println("Name of "+name +" ranking at "+ result+" in year "+year);
        }
    };
    public void testGetName(int year, int rank, String gender){
        String result = getName(year,rank,gender);
         System.out.println("Name of "+result +" ranking at "+ rank+" in year "+year);
    };
}
