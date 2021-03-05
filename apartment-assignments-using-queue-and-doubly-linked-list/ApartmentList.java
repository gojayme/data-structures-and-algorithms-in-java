import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import statements

public class ApartmentList{//apartment list class

	private Apartment first;//first object of list
	private Apartment last;//last object of list

	public ApartmentList(){//constructor
		first = null;//sets first to null
		last = null;//sets last to null
	}

	public boolean isEmpty(){//returns boolean vaule that represents whether the list if empty
		return (first==null);//evaluates this expression and returns boolean
	}

	public void findAndDelete(Apartment deleteThisMatch) {//find and delete specific apartment
		Apartment current = first;//creates temp apartment called current and it points to first

		while (current!=null && !current.equals(deleteThisMatch)) {  // when current isnt null and current isnt what your looking for
			current = current.next;//time to traverse :)
		}
		if (current==null) { // end of list and no match
			return;//return allows you to exit
		} else {//if current isnt null, hold on to your seats
			if (current.prev!=null) { // not first element
				current.prev.next = current.next;
			} else {  // first element
				first = current.next;//yeah!!
			}
			if (current.next!=null) {  //not last element
				current.next.prev = current.prev;
			} else {  // last element
				last = current.prev;
			}
			return;//blast out this method!
		}
	}


	public void insertLast(String apartmentID, String apartmentLocation, int apartmentNumOfBedrooms, int apartmentHasLaundry, int apartmentRent){
		//inserts into last spot of list
		Apartment o = new Apartment( apartmentID,  apartmentLocation,  apartmentNumOfBedrooms, apartmentHasLaundry, apartmentRent);
		//creates temporary apartment object
		if(isEmpty())//if the list is empty
		{first = o;}//makes first point to temporary object
		else//if the list isnt next
		{last.next = o;//make the last's next point to o
		o.prev = last;//make o's previous point to last
		}
		last = o;//makes last point to o regardless
	}


	public void insertFirst(String apartmentID, String apartmentLocation, int apartmentNumOfBedrooms, int apartmentHasLaundry, int apartmentRent) {
		Apartment o = new Apartment( apartmentID,  apartmentLocation,  apartmentNumOfBedrooms, apartmentHasLaundry, apartmentRent);
		//temp apartment object called o
		o.next = first;//points o's next to first
		if (first!=null) { // list has elements
			first.prev = o;//points first's previous to o
		}
		first = o;//points first to o
	}


	public void loadApartmentsToList(String fileName){//loads apartments from file using filename passed as String parameter

		try {//try code block     tries to do it and is backed up by a catch in case an input output exception occurs
			File fileObject = new File(fileName);
			FileReader fileReaderObject = new FileReader(fileObject.getAbsolutePath());//creates new filereader object
			BufferedReader bufferReaderObject = new BufferedReader(fileReaderObject);//creates new bufferedreader object
			String line;//string line
			while(bufferReaderObject.ready()) {//while loop that iterates as long as file is still able to be read
				line = bufferReaderObject.readLine();//reads a line from buffer reader object
				String[] dataTokens = line.split(" "); //tokenizes the string into a string array
				if(dataTokens.length >= 5) {//if datatokens less than 5 since 5 values on each line
					//read everything in as string
					String ID = dataTokens[0].replaceAll("\\D", "");//get rid of nondigit characters
					String locationString = dataTokens[1].replaceAll(" ", "");//the location
					String location = locationString.toUpperCase();//converts location to upper case
					String numberOfRooms = dataTokens[2].replaceAll(" ", "");//the number of rooms
					String laundryString = dataTokens[3].replaceAll(" ", "");//think the hotel will have laundry? :P
					String rentString = dataTokens[4].replaceAll(" ", "");//the rent
					int rent = Integer.parseInt(rentString);//parses rent to int
					int numrooms;//creates int to represent number of rooms
					{numrooms = Integer.parseInt(numberOfRooms);}//parses string to int
					int laundry=0;//initializes int to represent laundry
					if(laundryString.equals("Yes"))
					{laundry=1;}//laundry equals one when yes
					else if(laundryString.equals("Any"))
					{laundry=0;}//laundry equals zero when its neutral
					if(laundryString.equals("No"))
					{laundry=-1;}//laundry equals negative one when no
					insertLast(ID, location, numrooms, laundry, rent);//inserts most recently scanned in apartment
				}
			}
			bufferReaderObject.close();//closes buffer reader    VERY IMPORTANT		
		}
		catch (IOException e) {//catches the exceptions
			e.printStackTrace();//uses an exception method to print where you went wrong so you can find your mistakes easily
		}
	}


	public void linearSearchAndMatch(Student tom){//the real action   takes in a student object
		Apartment current = first;//points temp aprtment object to first
		int perfectMatch=0;//initializes perfect match to zero
		//i used a score system in which the apartment had to score a four in order to match PERFECTLY with a student
		while(current!=null){//while temp apartment object isnt null

			perfectMatch = 0;//reassign perfect match to zero
			if(tom.studentLocation.equals(current.apartmentLocation)||tom.studentLocation.equals("ANY"))//checks location
			{//location check
				perfectMatch++;}//increment perfectmatch
			if(tom.studentRentDesire>=current.apartmentRent)//checks rent
			{perfectMatch++;//increment perfectmatch
			}
			if(tom.studentLaundryDesire==current.apartmentHasLaundry || tom.studentLaundryDesire==0)//checks laundry
			{perfectMatch++;//increment perfectmatch
			}
			if(tom.studentDesiredNumOfRooms==-1 || current.apartmentNumOfBedrooms==tom.studentDesiredNumOfRooms)
			{perfectMatch++;//increment perfectmatch
			}
			if(perfectMatch==4)//if perfect match
			{//print out apartment student combo match
				System.out.println(" Apartment " + current.apartmentID + " is assigned to "+ tom.studentName + " " + tom.studentID + " student apt desire " + tom.studentLocation + " apt location"+ current.apartmentLocation);
				findAndDelete(current);//remove the matched apartment from list
				return;//exit this and get outta dodge
			}
			current = current.next;//traverse



		}
		if(perfectMatch!=4)//if it isnt a perfect match
			//print out the NO match
		{System.out.println(" Student " + tom.studentID + " " + tom.studentName + " " +  " is unassigned");}

	}

	public void displayList()//displays content of list
	{
		System.out.println("List (first-->last): ");
		Apartment current = first;     
		while(current != null)      
		{
			System.out.println(current);//print statement 
			current = current.next;     
		}
		System.out.println("");
	}


	public String toString() {//tostring method
		String s = "first-->"+first;
		s+= " list: null<-->";
		Apartment current = first;
		while (current != null) {
			s+=current+"<-->";
			current=current.next;
		}
		s+="null";
		return s;//return string
	}







}