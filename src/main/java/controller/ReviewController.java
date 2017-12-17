package controller;
//ExampleController
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import db.City;
import db.InMemoryDB;

@RestController
@RequestMapping(value="/review")
public class ReviewController {

private final InMemoryDB inMemoryDB;
    
    public ReviewController(){
    	inMemoryDB = InMemoryDB.getInstance();
    }
    
    public void saveCity(City city) {
		if(inMemoryDB.get(city.getZipCode())!=null) {
			inMemoryDB.update(city);
		}else {
			inMemoryDB.add(city);
		}
	}
    
    /*@RequestMapping(method = RequestMethod.POST)
    public City save(@RequestParam (value="cityName") String name, @RequestBody @Valid City city){
    	inMemoryDB.add(name, city);
    	//System.out.println("De postalCode in REST save: " + name + " example data: " + city.getName());
        return city;
    }*/
    
    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam String name){
        return inMemoryDB.get(name).toString();
    }
    
}
