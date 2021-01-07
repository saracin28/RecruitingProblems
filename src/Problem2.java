import java.util.List;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
//        String str = "(“John”, (“Jasmine”, (“Jay”), (“Unavailable”)), (“Unavailable”, (“Jack”, (“Jeremy”))), (“Johanna”))";
        boolean flag=true;
        int countX = 1;
        int countY = 0;
        int x=0;

        //Delete all Unavailable without sub-hierarchy
        if(str.contains("(“Unavailable”)")) {
            str = str.replace(", (“Unavailable”)", "");
        }
        //Replace all Unavailable containing sub-hierarchy with x
        if(str.contains("“Unavailable”,")){
            str = str.replaceAll("“Unavailable”,", "x");
        }

        //Going through our String
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='x') {
                //Delete all Unavailable with sub-hierarchy
                while (i!=str.length()) {
                    if (flag){
                        x=i-1;
                        flag=false;
                    }
                    if (str.charAt(i) == '(') {
                        countX++;
                    }
                    else if (str.charAt(i) == ')'){
                        countY++;
                    }
                    if(countX==countY){
                        str = str.replace(str.substring(x,i+3),"");
                        flag =true;
                        i=x;
                        break;
                    }
                    i++;
                }
            }
        }
        System.out.println(str);
    }
}
