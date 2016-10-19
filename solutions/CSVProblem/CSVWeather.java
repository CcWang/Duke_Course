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
           coldestSoFar = compareTwo(currentRow, coldestSoFar,"TemperatureF");
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
           if(coldestTemp > currentTemp && currentTemp > -9999){
                coldestSoFar = currentRow;
                address = String.valueOf(f);
                //address = f.getName();
            };
        };
        return address;
       
    };
    public static CSVRecord compareTwo(CSVRecord currentRow, CSVRecord coldestSoFar, String compare){
            
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            };
            String current = currentRow.get(compare);
            
            if(current.equals("N/A")){
              coldestSoFar = coldestSoFar;  
            }else{
              double currentTemp = Double.parseDouble(current);
              double coldestTemp = Double.parseDouble(coldestSoFar.get(compare));
              if(coldestTemp > currentTemp && currentTemp >-9999){
                  coldestSoFar = currentRow;
              };
                
            };
            
           return coldestSoFar;
    };
    
    public static CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for(CSVRecord currentRow:parser){
            lowestSoFar = compareTwo(currentRow,lowestSoFar,"Humidity");
        };
        return lowestSoFar;
    };
    
    public static CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        for(File f:dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = compareTwo(currentRow, lowestSoFar,"Humidity");
           
        };
       return lowestSoFar;
    };
    public static double averageTemperatureInFile(CSVParser parser){
        double totalTemp=0.00;
        double count = 0;
        for(CSVRecord currentRow:parser){
            String temp = currentRow.get("TemperatureF");
            totalTemp = totalTemp+Double.parseDouble(temp);
            count++;
        };
        return totalTemp/count;
    };
    public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemp=0;
        double count=0;
        for(CSVRecord row:parser){
            double currentTemp = Double.parseDouble(row.get("TemperatureF"));
            int currentHumidity = Integer.parseInt(row.get("Humidity"));
            if(currentHumidity >= value){
                totalTemp+=currentTemp;
                count++;
            };
        };
        if(count==0){
            return 0;
        }else{
            return totalTemp/count;
        }
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
    };
    public void testHumidity(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord result = lowestHumidityInFile(parser);
        System.out.println("The lowest Humidity was "+ result.get("Humidity")+" at "+result.get("DateUTC"));
    };
    
    public void testLowestHumidityInManyFiles(){
        CSVRecord result = lowestHumidityInManyFiles();
       System.out.println("The lowest Humidity was "+ result.get("Humidity")+" at "+result.get("DateUTC")); 
    };
    
    public void testAverageTemp(){
        FileResource fr = new FileResource();
        CSVParser parser=fr.getCSVParser();
        double result = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+result);
    };
        public void testAvgTempWithHighHum(int value){
        FileResource fr = new FileResource();
        CSVParser parser=fr.getCSVParser();
        double result = averageTemperatureWithHighHumidityInFile(parser,value);
        if(result == 0){
            System.out.println("No temperatures with that "+value+" humidity");
        }else{
            System.out.println("Average Temp whe "+value+ " Humidity is "+result);
        };
       
    };

}
