import java.util.List;

public class CorrectChromosome {
    
    private Chromosome chrom;
    private double propLmt;

    public CorrectChromosome(double targetProp) {
        this.propLmt = targetProp;
    }

    private boolean isFeasible(){
    boolean isFeasible = true;
        
        for (Chemical gene : chrom.genes) {
            Double lBound = gene.lowerBound;
            Double uBound = gene.upperBound;

            if ((gene.proportion < lBound || gene.proportion > uBound) || chrom.getTotalProp() != propLmt ) {
                isFeasible = false;                
            }
        }
        return isFeasible;
    }

    public Chromosome scaleChromosome(Chromosome c){
        this.chrom = c;
        int n = c.genes.size();
        
        while (!isFeasible()) {
            List<Chemical> curGenes = chrom.getGenes();

            if (chrom.getTotalProp() < propLmt) {
                // choose random index
                int rndIdx = (int) (Math.random() * n);
                Chemical gene = curGenes.get(rndIdx);

                double upperVal = Math.min( (gene.upperBound - gene.proportion), ( propLmt - chrom.getTotalProp()));
                double rndAdd =  Math.random() * upperVal;

                gene.proportion += rndAdd;
                gene.proportion = Math.ceil(gene.proportion * 100) / 100.0;
                curGenes.set(rndIdx, gene);
                chrom.setGenes(curGenes);

            }else if(chrom.getTotalProp() > propLmt){

                int rndIdx = (int) (Math.random() * n);
                Chemical gene = curGenes.get(rndIdx);

                double upperVal = Math.min( (gene.proportion - gene.lowerBound), (chrom.getTotalProp() - propLmt));
                double rndAdd =  Math.random() * upperVal; // choose rand number between 0 and min of the upper two

                gene.proportion -= rndAdd;
                // ceil the proprtion 
                gene.proportion = Math.ceil(gene.proportion * 100) / 100.0;

                curGenes.set(rndIdx, gene);
                chrom.setGenes(curGenes);
            }
            
        }

        return chrom;
    }

    
}
