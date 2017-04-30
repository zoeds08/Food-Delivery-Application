package demo;

import demo.model.Restaurant;
import demo.model.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantDiscoveryServiceApplication.class)
@WebAppConfiguration
public class RestaurantRepositoryTest {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void saveRestaurant(){
        this.restaurantRepository.save(new Restaurant("restaurantName-Nando-1"));
        assertThat(this.restaurantRepository.findByRestaurantName("restaurantName-Nando-1", new PageRequest(0,1)).getContent()
                .get(0).getRestaurantName()).isEqualTo("restaurantName-Nando-1");

    }

    @Test
    public void queryByUnitInfoRestaurantName(){
        final String restaurantName = "restaurantName-Nando-2";
        this.restaurantRepository.save(new Restaurant("restaurantName-Nando-2"));
        assertTrue(this.restaurantRepository.findByRestaurantName(restaurantName, new PageRequest(0,10)).getTotalElements()==1);
        assertTrue(this.restaurantRepository.findByRestaurantName(restaurantName, new PageRequest(0,10)).getContent().get(0)
            .getRestaurantName().equals(restaurantName));
    }
}