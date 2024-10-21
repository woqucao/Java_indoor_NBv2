public class api {
    public static String getGrade(int score) {
        if (score >= 90) {
            return "优秀";
        } else if (score >= 80) {
            return "良";
        } else if (score >= 60) {
            return "及格";
        } else {
            return "不及格";
        }
    }
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
