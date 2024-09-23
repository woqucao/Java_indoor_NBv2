public class score_grade {
    public static void main(String[] args) {
        System.out.println("SB，快写成绩");
        int score = 1145;
        if (score >= 90) {
            System.out.println("优秀");
            System.out.println("压力马斯内~");
        } else if (score >= 80) {
            if (score <= 90) {
                System.out.println("良");
            }
        }else if (score >= 60) {
            if (score <= 80) {
                System.out.println("你过关！");
            }
        }else if (score < 60) {
            System.out.println("该罚！");
        }

    }
}
