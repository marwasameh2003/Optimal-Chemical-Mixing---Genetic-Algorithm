import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataExtractor {
    public static int numTestCases = 0 ;
        
        
            public static List<DataInput> getData(String filePath) {
                List<DataInput> data = new ArrayList<>();
        
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    //  (number of test cases)
                    String noTsts  = br.readLine();
                    numTestCases = Integer.parseInt(noTsts);
                
                // Read each test case
                for (int i = 0; i < numTestCases; i++) {
                DataInput currentData = new DataInput();

                // Read no of chemicals and total sum 
                String line = br.readLine();
                String[] parts = line.split(" ");
                if (line != null) {
                    currentData.noChemicals = Integer.parseInt(parts[0]);
                    currentData.propLimit = Double.parseDouble(parts[1]);
                }
               
                
               List<Chemical> ch = new ArrayList<>();
               String line2 = br.readLine();
               String[] bounds = line2.split(" ");

               // add the lower and upper bound to each chrom
                for (int j = 0; j < bounds.length; j+=2) {
                    Chemical c = new Chemical();
                    c.lowerBound = Double.parseDouble(bounds[j]);
                    c.upperBound = Double.parseDouble(bounds[j+1]);
                    ch.add(c);
                }
                
               String line3 = br.readLine();
               String[] cost = line3.split(" ");
               for (int j = 0; j < currentData.noChemicals; j++) {
                    ch.get(j).costPerUnit = Double.parseDouble(cost[j]);
                
               }
               // add the chemicals to the data input
               currentData.chemicals = ch;
                // Add the populated Data object to the list
                data.add(currentData);
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("The file does not contain a valid integer: " + e.getMessage());
        }

        return data;
    }

    
}
