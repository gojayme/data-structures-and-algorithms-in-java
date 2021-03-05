import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import statements

public class WaitingStudentQueue {//student queue class

	private Student queueHead;//Student object which is the queues head
	private Student queueTail;//Student object which is queues tail

	public WaitingStudentQueue(){//constructor
		queueHead = null;//sets the head to null
		queueTail = null;//sets the tail to null
	}
	public boolean isEmpty()//checks whether the list is empty
	{ return queueHead==null; }//returns the boolean evaluation of that expression of queuehead points to null

	public void loadStudentstoQueue(String fileName){//method that takes filename as parameter and loads students to queue
		try {//try code block     tries to do it and is backed up by a catch in case an input output exception occurs
			File fileObject = new File(fileName);//creates a file object
			FileReader fileReaderObject = new FileReader(fileObject.getAbsolutePath());//creates new filereader object
			BufferedReader bufReaderObject = new BufferedReader(fileReaderObject);//creates new bufferedreader object
			String line;//string line
			while(bufReaderObject.ready()) {//while loop that iterates as long as file is still able to be read
				line = bufReaderObject.readLine();//reads in from buffer reader and stores to line string
				String[] dataTokens = line.split(" "); //tokenizes the string into a string array
				if(dataTokens.length >= 6) {//if datatokens less than 6 which works out since there are only six attributes
					//everything is initially read in as string
					String ID = dataTokens[0].replaceAll("\\D", "");//get rid of nondigit characters
					String name = dataTokens[1].replaceAll(" ", "");//the name
					String locationString = dataTokens[2].replaceAll(" ", "");//the location
					String location = locationString.toUpperCase();//converts the location to ALL UPPERCASE
					String numberOfRooms = dataTokens[3].replaceAll(" ", "");//number of rooms
					String laundryString = dataTokens[4].replaceAll(" ", "");//laundry string
					String rentString = dataTokens[5].replaceAll(" ", "");//rent read in as string
					int rent = Integer.parseInt(rentString);//converts the rent string to an int and stores an int variable
					int numrooms;//creates an int for number of rooms
					if(numberOfRooms.equals("Any"))//checks if numberOfRooms string is exactly Any
					{numrooms=-1;}//sets int to negative one if it is Any, this is important 
					else{//if they actually care about how many rooms
						numrooms = Integer.parseInt(numberOfRooms);//parses the number of rooms string to an int
					}
					int laundry=0;//initializes laundry int to zero
					if(laundryString.equals("Yes"))//if the string is yes
					{laundry=1;}//laundry equals one when its yes
					else if(laundryString.equals("Any"))//if the string is Any
					{laundry=0;}//laundry equals zero when its neutral
					else if(laundryString.equals("No"))//if the string is no
					{laundry=-1;}//laundry equals negative one when its false

					enqueue(ID, name, location, numrooms, laundry, rent);//enqueues the most recently scanned student object from the file
				}

			}
			bufReaderObject.close();//closes buffer reader    VERY IMPORTANT		

		}
		catch (IOException e) {//catches the exceptions
			e.printStackTrace();//uses an exception method to print where you went wrong so you can find your mistakes easily
		}
	}


	public void enqueue(String ID, String name, String location, int numrooms, int laundry, int rent)//adds a student node to queue
	{
		Student newLink = new Student(ID, name, location, numrooms, laundry, rent);  //makes new link
		if( isEmpty() )        //if statement checks if its empty
			queueHead = newLink; //points head to newlink
		else	//if it isnt empty
			queueTail.next = newLink;    //assigns queuetails next to newLink
		queueTail = newLink;          //assigns the queuetail to newlink
	}
	public Student dequeue()       //deletes the first link on the list
	{     
		if(!isEmpty()){//if the list isnt empty
			Student temp = queueHead;//creates a temp student
			queueHead = queueHead.next;//has the head point to head 
			return temp;//returns student temp object
		}
		return null;//if you didnt return temp, return null
	}
	public void displayList()//displays content of list
	{
		System.out.println("List (first-->last): ");//
		Student current = queueHead;//creates temp student object called current and current points to head
		while(current != null)//while the current object isnt null
		{//enter while loop
			current.displayLink();//display the current student node
			current = current.next;//move on to next node and traverse!!
		}//exit while loop
		System.out.println("");//prints blank line
	}
}
