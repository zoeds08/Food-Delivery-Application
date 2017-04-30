package demo.rest;

import demo.model.Restaurant;
import demo.model.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantDiscoveryServiceRestController {
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantDiscoveryServiceRestController(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping(value = "/restaurants",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Restaurant> restaurants) throws Exception{
        this.restaurantRepository.save(restaurants);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.POST)
    public void purge(){
        this.restaurantRepository.deleteAll();
    }
}
