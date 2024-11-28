// you may add a constraint that lower bound must be less than upper bound
// this is just demo to test selection

import java.util.List;

public class Chemical {
    double proportion ;
    double upperBound;
    double lowerBound;
    double costPerUnit;
    

    public Chemical(double proportion, double uB, double lB, double cost) {
        this.proportion = proportion;
        this.upperBound = uB;
        this.lowerBound = lB;
        this.costPerUnit = cost;
    }
    public Chemical()
    {
        this.upperBound = 0;
        this.lowerBound = 0;
        this.costPerUnit = 0;
    }
    public void printChemical() {
        System.out.println("Proportions: " + proportion + "Range: [" + upperBound + " , " + lowerBound + "] Cost: " + costPerUnit);
    }

    public double getProportion() {
        return proportion;
    }
    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

}