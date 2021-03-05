public class Apartment{//apartment class

	//parameters
	public String apartmentID;//the apartment ID which is a String
	public String apartmentLocation;//the apartment location which is a String
	public int apartmentNumOfBedrooms;//the apartment number of bedrooms which is an int
	public int apartmentHasLaundry;//whether the apartment has laundry which is an int
	public int apartmentRent;//the apartment rent which is an int
	public Apartment prev;//the previous pointer for this doubly linked object
	public Apartment next;//the next pointer for this doubly linked object

	public Apartment(String apartmentID, String apartmentLocation, int apartmentNumOfBedrooms, int apartmentHasLaundry, int apartmentRent){
		this.apartmentID = apartmentID;//uses this keyword to assign ID
		this.apartmentLocation = apartmentLocation;//uses this keyword to assign location
		this.apartmentNumOfBedrooms = apartmentNumOfBedrooms;//uses this keyword to assign number of bedrooms
		this.apartmentHasLaundry = apartmentHasLaundry;//uses this keyword to assign laundry condition
		this.apartmentRent = apartmentRent;//uses this keyword to assign rent

	}

	public String toString(){//toString method returns all the parameters as a string
		String s = "apartmentID: " + apartmentID + " apartmentRent: " + apartmentRent + " apartmentLocation: " + apartmentLocation + " apartmentNumOfBedrooms: " + apartmentNumOfBedrooms + " apartmentHasLaundry: " + apartmentHasLaundry;
		return s;//returns concatenated string

	}

}