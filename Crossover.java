import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class Crossover
{
    List<Chromosome> beforeCrossover = new ArrayList<>();
    List<Chromosome> afterCrossover = new ArrayList<>();
    double pc = 0.6; // the probability of performing crossover
    
    public Crossover(List<Chromosome> fromSelection)
    {
        beforeCrossover = fromSelection;
    }
    // perform crossover
    public void perfromCrossover()
    {
        // check whether the #chroms is odd or even
        if(beforeCrossover.size()% 2 !=0) 
        {
            //System.out.println("\nadded chrom to make it even");
            beforeCrossover.add(beforeCrossover.get(0));
        }
        // now take every consecutive 2 as parents 
        // check whether crossover will occur or the parents will be passed as they are to the next generation
        for(int i = 0 ; i<beforeCrossover.size()-1 ; i+=2)
        {

            double isCrossOver = Math.random();

            if(isCrossOver<=pc) // perform cross over
            {
                //System.out.println("\nperform crossover");
                List<Chromosome> children = twoPointCrossOver(beforeCrossover.get(i), beforeCrossover.get(i+1));
                for (var c : children) {
                    afterCrossover.add(c);
                }

            }
            else // no cross over
            {
               // System.out.println("\ndon't perform crossover");

                afterCrossover.add(beforeCrossover.get(i));
                afterCrossover.add(beforeCrossover.get(i+1));
            }
        }
    }

    public List<Chromosome> twoPointCrossOver(Chromosome p1 , Chromosome p2)
    {
        // if the size is more than or equal to 3 genes we will be able to perform 2 point cross over
        int p1Sz = p1.getGenes().size();
        int p2Sz = p2.getGenes().size();
        //System.out.println(p1Sz + " sizes " + p2Sz);
        List<Chromosome> children = new ArrayList<>();
        if(p1Sz >= 3 && p2Sz >= 3)
        {
            // now divide each parent into 3 parts
            // parent1 division
            int p1partsz = p1Sz/3;
            List<Chemical> p1part1 = new ArrayList<>();
            List<Chemical> p1part2 = new ArrayList<>();
            List<Chemical> p1part3 = new ArrayList<>();
            for(int i = 0 ; i< p1partsz ; i++)
            {
                p1part1.add(p1.getGenes().get(i));
            }
            for(int i = p1partsz ; i<p1partsz*2 ; i++)
            {
                p1part2.add(p1.getGenes().get(i));
            }
            for (int i = p1partsz*2; i < p1Sz; i++)
            {
                p1part3.add(p1.getGenes().get(i));    
            }
            //parent2 division
            int p2partsz = p2Sz/3;
            List<Chemical> p2part1 = new ArrayList<>();
            List<Chemical> p2part2 = new ArrayList<>();
            List<Chemical> p2part3 = new ArrayList<>();
            for(int i = 0 ; i< p2partsz ; i++)
            {
                p2part1.add(p2.getGenes().get(i));
            }
            for(int i = p2partsz ; i<p2partsz*2 ; i++)
            {
                p2part2.add(p2.getGenes().get(i));
            }
            for (int i = p2partsz*2; i < p2Sz; i++)
            {
                p2part3.add(p2.getGenes().get(i));    
            }
            //children construction
            List<Chemical> child1 = new ArrayList<Chemical>();
            child1.addAll(p1part1);
            child1.addAll(p2part2);
            child1.addAll(p1part3);

            List<Chemical> child2 = new ArrayList<Chemical>();
            child2.addAll(p2part1);
            child2.addAll(p1part2);
            child2.addAll(p2part3);
            // now encapsulate these chemicals into two children
            Chromosome c1 = new Chromosome();
            c1.setGenes(child1);
            c1.getTotalCost();
            c1.getTotalProp();

            Chromosome c2 = new Chromosome();
            c2.setGenes(child2);
            c2.getTotalCost();
            c2.getTotalProp();
            children.add(c1);
            children.add(c2);
        }
        return children;
    }

}
