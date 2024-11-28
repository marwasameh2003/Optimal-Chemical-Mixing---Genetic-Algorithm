import java.util.ArrayList;
import java.util.List;

public class Chromosome {
    List<Chemical> genes = new ArrayList<>();
    private double totalProp = 0.0;
    private Double totalCost = 0.0;


    public double getTotalProp() {
        double tProp = 0.0;

        for (Chemical chemical : genes) {
            tProp += chemical.proportion;
        }
        return tProp;
    }
    
    public void setTotalProp(double totalProp) {
        this.totalProp = totalProp;
    }
    public List<Chemical> getGenes() {
        return genes;
    }
    public void setGenes(List<Chemical> genes) {
        this.genes = genes;
    }
    public Double getTotalCost() {
        totalCost = CostFunction.calculateCost(this);
        return totalCost;
    }
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
