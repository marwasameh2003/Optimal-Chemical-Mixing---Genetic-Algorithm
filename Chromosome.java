// you may add a constraint that lower bound must be less than upper bound
// this is just demo to test selection
public class Chromosome {
    double value;
    double upperBound;
    double lowerBound;
    double costPerUnit;
    double fitness;

    public Chromosome(double value, double uB, double lB, double cost, double fitness) {
        this.value = value;
        this.upperBound = uB;
        this.lowerBound = lB;
        this.costPerUnit = cost;
        this.fitness = fitness;
    }

    public void printChromo() {
        System.out.println("Value: " + value + "Range: [" + upperBound + " , " + lowerBound + "] Cost: " + costPerUnit);
    }

}