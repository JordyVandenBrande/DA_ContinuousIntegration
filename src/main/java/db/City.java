package db;

public class City {

	private String zipCode;
	private String name;
	private String review;
	
	public City() {}
	
	public void setZipCode(String zip) {
		this.zipCode = zip;
	}
	
	public String getZipCode() {
		return this.zipCode;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setReview(String info){
		this.review = info;
	}
	
	public String getReview(){
		return review;
	}
	
	public String toString() {
		String result= "{ \"stad\" : \"" + this.getName() + "\", \"review\" : \"" + this.getReview() + "\"}";
		return result; 			//getZipCode() + " " + getName() + " " + getReview();
	}
	
}
