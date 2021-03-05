
public class ContactDriver {//the driver class

	public static void main(String[] args) {//main
		
		//creates a contact tree object
		ContactTree treeOfContacts = new ContactTree();
		//reads in the names and numbers from the text file
		treeOfContacts.ReadInputFile("ContactInformation.txt");
		//searches for chris bosh and prints out his name and number
		System.out.println("Chris Bosh, phone number: "+ treeOfContacts.searchPerson("Chris Bosh"));
		//updates chris boshs phone number to 413-111-2222
		treeOfContacts.updatePhoneNumber("Chris Bosh","413-111-2222");
		//prints out that we updated chris boshs number
		System.out.println("Just updated Chris Boshs phone number to 413-111-2222");
		//prints out the updated number for chris bosh
		System.out.println("Chris Bosh, phone number: "+ treeOfContacts.searchPerson("Chris Bosh"));
		//deletes chris bosh
		treeOfContacts.deletePerson("Chris Bosh");
		//tells you we deleted chris bosh
		System.out.println("Just deleted Chris Bosh from the tree");
		//checks to see if chris andersen is there, and he is!! :)
		System.out.println("Chris Andersen, phone number: "+ treeOfContacts.searchPerson("Chris Andersen"));
		//i hope you can appreciate this as much as i can. well rewarding :)
	}
}
