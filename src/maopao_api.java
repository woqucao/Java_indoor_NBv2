import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;

public class maopao_api {

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
            String response = "请提供要排序的数组，格式：numbers=1,2,3,4,5";
            if (query != null && query.startsWith("numbers=")) {
                try {
                    String[] numberStrings = query.substring(8).split(",");
                    int[] numbers = Arrays.stream(numberStrings).mapToInt(Integer::parseInt).toArray();
                    int[] sortedNumbers = bubbleSort(numbers);
                    response = Arrays.toString(sortedNumbers);
                } catch (Exception e) {
                    response = "无效的输入格式";
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
        server.createContext("/sort", new SortHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("冒泡排序API服务器在5050端口启动");
        System.out.println("使用方法：http://localhost:5050/sort?numbers=5,2,8,1,9");
    }
}