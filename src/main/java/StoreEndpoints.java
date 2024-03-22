import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class StoreEndpoints {
        public void placeAnOrder_String() throws IOException {
            String body = "{\n" +
                    "  \"id\": 33,\n" +
                    "  \"petId\": 5,\n" +
                    "  \"quantity\": 1,\n" +
                    "  \"shipDate\": \"2024-03-22\",\n" +
                    "  \"status\": \"placed\",\n" +
                    "  \"complete\": true\n" +
                    "}";

            RequestBody requestBody = RequestBody.create(body.getBytes());
            Request request = new Request.Builder()
                    .post(requestBody)
                    .url("https://petstore.swagger.io/v2/store/order")
                    .header("Content-Type", "application/json")
                    .build();

            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.body().string());
        }

        public void placeAnOrder_Json(long orderId, int petId, int quantity, boolean complete) throws IOException {
            JSONObject order = new JSONObject();
            order.put("id", orderId);
            order.put("petId", petId);
            order.put("quantity", quantity);
            order.put("complete", complete);

            RequestBody requestBody = RequestBody.create(order.toString().getBytes());

            Request request = new Request.Builder()
                    .post(requestBody)
                    .url("https://petstore.swagger.io/v2/store/order")
                    .header("Content-Type", "application/json")
                    .build();

            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = okHttpClient.newCall(request).execute();
            String responseBody = response.body().string();
            System.out.println(responseBody);
        }

    public void placeAnOrder_Gson(StoreEndpointsForGson storeEndpointsForGson) throws IOException{
        Gson gson = new Gson();
        String storeString = gson.toJson(storeEndpointsForGson);

        RequestBody requestBody = RequestBody.create(storeString.getBytes());

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/store/order")
                .header("Content-Type", "application/json")
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public void getOrderId(long orderId) throws IOException {
            Request request = new Request.Builder()
                    .get()
                    .url("https://petstore.swagger.io/v2/store/order/" + orderId)
                    .build();

            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public void deleteOrder(long orderID) throws IOException {
            Gson gson = new Gson();
            StoreEndpointsForGson storeEndpointsForGson = new StoreEndpointsForGson();
            String storeString = gson.toJson(storeEndpointsForGson);

            RequestBody requestBody = RequestBody.create(storeString.getBytes());
            Request request = new Request.Builder()
                    .delete(requestBody)
                    .url("https://petstore.swagger.io/v2/store/order/" + orderID)
                    .build();

            OkHttpClient okHttpClient = new OkHttpClient();
            Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }
}