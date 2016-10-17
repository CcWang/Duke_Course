import edu.duke.*;
import org.apache.commons.csv.*;
// for files
import java.io.*;
/**
 * Write a description of CSVWeather here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVWeather {
    public static CSVRecord coldestHourInFile (CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRow:parser){
           coldestSoFar = compareTwoColdest(currentRow, coldestSoFar);
        };
        return coldestSoFar;
    };
    public static String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        String address = null;
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            };
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if(coldestTemp == -9999){
                coldestSoFar = coldestSoFar;
            }else if(coldestTemp > currentTemp){
                coldestSoFar = currentRow;
                address = String.valueOf(f);
            };
        };
        return address;
       
    };
    public static CSVRecord compareTwoColdest(CSVRecord currentRow, CSVRecord coldestSoFar){
            
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            };
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if(coldestTemp == -9999){
                coldestSoFar = coldestSoFar;
            }else if(coldestTemp > currentTemp){
                coldestSoFar = currentRow;
            };
           return coldestSoFar;
    };
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord result = coldestHourInFile(parser);
        System.out.println("The coldest temperatur F was "+ result.get("TemperatureF")+" at "+result.get("DateUTC"));
    };
    public void testFileWithColdestTemperature(){
        String coldestDay = fileWithColdestTemperature();
        FileResource fr = new FileResource(coldestDay);
        CSVParser parser = fr.getCSVParser();
        CSVRecord result = coldestHourInFile(parser);
        System.out.println("The coldest temperatur F was "+ result.get("TemperatureF")+" at "+result.get("DateUTC"));
    }
}
