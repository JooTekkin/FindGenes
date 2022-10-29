package StringSecondAssignment;

public class Part3 extends Part1 {

    public int countGenes(String dna){
        int nums = 0;
        int start = 0;
        while (true){
            String genes = findGene(dna,start);
            if (genes.isEmpty()){
                break;
            }
            nums++;
            start = dna.indexOf(genes,start) + genes.length();
        }
        return nums;
    }

    public void testCountGenes(){
        int numsGenes = countGenes("ATGTAAGATGCCCTAGT");
        printAllGenes("ATGTAAGATGCCCTAGT");
        System.out.println(numsGenes);
    }
}
class MainPart3{
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testCountGenes();

    }
}