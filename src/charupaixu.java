import java.util.Scanner;

public class charupaixu {
    public static int Max(int num1,int num2){
        int max;
        if(num1>num2){
            max = num1;
        }else{
            max = num2;
        }
        return max;
    }//这段是useless的
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int[] num;
        boolean[] used;
        num = new int[n + 1];
        used = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
            used[i] = false;
        }
        for (int i = 1; i < n; i++) {
            int key = num[i];
            int j = i - 1;

            while (j >= 0 && num[j] > key) {
                num[j + 1] = num[j];
                j = j - 1;
            }
            num[j + 1] = key;
        }


        for(int i =0;i<n;i++){
            System.out.println(num[i]);
        }
    }
}
