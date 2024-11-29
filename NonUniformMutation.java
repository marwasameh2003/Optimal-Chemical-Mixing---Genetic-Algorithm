import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NonUniformMutation {
    List<Chromosome> chromosomes;
    List<Chromosome> afterMutation;
    double currentGeneration;
    double maxGenerations;
    double dependencyFactor = 3.0;
    Random random = new Random();


    public NonUniformMutation(List<Chromosome> chromosomes, Integer currentGeneration, Integer maxGenerations) {
        this.chromosomes = chromosomes;
        this.currentGeneration = currentGeneration;
        this.maxGenerations = maxGenerations;
    }

    public void performMutation(){
        for (int i = 0; i < chromosomes.size(); i++) {
            for (int j = 0; j < chromosomes.get(i).genes.size(); j++) {
                double ri = random.nextDouble();
                double y;
                if(ri <= 0.5){
                    y = chromosomes.get(i).genes.get(j).proportion - chromosomes.get(i).genes.get(j).lowerBound;
                }else{
                    y = chromosomes.get(i).genes.get(j).upperBound - chromosomes.get(i).genes.get(j).proportion;
                }
                double r = random.nextDouble();
                y = y * (1 - Math.pow(r, Math.pow((1 - currentGeneration / maxGenerations), dependencyFactor)));
                if(ri <= 0.5){
                    chromosomes.get(i).genes.get(j).proportion -= y;
                }else{
                    chromosomes.get(i).genes.get(j).proportion += y;
                }
            }
        }
        afterMutation = chromosomes;
    }

}
