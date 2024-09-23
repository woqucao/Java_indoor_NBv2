import java.util.Scanner;

public class zhishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=0;
        int y=0;
        int n;
        System.out.println("请输入一个整数：");
        n= scanner.nextInt();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                if (i%j==0){
                    x++;
                }
            }
            if (x==2){
                System.out.println(i);
                y++;
            }
            x=0;
        }
        System.out.println("1-"+n+"之间共有"+y+"个素数");
    }
}
