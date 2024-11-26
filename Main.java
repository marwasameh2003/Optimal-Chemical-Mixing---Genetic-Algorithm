import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // just a demo to test tournament selection
        // still didn't divide the initial population to K and pop-K (best)
        System.out.println("Testing tournament selection");
        List<Chromosome> chromosomes = new ArrayList<Chromosome>(3);
        chromosomes.add(new Chromosome(10, 20, 5, 8.5, 0.5));
        chromosomes.add(new Chromosome(11, 20, 5, 8.5, 0.4));
        chromosomes.add(new Chromosome(12, 20, 5, 8.5, 0.9));
        chromosomes.add(new Chromosome(13, 20, 5, 8.5, 0.32));
        chromosomes.add(new Chromosome(14, 20, 5, 8.5, 0.62));
        Selection selection = new Selection(chromosomes);
        selection.tournamentSelection();
        selection.printSelectedChromes();

    }
}
