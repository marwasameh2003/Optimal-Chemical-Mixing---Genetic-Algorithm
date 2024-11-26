import java.util.ArrayList;
import java.util.List;

public class Chromosome {
    List<Double> genes = new ArrayList<>();
    Double totalCost = 0.0;

    
    public List<Double> getGenes() {
        return genes;
    }
    public void setGenes(List<Double> genes) {
        this.genes = genes;
    }
    public Double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
