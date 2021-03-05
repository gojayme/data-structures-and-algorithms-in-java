public class Student{//student class

	//parameters
	public String studentID;//the student ID which is a String
	public String studentName;//the student name which is a String
	public String studentLocation;//the student location which is a String
	public int studentDesiredNumOfRooms;//the student desired number of rooms which is an int
	public int studentLaundryDesire;//the student laundry desire which is an int
	public int studentRentDesire;//the student rent desire which is an int
	public Student next;//students next pointer

	public Student(String studentID, String studentName, String studentLocation, int studentDesiredNumOfRooms, int studentLaundryDesire, int studentRentDesire){
		this.studentID = studentID;//uses this keyword to assign ID
		this.studentName = studentName;//uses this keyword to assign name
		this.studentLocation = studentLocation;//uses this keyword to assign location
		this.studentDesiredNumOfRooms = studentDesiredNumOfRooms;//uses this keyword to assign desired number of rooms
		this.studentLaundryDesire = studentLaundryDesire;//uses this keyword to assign whether laundry is desired
		this.studentRentDesire = studentRentDesire;//uses this keyword to assign whether rent is desired
	}

		public String toString(){//toString method returns all the parameters as a string
			String s = "studentID: " + studentID + " studentName: " + studentName + " studentLocation: " + studentLocation + " studentDesiredNumOfRooms: " + studentDesiredNumOfRooms + " studentLaundryDesire: " + studentLaundryDesire + " studentRentDesire:" + studentRentDesire;
			return s;//returns concatenated string
			
		}

	public void displayLink()//prints out value of link
	{
		System.out.println(toString());//using toString method
	}




}