
import java.util.Scanner;

interface Compute {
    int getExact(int actual, int predicted) throws Exception;
 
    int getAlmost(int actual, int predicted) throws Exception;
 
}
 
public class AtulAditya implements Compute {
 
    private static Scanner sc;
 
    @Override
    public int getAlmost(int actual, int predicted) throws Exception {
 
        int a[] = new int[10];
 
        Integer pred = new Integer(predicted);
 
        String hm_pred = pred.toString();
        String hm_act = new Integer(actual).toString();
 
        for (int i = 0; i < hm_pred.length(); i++) {
            ++a[hm_pred.charAt(i) - '0'];
 
        }
        int c = 0;
        for (int i = 0; i < hm_act.length(); i++) {
            if (a[hm_act.charAt(i) - '0'] >= 1) {
                c++;
                --a[hm_act.charAt(i) - '0'];
            }
        }
        if (c == hm_act.length())
            return 1;
        else
            return 0;
 
    }
 
    @Override
    public int getExact(int actual, int predicted) throws Exception {
 
        if (actual == predicted) {
            return 1;
        }
 
        return 0;
    }
 
    public static void main(String args[]) {
        sc = new Scanner(System.in);
 
        int souravNo = sc.nextInt();
        int rahulNo = sc.nextInt();
 
        //rahulSourav ob = new rahulSourav();
        AtulAditya  ob = new AtulAditya();
 
        try {
        //    System.out.println("here " + souravNo + " " + rahulNo);
            if (ob.getAlmost(souravNo, rahulNo) == 1) {
                if (ob.getExact(souravNo, rahulNo) == 1)
                    System.out.println("EXACT");
                else
                    System.out.println("ALMOST");
 
            }
 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}
