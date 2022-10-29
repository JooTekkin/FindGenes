package StringThirdAssignment;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part1{
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int endCodon = dna.toUpperCase().indexOf(stopCodon,startIndex);
        while(endCodon != -1){
            if((endCodon - startIndex) %3 == 0){
                return endCodon;
            } else {
                endCodon = dna.toUpperCase().indexOf(stopCodon,endCodon + stopCodon.length());
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


    public StorageResource getAllGenes(String dna){
        StorageResource store = new StorageResource();
        int start = 0;
        while (true){
            String genes = findGene(dna,start);
            if (genes.isEmpty()){
                break;
            }
            store.add(genes);
            start = dna.indexOf(genes,start) + genes.length();
        }
        return store;
    }
    public void testFindGene(){
        FileResource dna2 = new FileResource();
        StorageResource storedGenes = getAllGenes(dna2.asString());
        for(String genes : storedGenes.data()){
            System.out.println(genes);
        }
    }

}

class MainPart1{
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        part1.testFindGene();
    }
}
