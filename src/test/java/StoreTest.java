import org.testng.annotations.Test;
import java.io.IOException;

public class StoreTest {
    @Test
    public void placeAnOrder_String() throws IOException {
        new StoreEndpoints().placeAnOrder_String();
    }

    @Test
    public void placeAnOrder_Gson() throws IOException {
        StoreEndpointsForGson storeEndpointsForGson = new StoreEndpointsForGson();
        storeEndpointsForGson.setId(177);
        storeEndpointsForGson.setPetId(112);
        storeEndpointsForGson.setStatus("in stock");
        storeEndpointsForGson.setComplete(true);

        StoreEndpoints storeEndpoints = new StoreEndpoints();
        storeEndpoints.placeTheOrder_Gson(storeEndpointsForGson);
    }

    @Test
    public void getOrderId() throws IOException {
        StoreEndpoints storeEndpoints = new StoreEndpoints();
        storeEndpoints.getOrderId(177);
    }

    @Test
    public void deleteOrder() throws IOException {
        StoreEndpoints storeEndpoints = new StoreEndpoints();
        storeEndpoints.deleteOrder(177);
    }
}