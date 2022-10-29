package StringThirdAssignment;

public class Part2 {
    public float cgRatio(String dna){
        float cgRatio = 0.0f;
        int cNums = 0;
        int gNums = 0;
        int cIndex = dna.toUpperCase().indexOf('C');
        int gIndex = dna.toUpperCase().indexOf('G');
        while (true){
            if(cIndex != -1){
                cNums++;
                cIndex = dna.indexOf('C',cIndex +1);
            } else if (gIndex != -1) {
                gNums++;
                gIndex = dna.indexOf('G',gIndex +1);
            } else {
                break;
            }
        }
        cgRatio =(float) (cNums + gNums) / dna.length();
        return cgRatio;
    }


    public int countCTG(String dna){
        int ctgNums = 0;
        int ctgIndex = dna.indexOf("CTG");
        while(ctgIndex != -1){
            ctgNums++;
            ctgIndex = dna.indexOf("CTG",ctgIndex + 3);
        }
        return ctgNums;
    }
}

class MainPart2{
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        System.out.println(part2.cgRatio("ATGCCATAG"));
        System.out.println(part2.countCTG("CTGAACTGCTGGCTGC"));
    }
}
