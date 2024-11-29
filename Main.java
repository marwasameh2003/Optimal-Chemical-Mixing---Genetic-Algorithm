
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1- read the input from the file
        DataExtractor dExtractor = new DataExtractor();
        List<DataInput> testData = dExtractor.getData("input.txt");
        int noTstCases = dExtractor.numTestCases;
        int noIterations = 3;

        while (noTstCases-- != 0) {

            for (int i = 0; i < testData.size(); i++) {

                List<Chemical> chemicals = testData.get(i).chemicals;
                List<Chromosome> chroms = RandomGenerator.getRandStartGen(20, chemicals);

                CorrectChromosome scaleing = new CorrectChromosome(testData.get(i).propLimit);

                for (Chromosome chromosome : chroms) {
                    chromosome = scaleing.scaleChromosome(chromosome);
                }
                for (int j = 1; j <= noIterations; j++) {

                    // divide the population into best and not best
                    Selection selection = new Selection();
                    selection.divideinitialPop(chroms);
                    List<Chromosome> best = selection.best;
                    List<Chromosome> notBest = selection.notbest;

                    // pass the not best to the selection
                    selection.tournamentSelection();
                    List<Chromosome> afterSelection = selection.afterSelection;

                    // now go to cross over stage
                    Crossover crossover = new Crossover(afterSelection);

                    crossover.perfromCrossover();
                    // check if the results violates any constraint scale it
                    for (Chromosome chromosome : crossover.afterCrossover) {
                        chromosome= scaleing.scaleChromosome(chromosome);
                    }
                    
                    // now go to mutation stage work on aftercrossover
                    NonUniformMutation nonUniformMutation = new NonUniformMutation(crossover.afterCrossover, j,
                            noIterations);
                    nonUniformMutation.performMutation();
                    for (Chromosome chromosome : nonUniformMutation.afterMutation) {
                        chromosome  = scaleing.scaleChromosome(chromosome);
                    }
                    ElitismReplacement replacement = new ElitismReplacement(nonUniformMutation.afterMutation, best,
                            notBest);
                    chroms = replacement.ElitismResault();
                   
                    for (Chromosome chromosome : chroms) {
                        chromosome = scaleing.scaleChromosome(chromosome);
                       
                    }
                   
                    // System.out.println("Chromosomes after Replacement: ");
                    // int x = 0;
                    // for (Chromosome c : chroms) {
                    //     System.out.print(x++ + " ");
                    //     c.printChrom();
                    //     System.out.println("");
                    // }
                }
                // choose best , minimum cost
                Collections.sort(chroms, Comparator.comparingDouble(Chromosome::getTotalCost));
                System.out.println("Data Set : " + (i + 1));
                System.out.print("Chemical Proportion: ");
                chroms.get(0).printChrom();
                System.out.println("Cost : " + chroms.get(0).getTotalCost());

            }
        }
    }
}
