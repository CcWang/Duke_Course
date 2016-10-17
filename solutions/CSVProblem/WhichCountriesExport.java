import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInetest){
    
    for(CSVRecord record:parser){
        String export = record.get("Exports");
        if(export.contains(exportOfInetest)){
            String country = record.get("Country");
            System.out.println(country);
        };
    };
   };
   public static String countryInfo(CSVParser parser, String country){
       for(CSVRecord c:parser){
           String name=c.get("Country");
           if(name.equals(country)){
           String exports = c.get("Exports");
           String values = c.get("Value (dollars)");
           String result = country +": "+exports+": "+values;
           return result;
            };
       };
      return "NOT FOUND";
   };
   
   public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
       
       for(CSVRecord c:parser){
       String items = c.get("Exports");
       if(items.contains(exportItem1) && items.contains(exportItem2)){
           String country = c.get("Country");
           System.out.println(country);
        }
       
       }
   };
   public void whoExportsCoffee(){
       FileResource fr= new FileResource();
       CSVParser parser = fr.getCSVParser();
       listExporters(parser,"coffee");
   };
   public void testCountryInfo(){
       FileResource fr= new FileResource();
       CSVParser parser = fr.getCSVParser();
       System.out.println(countryInfo(parser,"Germany"));
       System.out.println(countryInfo(parser,"China"));
   };
      public void testTwoProducts(){
       FileResource fr= new FileResource();
       CSVParser parser = fr.getCSVParser();
       listExportersTwoProducts(parser,"gold","diamonds");
   };
}
