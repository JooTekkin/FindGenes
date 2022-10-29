package StringFirstAssignment;

public class Part1 {

    //this method to find the gene
    public String findSimpleGene(String dna){
        int startGene = dna.indexOf("ATG");
        if(startGene == -1){
            return "";
        }
        int stopGene = dna.indexOf("TAA");
        if((stopGene - startGene) % 3 == 0){
            return dna.substring(startGene,stopGene + 3);
        } else {
            return "";
        }
    }

    public void testSimpleGene(){
        String dna1 = "ATGCGGAGTTAA";
        String dna2 = "ATGCGAGTTAA";
        String dna3 = "CGGAGTTAA";
        String dna4 = "ATGCGGAGT";
        String dna5 = "CGGAGT";

        String gene = findSimpleGene(dna2);
        System.out.println(gene);
    }
}

class MainPart1{
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testSimpleGene();
    }
}