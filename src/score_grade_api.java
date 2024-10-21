import java.util.Scanner;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;


public class score_grade_api {
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

    static class GradeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String response = "请提供成绩参数";
            if (query != null && query.startsWith("score=")) {
                try {
                    int score = Integer.parseInt(query.substring(6));
                    response = getGrade(score);
                } catch (NumberFormatException e) {
                    response = "无效的成绩输入";
                }
            }
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(5050), 0);
        server.createContext("/grade", new GradeHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("API服务器在5050端口启动（用法：）");

        // 原来就有的（我为了证明我电脑没崩加的）
        System.out.println("SB，快写成绩");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String grade = getGrade(score);
        System.out.println("你的成绩等级是：" + grade);
        
        if (score >= 90) {
            System.out.println("压力马斯内~");
        } else if (score < 60) {
            System.out.println("该罚！");
        } else if (score >= 60 && score <= 80) {
            System.out.println("你过关！");
        }
    }
}//奇怪的GitHub


