import java.util.Scanner;
public class secion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你走上方台，定做中央");
        int a = sc.nextInt();
        switch (a) {
            case 10:
            case 9:
                System.out.println("你过关！");
                break;
            case 8:
                System.out.println("良");
            case 7:
            case 6:
                System.out.println("中");
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                System.out.println("该罚！");
                break;
            default:
                System.out.println("sb，尼玛输什么呢");


        }
    }
}