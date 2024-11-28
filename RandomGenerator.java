//generate :
//population size
//pc
//pm
//first generation solutions
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    
    static Random random = new Random();
    static int[] popsizes = {50,60,80,100,120,140,150,180,200,220,250,280,300,320,350,380,400,420,450,480,500};

    public static int getRandPopSize()
    {
        int randomNumber = random.nextInt(21);
        return popsizes[randomNumber];
    }
    
    public double getRandPm()
    {
        return Math.random();
    }
    public static List<Chromosome> getRandStartGen(int popSize, List<Chemical> chemcs)
    {
        List<Chromosome> chromosomes = new ArrayList<>();
        
        for (int i = 0; i < popSize; i++) {

            // create each chromosome
            Chromosome c = new Chromosome();
            int geneSz = chemcs.size();

            // genes list
            List<Chemical> genes = new ArrayList<>();


            for (int j = 0; j < geneSz; j++) {
                Double lBound = chemcs.get(j).lowerBound;
                Double uBound = chemcs.get(j).upperBound;
                // gene assigned to num between lower and upper bound
                Double prop = Math.random() * (uBound - lBound) + lBound;
                Chemical cTemp = new Chemical(prop, uBound, lBound,chemcs.get(j).costPerUnit );

                
                genes.add(cTemp);
            }
            c.setGenes(genes);
            chromosomes.add(c); 

        }
        return chromosomes;
    }

    

    public static double randomNum(){

        return Math.random();
    }

    public static int randNumR1(int l){
        return (int) (Math.random() * (1 - (l-1) + 1)) + 1;
    }
}
