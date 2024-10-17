public class api_practice {
    public static void main(String[] args) {
        // 创建一个简单的API
        System.out.println("欢迎使用简单API");
        
        // 模拟API端点
        String endpoint = "/users";
        
        // 模拟API请求
        String request = "GET " + endpoint;
        
        // 处理请求
        handleRequest(request);
    }
    
    public static void handleRequest(String request) {
        System.out.println("收到请求: " + request);
        
        // 模拟API响应
        String response = "{ \"status\": \"success\", \"data\": [{ \"id\": 1, \"name\": \"张三\" }, { \"id\": 2, \"name\": \"李四\" }] }";
        
        System.out.println("API响应: " + response);
    }
}
