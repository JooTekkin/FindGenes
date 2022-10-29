package StringThirdAssignment;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 extends Part1 {
    public void processGenes(StorageResource sr){
        int numsLonger = 0;
        int numsGreater = 0;
        int theLongest = 0;
        for(String genes : sr.data()){
            if(genes.length() >= 9){
                numsLonger++;
                System.out.println("The gene = " + genes + "\nThe lenght = " + genes.length());
            }
            float cgRatio = new Part2().cgRatio(genes);
            if (cgRatio > 3.5){
                numsGreater++;
                System.out.println("the gene > 3.5 =" + genes + "\n the nums = " + cgRatio);
            }
            if(genes.length() > theLongest){
                theLongest = genes.length();
            }
        }
        System.out.println("the nums Longer than 9 = " + numsLonger);
        System.out.println("the nums greater than 3.5 = " + numsGreater);
        System.out.println("the longest = " + theLongest);
    }


    public void testProcess(){
        FileResource file = new FileResource();
        StorageResource stored = getAllGenes(file.asString());
        processGenes(stored);
    }
}


class MainPart3{
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testProcess();
    }
}
