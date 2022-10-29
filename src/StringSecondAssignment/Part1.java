package StringSecondAssignment;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int endCodon = dna.toUpperCase().indexOf(stopCodon,startIndex);
            while(endCodon != -1){
                if((endCodon - startIndex) %3 == 0){
                    return endCodon;
                } else {
                    endCodon = dna.indexOf(stopCodon,endCodon + stopCodon.length());
                }
            }

        return -1;
    }


    public String findGene(String dna, int where){
         int begCodon = dna.toUpperCase().indexOf("ATG", where);
         if(begCodon == -1){
             return "";
         }
         int taaCodon = findStopCodon(dna,begCodon,"TAA");
         int tagCodon = findStopCodon(dna,begCodon,"TAG");
         int tgaCodon = findStopCodon(dna,begCodon,"TGA");
         int minCodon = 0;
         if(taaCodon == -1 || (tagCodon != -1 && tagCodon < taaCodon)){
             minCodon = tagCodon;
         } else {
             minCodon = taaCodon;
         }
         if (minCodon == -1 || (tgaCodon != -1 && tgaCodon < minCodon)){
             minCodon = tgaCodon;
         }
         if (minCodon == -1){
             return "";
         }
        return dna.substring(begCodon,minCodon + 3);
    }


    public void printAllGenes(String dna){
        int start = 0;
        while (true){
            String genes = findGene(dna,start);
            if (genes.isEmpty()){
                break;
            }
            System.out.println(genes);
            start = dna.indexOf(genes,start) + genes.length();
        }
    }

    public void testFindGene(){
        String dna2 = "atggtaggatgaaatgtaa";
        printAllGenes(dna2);

    }

}

class MainPart1{
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testFindGene();
    }
}
