package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDB {

	private volatile static InMemoryDB uniqueInstance;
	
	private ArrayList<City> db = new ArrayList<City>();
	
	public InMemoryDB(){
		//getInstance();
		City antwerpen = new City();
		City leuven = new City();
		City brugge = new City();
		
		antwerpen.setName("Antwerpen");
		antwerpen.setZipCode("2000");
		antwerpen.setReview("Perfecte stad om een hele dag te gaan shoppen en nadien iets lekkers te eten.");
		
		leuven.setName("Leuven");
		leuven.setZipCode("3000");
		leuven.setReview("Perfecte stad om eens uit te gaan dankzij de vele café's en de 'Langste toog ter wereld'.");
		
		brugge.setName("Brugge");
		brugge.setZipCode("8000");
		brugge.setReview("Perfecte stad voor koppels om er samen een romantisch weekendje tussenuit te gaan.");
		
		this.db.add(antwerpen);
		this.db.add(leuven);
		this.db.add(brugge);
	}
	
	public static InMemoryDB getInstance() {
		if (uniqueInstance == null) {
			synchronized (InMemoryDB.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new InMemoryDB();
				}
			}
		}
		return uniqueInstance;
	}
	
	
    public City get(String name) {
    	City cit = new City();
        if(name == null){
            throw new DbException("No name given");
        }
        for(City city : db){
        	if(city.getName().equals(name)){
        		cit = city;
        		break;
        	}
        }
        return cit;
    }

	public City get(City city) {
		return get(city.getName());
	}
    
    public void add(City city) {
		db.add(city);
	}
    
    public void update(City city) {
		for(City cit : db){
			if(cit.getName().equals(city.getName())){
				cit = city;
			}
		}
	}
	
}
