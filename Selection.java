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
    List<Chemical> BeforeSelection = new ArrayList<Chemical>() ;
    List<Chemical> AfterSelection = new ArrayList<Chemical>() ; 
    public Selection(List<Chemical> chromosomes)
    {
        this.BeforeSelection = chromosomes;
    }

    public void tournamentSelection()
    {
        // select two individuals randomly
        // check the best of those two 
        // add the best to the selected parents
        // add this until you find K parents

        //not sure of the sort whether required or not
        Collections.sort(BeforeSelection, (c1, c2) -> Double.compare(c1.fitness, c2.fitness));
        Random random = new Random();
        while(BeforeSelection.size()> AfterSelection.size())
        {
            int index1 = random.nextInt(BeforeSelection.size()-1);
            int index2 = random.nextInt(BeforeSelection.size()-1);

            Chemical c1 = BeforeSelection.get(index1);
            Chemical c2 = BeforeSelection.get(index2);

            if(c1.fitness > c2.fitness) AfterSelection.add(c1); else AfterSelection.add(c2);
        }
    }
    public void printSelectedChromes()
    {
        for(Chemical c : AfterSelection)
        c.printChromo();
    }
}

