package StringSecondAssignment;

public class Part2 {
    public int howMany(String stringa, String stringb){
        int nums = 0;
        int index = stringb.indexOf(stringa);
        while (index != -1){
            nums++;
            index = stringb.indexOf(stringa,index + stringa.length());
        }
        return nums;
    }


    public void testHowMany(){
        String s1 = "GAA";
        String s2 = "ATGAACGAATTGAATC";
        int num = howMany(s1,s2);
        System.out.println(num);
    }
}
 class MainPart2{
     public static void main(String[] args) {
         Part2 part2 = new Part2();
         part2.testHowMany();
     }
 }