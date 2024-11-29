import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// 1- concate best + offspring 
// 2- sort take the first k chroms  --> new best
// 3- take the rest to the offspring
// 4- new offSpring = SSGa between the replaced offspring , notBest (70, 30)
// 5- result = newOffsping + best


public class ElitismReplacement {
    List<Chromosome> offspring;
    List<Chromosome> best;
    List<Chromosome> notBest;
    List<Chromosome> newBest = new ArrayList<>();
    List<Chromosome> newOffSpring = new ArrayList<>();

    public ElitismReplacement(List<Chromosome> offspring , List<Chromosome> best, List<Chromosome> notBest)
    {
        this.best=best;
        this.offspring=offspring; // best+offspring -> concatenate --> new best 1/2size
        this.notBest=notBest;
    }

    public List<Chromosome> ElitismResault(){
        List<Chromosome> allChroms = new ArrayList<>(best);
        allChroms.addAll(offspring);


        // sort 
        Collections.sort(allChroms, Comparator.comparingDouble(Chromosome::getTotalCost));
        int k = best.size();

        // fill in the newBest chromes 
        for(int i = 0 ; i < k ; i++)
        {
            newBest.add(allChroms.get(i));
        }


        int restSize = offspring.size();

        // replace the offSpring
        offspring = new ArrayList<Chromosome>();
        for(int i = k; i < allChroms.size(); i++)
        {
            offspring.add(allChroms.get(i));
        }



        Elitism(offspring , notBest, allChroms.size());
        List<Chromosome> result = new ArrayList<Chromosome>(newOffSpring);

        result.addAll(newBest);
        return result;
    }

    public void Elitism(List<Chromosome> offlist, List<Chromosome> notBestList, int size) {
        Collections.sort(notBestList, Comparator.comparingDouble(Chromosome::getTotalCost));
        int notBestProp = (int) Math.ceil((double) (0.3 * notBestList.size()));

        Collections.sort(notBestList, Comparator.comparingDouble(Chromosome::getTotalCost));
        int offSpringProp = notBestList.size() - notBestProp;

        for (int i = 0; i < notBestProp; i++) {
            newOffSpring.add(notBestList.get(i));
        }
        for (int i = 0; i < offSpringProp; i++) {
            newOffSpring.add(offlist.get(i));
        }

    }



}