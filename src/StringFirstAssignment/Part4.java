package StringFirstAssignment;

import edu.duke.URLResource;

public class Part4 {

    String hostname = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
    URLResource url = new URLResource(hostname);
    public void findYoutube(){
        for(String str : url.lines()){
            int index = str.toLowerCase().indexOf("youtube.com");
            if (index != -1){
                int last = str.indexOf("\"",index);
                System.out.println(str.substring(index,last));
            }
        }
    }
}
class MainPart4{
    public static void main(String[] args) {
        Part4 part4 = new Part4();
        part4.findYoutube();
    }
}