import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class StoreEndpointsForGson {
    long id;
    long petId;
    int quantity;
    String status;
    boolean complete;

    @Override
    public String toString() {
        return "StoreGson{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", complete=" + complete +
                '}';
    }
}