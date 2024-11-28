
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

        while (noTstCases-- != 0) {

            for (int i = 0; i < testData.size(); i++) {

                // for each data set
                // 1- create the random chromosomes
                List<Chemical> chemicals = testData.get(i).chemicals;
                List<Chromosome> chroms = RandomGenerator.getRandStartGen(3, chemicals);

                for (Chromosome chromosome : chroms) {
                    List<Chemical> t = chromosome.getGenes();

                    for (Chemical te : t) {
                        System.out.print(te.proportion + " ");
                    }
                    System.out.println();

                    System.out.println("cost: " + chromosome.getTotalCost());

                    System.out.println();
                }

                CorrectChromosome scaleing = new CorrectChromosome(testData.get(i).propLimit);

                List<Chromosome> list = new ArrayList<>();

                for (Chromosome chromosome : chroms) {
                    Chromosome nChrom = scaleing.scaleChromosome(chromosome);
                    list.add(nChrom);
                }

                for (Chromosome chromosome : list) {
                   
                    List<Chemical> t = chromosome.getGenes();

                    for (Chemical te : t) {
                        System.out.print(te.proportion + " ");
                    }
                    System.out.println();

                    System.out.println("cost: " + chromosome.getTotalCost());

                    System.out.println();
                }
                // divide the population into best and not best
                Selection selection = new Selection();
                selection.divideinitialPop(chroms);
                List<Chromosome> best = selection.best;
                List<Chromosome> notBest = selection.notbest;
                
                // pass the not best to the selection 
                selection.tournamentSelection();
                List<Chromosome> afterSelection = selection.afterSelection;

                // now go to cross over stage
                

            }
        }
    }
}
