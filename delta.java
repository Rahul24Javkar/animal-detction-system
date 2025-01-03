import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QueryParameterExtractor {

    public static Map<String, String> getQueryParameters(String url) {
        Map<String, String> params = new HashMap<>();
        int questionMarkIndex = url.indexOf('?');

        if (questionMarkIndex != -1) {
            String queryString = url.substring(questionMarkIndex + 1);
            String[] pairs = queryString.split("&");

            for (String pair : pairs) {
                String[] keyValue = pair.split("=", 2);
                params.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : "");
            }
        }

        return params;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String url = scanner.nextLine().trim();
        int N = Integer.parseInt(scanner.nextLine().trim());

        Map<String, String> queryParams = getQueryParameters(url);

        for (int i = 0; i < N; i++) {
            String key = scanner.nextLine().trim();
            System.out.println(queryParams.getOrDefault(key, "-1"));
        }

        scanner.close();
    }
}
