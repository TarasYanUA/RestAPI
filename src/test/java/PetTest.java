import org.testng.annotations.Test;
import java.io.IOException;

public class PetTest {
    @Test
    public void addNewPet_string() throws IOException {
        System.out.println("We use String");
        new PetEndpoints().addNewPet_string();
    }

    @Test
    public void addNewPet_json() throws IOException {
        System.out.println("We use Json");
        PetEndpoints petEndpoints = new PetEndpoints();
        String cat1 = petEndpoints.addNewPet_json(77, "Pets in stock",9, "Danichka", "domestic", new String[] {"animal", "pet"});
        String cat2 = petEndpoints.addNewPet_json(77, "Pets in stock",13, "Alisa", "domestic", new String[] {"animal", "pet"});
        System.out.println(cat1 + "\n" + cat2);
    }

    @Test
    public void addNewPet_gson() throws IOException {
        System.out.println("We use Gson");
        PetEndpoints petEndpoints = new PetEndpoints();
        PetEndpointsForGson dog = new PetEndpointsForGson();
        dog.setId(7);
        dog.setName("Bobbik");
        dog.setStatus("homeless");
        dog.setPhotoUrls(new String[] {"photo1", "photo2", "photo3"});

        System.out.println("Second gson: " + petEndpoints.addNewPet_gson(dog));
    }

    @Test
    public void getPetId() throws IOException {
        PetEndpoints petEndpoints = new PetEndpoints();
        petEndpoints.getPetId(9);
    }

    @Test
    public void deletePet() throws IOException {
        PetEndpoints petEndpoints = new PetEndpoints();
        petEndpoints.deletePet(13);
    }
}