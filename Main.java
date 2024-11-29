
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
                List<Chromosome> chroms = RandomGenerator.getRandStartGen(5, chemicals);
                
                CorrectChromosome scaleing = new CorrectChromosome(testData.get(i).propLimit);

                List<Chromosome> list = new ArrayList<>();

                for (Chromosome chromosome : chroms) {
                    chromosome = scaleing.scaleChromosome(chromosome);
                    
                }
                
                System.out.println("chromosomes of initial popualtion");
                for (Chromosome chromosome : chroms) {
                    chromosome.printChrom();
                }
                // divide the population into best and not best
                Selection selection = new Selection();
                selection.divideinitialPop(chroms);
                List<Chromosome> best = selection.best;
                List<Chromosome> notBest = selection.notbest;
                System.out.println("chromosomes of best");
                for (Chromosome chromosome : best) {
                    chromosome.printChrom();
                }
                System.out.println("chromosomes of notbest");
                for (Chromosome chromosome : notBest) {
                    chromosome.printChrom();
                }
                System.out.println("\nChromosomes before selection: ");
                for(Chromosome c : notBest)
                {
                    c.printChrom();
                    System.out.println("");
                }
                // pass the not best to the selection 
                selection.tournamentSelection();
                List<Chromosome> afterSelection = selection.afterSelection;
                System.out.println("\n\nChromosomes after selection: ");
                for(Chromosome c : afterSelection)
                {
                    c.printChrom();
                    System.out.println("");
                }
                // now go to cross over stage
                Crossover crossover = new Crossover(afterSelection);
                System.out.println("\n\nChromosomes before crossover: ");
                for(Chromosome c : crossover.beforeCrossover)
                {
                    c.printChrom();
                    System.out.println("");
                }
                crossover.perfromCrossover();
                // check if the results violates any constraint scale it 
                List<Chromosome> afterScaling = new ArrayList<>();
                for (Chromosome chromosome : crossover.afterCrossover) {
                    Chromosome nChrom = scaleing.scaleChromosome(chromosome);
                    afterScaling.add(nChrom);
                }
                crossover.afterCrossover = afterScaling;
                System.out.println("Chromosomes after cross over: ");
                for(Chromosome c : crossover.afterCrossover)
                {
                    c.printChrom();
                    System.out.println("");
                }
                //now go to mutation stage  work on aftercrossover 
                

            }
        }
    }
}
