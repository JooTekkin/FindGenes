package StringFirstAssignment;

public class Part2{

    //this method to find the gene
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        boolean cases = checkCase(dna);
        if (cases){
            return getLowerCaseString(dna, startCodon, stopCodon);
        } else {
            return getUpperCaseString(dna, startCodon, stopCodon);
        }
    }

    //this method return dna string in uppercase
    private static String getUpperCaseString(String dna, String startCodon, String stopCodon) {
        int startGene = dna.toUpperCase().indexOf(startCodon.toUpperCase());
        if(startGene == -1){
            return "";
        }
        int stopGene = dna.toUpperCase().indexOf(stopCodon.toUpperCase());
        if((stopGene - startGene) % 3 == 0){
            return dna.substring(startGene, stopGene + 3);
        } else {
            return "";
        }
    }

    //this method return dna string in lowercase
    private static String getLowerCaseString(String dna, String startCodon, String stopCodon) {
        int startGene = dna.toLowerCase().indexOf(startCodon.toLowerCase());
        if(startGene == -1){
            return "";
        }
        int stopGene = dna.toLowerCase().indexOf(stopCodon.toLowerCase());
        if((stopGene - startGene) % 3 == 0){
            return dna.substring(startGene, stopGene + 3);
        } else {
            return "";
        }
    }


    //this method to check the case
    public boolean checkCase(String dna){
        return Character.isLowerCase(dna.charAt(0));
    }

    public void testSimpleGene(){
        String dna1 = "atgtgaagttaa";

        String gene = findSimpleGene(dna1,"ATG","TAA");
        System.out.println(gene);
    }
}

class MainPart2{
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        part2.testSimpleGene();
    }
}
