
public class p5Driver {
	//driver class
	public static void main(String[] args){
		//main
		hashTable h = new hashTable();//creates new hashtable object
		h.loadBooksToHashTable("BX-Books.csv");//load from csv file and build hash table
		System.out.println("About to load in the titles from the titles.csv file and and search for those books in hash table");
		System.out.println();
		h.loadNamesToSearchFor("titles.csv");
		System.out.println();
		h.printNumberOfNonEmptyEntries();
		System.out.println();
		h.sizeLongestLinkedList();
		System.out.println();
		h.updateISBN("Classical Mythology", "0199997322");
		System.out.println(h.findByTitle("Classical Mythology"));
	}
}
