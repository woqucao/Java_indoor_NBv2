import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class maobao {
//    public static void max(int num1,int num2){
//        int swap;
//        if (num1<num2){
//
//        }else if(num2<num1){
//            swap = num1;
//            num1 = num2;
//            num2 = swap;
//        }
//        return ;
//    }//服了，原来想用函数但是java没有指针（可能我没发现）但不管怎么样，差不多得了
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
