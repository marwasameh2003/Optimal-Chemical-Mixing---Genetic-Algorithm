
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // 1- read the input from the file 
        DataExtractor dExtractor = new DataExtractor();
        List<DataInput> testData = dExtractor.getData("input.txt");
        int noTstCases = dExtractor.numTestCases;
        
        while (noTstCases-- != 0 ) {
            
            for (int i = 0; i < testData.size(); i++) {

                //for each data set
                //1- create the random chromosomes
                List<Chemical> chemicals = testData.get(i).chemicals;
                List<Chromosome> chroms = RandomGenerator.getRandStartGen(3, chemicals);


                for (Chromosome chromosome : chroms) {
                    List<Chemical> t = chromosome.getGenes();

                    for (Chemical te : t) {
                        System.out.print(te.proportion + " ");
                    }
                    System.out.println();

                   
                    System.out.println("cost: "+ chromosome.getTotalCost());

                    System.out.println();
                }
    
    
            }
        }
        



        // just a demo to test tournament selection
        // still didn't divide the initial population to K and pop-K (best)
        // System.out.println("Testing tournament selection");
        // List<Chemical> chromosomes = new ArrayList<Chemical>(3);
        // chromosomes.add(new Chemical(new ArrayList<>(Arrays.asList(2.1, 9.0, 12.91, 8.1)), 20, 5, 8.5, 0.5));
        // chromosomes.add(new Chemical(new ArrayList<>(Arrays.asList(2.1, 9.0, 12.91, 8.1)), 20, 5, 8.5, 0.4));
        // chromosomes.add(new Chemical(new ArrayList<>(Arrays.asList(2.1, 9.0, 12.91, 8.1)), 20, 5, 8.5, 0.9));
        // chromosomes.add(new Chemical(new ArrayList<>(Arrays.asList(2.1, 9.0, 12.91, 8.1)), 20, 5, 8.5, 0.32));
        // chromosomes.add(new Chemical(new ArrayList<>(Arrays.asList(2.1, 9.0, 12.91, 8.1)), 20, 5, 8.5, 0.62));
        // Selection selection = new Selection(chromosomes);
        // selection.tournamentSelection();
        // selection.printSelectedChromes();

    }
}
