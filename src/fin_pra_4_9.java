import java.io.IOException;
import java.util.Scanner;

public class fin_pra_4_9 {
    public static void main(String[] args) throws IOException {
        int number = 1;
        Scanner scanner = new Scanner(System.in);
        //number=System.in.read();
        number = scanner.nextInt();
        if (number % 2 == 0){
            System.out.println("偶数");
        }else {
            System.out.println("奇数");
        }
        int xx;
    }
}
