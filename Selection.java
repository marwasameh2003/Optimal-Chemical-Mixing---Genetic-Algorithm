// Goal: In selection, I need to determine which chromosomes will be together in crossover
// Input: K chromosomes --note that K is not the whole size of the population
// output: K chromosomes where each two are the parents in cross over 
// Selection Algorithm: Tournament Selection
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Selection
{
    // first functionallity is dividing the initial population into best and notbest 
    List<Chromosome> notbest = new ArrayList<>();
    List<Chromosome> best = new ArrayList<>();
    List<Chromosome> beforeSelection = new ArrayList<>();
    List<Chromosome> afterSelection = new ArrayList<>();
    public void divideinitialPop(List<Chromosome> totalPop)
    {
        Collections.sort(totalPop, Comparator.comparingDouble(Chromosome::getTotalCost));
        int bestSz = (int)(totalPop.size()*0.3);
        for(int i = 0 ; i<bestSz;i++)
        {
            best.add(totalPop.get(i));
        }
        for (int i = bestSz; i <totalPop.size() ; i++)
        {
            notbest.add(totalPop.get(i));    
        }
        beforeSelection = notbest ; //since selection is applied to the notbest set of population 

    }
    // second functionallity is selecting from the notbest using the tournament selection 
    public void tournamentSelection()
    {
        // select two individuals randomly
        // check the best of those two 
        // add the best to the selected parents
        // add this until you find K parents

        //not sure of the sort whether required or not
        Collections.sort(beforeSelection, (c1, c2) -> Double.compare(c1.getTotalCost(), c2.getTotalCost()));
        Random random = new Random();
        while(beforeSelection.size()> afterSelection.size())
        {
            int index1 = random.nextInt(beforeSelection.size()-1);
            int index2 = random.nextInt(beforeSelection.size()-1);

            Chromosome c1 = beforeSelection.get(index1);
            Chromosome c2 = beforeSelection.get(index2);

            if(c1.getTotalCost() > c2.getTotalCost()) afterSelection.add(c1); else afterSelection.add(c2);
        }
    }

}




//     public void printSelectedChromes()
//     {
//         for(Chemical c : AfterSelection)
//         c.printChromo();
//     }

