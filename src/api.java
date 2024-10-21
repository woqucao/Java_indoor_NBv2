import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Scanner;

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

    static class SortHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String bob_response = "请提供要排序的数组，格式：numbers=1,2,3,4,5";
            String grade_response = "请提供成绩参数";
            if (query != null && query.startsWith("numbers=")) {
                try {
                    String[] numberStrings = query.substring(8).split(",");
                    int[] numbers = Arrays.stream(numberStrings).mapToInt(Integer::parseInt).toArray();
                    int[] sortedNumbers = bubbleSort(numbers);
                    bob_response = Arrays.toString(sortedNumbers);
                } catch (Exception e) {
                    bob_response = "无效的输入格式";
                }
            }
            if (query != null && query.startsWith("score=")) {
                try {
                    int score = Integer.parseInt(query.substring(6));
                    grade_response = getGrade(score);
                } catch (NumberFormatException e) {
                    grade_response = "无效的成绩输入";
                }
            }
            exchange.sendResponseHeaders(200, bob_response.getBytes().length);
            exchange.sendResponseHeaders(200, grade_response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(bob_response.getBytes());
            os.write(grade_response.getBytes());
            os.close();
        }
    }
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(5050), 0);
        server.createContext("/grade", new score_grade_api.GradeHandler());
        server.createContext("/sort", new maopao_api.SortHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("API服务器在5050端口启动（用法：）");

    }
}
