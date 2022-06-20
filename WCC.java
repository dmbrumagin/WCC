import java.util.*;

public class WCC {

    public static void main(String[] args) {
        System.out.println(squares(1,1000000000));
        System.out.println(squares(24,49));
        System.out.println(squares(17,24));
        System.out.println(squares(3,9));
    }

    public static int squares(int a , int b){
        double limitUpper = Math.floor(Math.sqrt(b));
        double limitLower = Math.floor(Math.sqrt(a));
        return  (int)(limitUpper-limitLower);
    }
}
