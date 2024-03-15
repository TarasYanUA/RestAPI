import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class PetEndpoints {
    public void addNewPet_string() throws IOException {
        String simpleString = "{\n" +
                "  \"id\": 99,\n" +
                "  \"category\": {\n" +
                "    \"id\": 22,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        RequestBody requestBody = RequestBody.create(simpleString.getBytes());
        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public String addNewPet_json(int categoryId, String categoryName, int petId, String petName, String status, String[] photoUrls) throws IOException {
        JSONObject category = new JSONObject(); //по такому же принципу можно сделать tags
        category.put("id", categoryId);
        category.put("name", categoryName);

        JSONObject myPet = new JSONObject();
        myPet.put("category", category);
        myPet.put("id", petId);
        myPet.put("name", petName);
        myPet.put("status", status);
        myPet.put("photoUrls", photoUrls);

        RequestBody requestBody = RequestBody.create(myPet.toString().getBytes());
        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public PetEndpointsForGson addNewPet_gson(PetEndpointsForGson petGson) throws IOException {
        Gson gson = new Gson();
        String petString = gson.toJson(petGson);

        RequestBody requestBody = RequestBody.create(petString.getBytes());

        Request request = new Request.Builder()
                .put(requestBody)
                .url("https://petstore.swagger.io/v2/pet")
                .header("Content-Type", "application/json")
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);

        return gson.fromJson(responseBody, PetEndpointsForGson.class);
    }

    public void getPetId(int id) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://petstore.swagger.io/v2/pet/" + id)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public void deletePet(int petId) throws IOException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.remove(String.valueOf(petId));

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes());

        Request request = new Request.Builder()
                .post(requestBody)
                .url("https://petstore.swagger.io/v2/pet/" + petId)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}