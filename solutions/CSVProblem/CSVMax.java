import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow:parser){
            largestSoFar = getLargestOfTwo(currentRow,largestSoFar);  
        };
        return largestSoFar;
    };
    public CSVRecord hottestInManyDays(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;
        // select multi files
        for (File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            // get csvrecord for each selected file
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow,largestSoFar);
        };
        return largestSoFar;
    };
    // make code reuseable;
    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
        if(largestSoFar == null){
                largestSoFar = currentRow;
            }else{
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                if(largestTemp < currentTemp){
                    largestSoFar = currentRow;
                }
            };
        return largestSoFar;
    };
    public void testHottest(){
        FileResource fr = new FileResource();
        CSVParser parser=fr.getCSVParser();
        CSVRecord largest = hottestHourInFile(parser);
        System.out.println("hottest temperature was " + largest.get("TemperatureF")+" at "+ largest.get("TimeEST"));
    };
    
    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF")+" at "+ largest.get("DateUTC"));
        
    };
}
