package BuildingsTest;

import org.junit.jupiter.api.Test;
import pl.psi.Resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourcesTest {

    @Test
    void ShouldSubtract() {
        Resources resources = Resources.builder().wood(2).build();
        Resources toSubtrack = Resources.builder().wood(1).build();
        resources = resources.subtract(toSubtrack);
        assertEquals(1, resources.getWood());
    }

    @Test
    void ShouldAddResources() {


    }
}