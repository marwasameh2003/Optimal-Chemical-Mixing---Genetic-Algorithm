import java.util.List;

public class CostFunction {
    

    public static Double calculateCost(Chromosome c){

        Double cost = 0.0;
        List<Chemical> genes = c.getGenes();
       

        for (int i = 0; i < genes.size(); i++) {
            double subCost = ( genes.get(i).proportion * genes.get(i).costPerUnit);
            cost += subCost;
        }
        
        return cost;
    }
}
