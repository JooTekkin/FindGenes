package StringFirstAssignment;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int numOccur = 0;
        int startOccur = stringb.indexOf(stringa);
        while (startOccur != -1){
            numOccur++;
            startOccur = stringb.indexOf(stringa,startOccur + stringa.length());
        }
        return numOccur >= 2;
    }

    public String lastPart(String stringa, String stringb){
    int index = stringb.indexOf(stringa);
    if(index != -1){
        return stringb.substring(stringa.length()+1);
    } else {
        return stringb;
    }
    }



    public void testing(){
        boolean Occurrences = twoOccurrences("a","banana");
        String lastPart = lastPart("zoo","forest");
        System.out.println(Occurrences);
        System.out.println(lastPart);
    }
}

 class MainPart3 {
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        part3.testing();
    }
}