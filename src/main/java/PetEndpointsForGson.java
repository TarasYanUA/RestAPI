import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode

public class PetEndpointsForGson {
    private long id;
    private String name;
    private String status;
    private String[] photoUrls;
}