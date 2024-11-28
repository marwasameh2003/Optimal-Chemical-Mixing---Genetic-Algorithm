public class CorrectChromosome {
    
    private Chromosome chrom;
    private double targetProp;

    private boolean isFeasible(){
    boolean isFeasible = true;

        for (Chemical gene : chrom.genes) {
            Double lBound = gene.lowerBound;
            Double uBound = gene.upperBound;

            if ((gene.proportion < lBound || gene.proportion > uBound) && chrom.getTotalProp() != targetProp ) {
                isFeasible = false;
                break;
            }
        }
        return isFeasible;
    }

    public Chromosome scaleChromosome(Chromosome c, double targetProp){
        this.chrom = c;
        this.targetProp = targetProp;

        while (!isFeasible()) {
            
            for (Chemical gene : chrom.genes) {
                Double newProp = scaleGene(gene, chrom.getTotalProp());
                gene.setProportion(newProp);
            }
        }

        return chrom;
    }

    private Double scaleGene(Chemical gene, double total){

        double newProp = 0.0;
        if( gene.proportion < gene.lowerBound){

            newProp = gene.lowerBound;

        }else if( gene.proportion > gene.upperBound){

            newProp = gene.upperBound;

        }else{
            newProp = (gene.proportion/total) * 100;
        }
        

        return newProp;
    }
}
