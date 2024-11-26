import java.util.ArrayList;
import java.util.List;

// didn't evaluate just crossedover 
// didn't handle if less than 3 genes
public class Crossover {
    List<Chromosome> BeforeCrossover = new ArrayList<Chromosome>();
    List<Chromosome> AfterCrossover = new ArrayList<Chromosome>();
    double pc = 0.6;

    public Crossover(List<Chromosome> selectionResult) {
        this.BeforeCrossover = selectionResult;
    }

    public void performCrossover() {
        // step = 2 since we take each two consecutive chromosomes as parents
        for (int i = 0; i < BeforeCrossover.size() - 1; i += 2) {
            // first we should check whether we will perform crossover or not
            double probOfCross = Math.random();
            if (probOfCross < pc) {
                // perform crossover
                List<Chromosome> children = twoPointCrossover(BeforeCrossover.get(i), BeforeCrossover.get(i + 1));
                AfterCrossover.addAll(children);
            } else // if we don't perform crossover we take the parents as they are with no
                   // modification
            {
                AfterCrossover.add(BeforeCrossover.get(i));
                AfterCrossover.add(BeforeCrossover.get(i + 1));
            }
        }
    }

    public List<Chromosome> twoPointCrossover(Chromosome parent1, Chromosome parent2) {
        // since it is 2 point crossover so each chromosome is divided into 3 parts

        if (parent1.proportions.size() > 2 && parent2.proportions.size() > 2) // to be able to divide into three parts
        { // think of making it 1 point if just 2 genes
            // first get the cross points
            int p1Sz = parent1.proportions.size();
            int firstPoint1 = p1Sz / 3;
            int secPoint1 = p1Sz - (p1Sz / 3);

            int p2Sz = parent1.proportions.size();
            int firstPoint2 = p2Sz / 3;
            int secPoint2 = p2Sz - (p2Sz / 3);

            // now get the parts
            // Dividing parent 1
            List<Double> parent1part1 = new ArrayList<>();
            for (int i = 0; i < firstPoint1; i++)
                parent1part1.add(parent1.proportions.get(i));
            List<Double> parent1part2 = new ArrayList<>();
            for (int i = firstPoint1; i < secPoint1; i++)
                parent1part2.add(parent1.proportions.get(i));
            List<Double> parent1part3 = new ArrayList<>();
            for (int i = secPoint1; i < p1Sz; i++)
                parent1part3.add(parent1.proportions.get(i));

            List<Double> parent2part1 = new ArrayList<>();
            for (int i = 0; i < firstPoint2; i++)
                parent2part1.add(parent2.proportions.get(i));
            List<Double> parent2part2 = new ArrayList<>();
            for (int i = firstPoint2; i < secPoint2; i++)
                parent2part2.add(parent2.proportions.get(i));
            List<Double> parent2part3 = new ArrayList<>();
            for (int i = secPoint2; i < p2Sz; i++)
                parent2part3.add(parent2.proportions.get(i));

            // combine the parts to construct the children

            Chromosome child1 = new Chromosome();
            child1.proportions.addAll(parent1part1);
            child1.proportions.addAll(parent2part2);
            child1.proportions.addAll(parent1part3);

            Chromosome child2 = new Chromosome();
            child2.proportions.addAll(parent2part1);
            child2.proportions.addAll(parent1part2);
            child2.proportions.addAll(parent2part3);

            List<Chromosome> children = new ArrayList<>();
            children.add(child1);
            children.add(child2);
            return children;
        }
        return null;
    }

    public void printChromesAfterCrossover() {
        for (Chromosome c : AfterCrossover)
            c.printChromo();
    }
}
