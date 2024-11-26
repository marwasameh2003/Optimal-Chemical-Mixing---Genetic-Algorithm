// you may add a constraint that lower bound must be less than upper bound
// this is just demo to test selection

import java.util.List;

public class Chemical {
    List<Double> proportions ;
    double upperBound;
    double lowerBound;
    double costPerUnit;
    double fitness;

    public Chemical(List<Double> proportions, double uB, double lB, double cost, double fitness) {
        this.proportions = proportions;
        this.upperBound = uB;
        this.lowerBound = lB;
        this.costPerUnit = cost;
        this.fitness = fitness;
    }
    public Chemical()
    {
        this.upperBound = 0;
        this.lowerBound = 0;
        this.costPerUnit = 0;
        this.fitness = 0;
    }
    public void printChromo() {
        System.out.println("Proportions: " + proportions + "Range: [" + upperBound + " , " + lowerBound + "] Cost: " + costPerUnit);
    }

}