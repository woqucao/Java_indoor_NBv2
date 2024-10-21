import java.io.IOException;
import java.util.Scanner;

public class maopao {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n;
        int maxn;
        System.out.println("请输入数组长度");
        n=scanner.nextInt();
        //n = System.in.read();
        int[] num = new int[n+1];
        System.out.println("请输入数组元素");
        for (int i =0;i<n;i++){
            num[i] = scanner.nextInt();
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                if (num[i]<num[j]){

                }else if(num[j]<num[i]){
                    int swap;
                    swap = num[i];
                    num[i] = num[j];
                    num[j] = swap;
                }
            }
        }
        for (int i =0;i<n;i++){
            System.out.println(num[i]);
        }
        //System.out.println(num[n]);
    }
}
