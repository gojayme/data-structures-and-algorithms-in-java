
public class HousingMatchingDriver {//driver class

	public static void main(String[] args){//main method


		WaitingStudentQueue studentsqueue = new WaitingStudentQueue();//creates new WaitingStudentQueue object
		ApartmentList aptlist = new ApartmentList();//creates new ApartmentList object
		studentsqueue.loadStudentstoQueue("InputStudentFile.txt");//loads students from file to queue
		aptlist.loadApartmentsToList("InputApartmentFile.txt");//load apartments from file to list
		System.out.println("About to print out the apartment list initially after scanned");
		aptlist.displayList();//displays list of apartments BEFORE matching
		System.out.println();//prints a blank line
		System.out.println("About to print out the student queue initially after scanned");
		studentsqueue.displayList();//displays queue of students BEFORE matching
		System.out.println("About to do the match process");
		System.out.println();
		matchThem(studentsqueue,aptlist);//passes the queue and list to a match method
		System.out.println();
		System.out.println("The students have been attempted to be matched with apartments");//print statement
		System.out.println("These apartments were not matched with any students");//print statement
		aptlist.displayList();//displays apartment list after search and method method
		System.out.println("These students were not matched with any apartments");//print statement
		studentsqueue.displayList();//displays student queue after search and method method


	}

	public static void matchThem(WaitingStudentQueue queue, ApartmentList list){//static method that is passed a student queue and apartment list
		while(!queue.isEmpty()){//as long is the queue isn't empty	
			//dequeue a student and pass to search and match method which operates on the apartment list
			list.linearSearchAndMatch(queue.dequeue());
		}
	}
}