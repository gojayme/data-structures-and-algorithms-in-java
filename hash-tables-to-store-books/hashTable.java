import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Iterator;

//import statements

public class hashTable {//class definition

	private LinkedList<Book>[] table;//using predefined java classes
	//description specified having 2000 entries in hash table
	private int size = 2000;//the description states make a hash table of size 2000

	public hashTable(){//hashtable constructor
		//uses casting to initialize a linked list of book objects
		table = (LinkedList<Book>[]) new LinkedList[size];
		for(int i = 0; i<2000;i++)//initialize each array element with an empty linked list
		{
			table[i] = new LinkedList<Book>();//linked list at each array element
		}
	}

	private int hash(Book s) {
		//hash and slash :):):)
		//creates a array of characters from a string
		String bTitle = s.title;//stores books name in string
		char[] c = bTitle.toCharArray();//create a character array from title which is a string
		//int that will store hash value
		int h=0;//int that will store hash value
		//hash and dash thru the chars
		for (int i=0; i<c.length; i++) {
			h+=Character.getNumericValue(c[i]);//add up the hash value based on each character
		}
		//modulus and return
		return h%size;
	}

	private int hashName(String bTitle) {
		//hash and slash :):):)
		//creates a array of characters from a string
		char[] c = bTitle.toCharArray();
		//int that will store hash value
		int h=0;//int that will store hash value
		//hash and dash thru the chars
		for (int i=0; i<c.length; i++) {
			h+=Character.getNumericValue(c[i]);//add up the hash value based on each character
		}
		//modulus and return
		return h%size;
	}

	public void insert(Book s) {//insert function
		//calculate hash value of 
		int h = hash(s);//calculate value of books title
		//		System.out.println("inserting "+s.title+" at "+h);//print out books title and its hash value
		table[h].add(s); // enter item into table
	}

	public void printNumberOfNonEmptyEntries()
	{
		int count = 0;//int count that starts at zero
		for(int i = 0; i <2000;i++)//for loop
		{
			if(table[i].size()!=0)//if there aren't zero books in linked list
			{count++;}//increment count
		}
		System.out.println("The number of nonempty entries in hashtable: "+count);
	}

	public void sizeOfHashTable(){//useful for debugging
		int count = 0;//int that starts at zero
		for(int i = 0; i <2000;i++)//for loop
		{
			count+=table[i].size();//adds to count number of books in each linked list
		}
		System.out.println("The size of hashtable: "+count);
	}

	public void sizeLongestLinkedList()
	{
		int currentMax = table[0].size();//current max will originally be at zero until it possibly is replaced by something longer
		for(int i = 1; i <2000;i++)//for loop
		{
			if(table[i].size()>currentMax)//if whats at the place were at is bigger than the current max
			{
				currentMax = table[i].size();//make where we are at the current max
			}
		}
		System.out.println("The size of the longest linked list in hashtable: "+currentMax);//print statement
	}

	public void updateISBN(String title,String newISBN){//passed two strings, one is title of book to modify and other is ISBN to update
		findByTitle(title).ISBN = newISBN;//changes the ISBN to the book that had that original title
	}

	public Book findByTitle(String s) {
		//calculate hash value of 
		int h = hashName(s);//calculates hash value of name
		s = s.toLowerCase();//converts name to lowercase
		Iterator<Book> iter = table[h].iterator();//uses iterator to look thru hash table
		//while i ponder, check who's feeling null  ANDD see if we found the golden book ._.
		if(table[h]!=null)
		{//no null pointer exceptions
			while(iter.hasNext())
			{//as long as we arent at the end of the linked list
				Book current = iter.next();//temp book object which goes one further down the linked list each time
				String currentTitle = current.title.toLowerCase();//converts the temp books anme to lowercase
				if(currentTitle.equals(s))
				{//compares lowercase version of title passed from method and temp books title
					return current;//if the titles match, then return that book, since it was the one youre looking for
				}
			}
		} 
		return null;// return item or null
	}

	public Book find(Book s) {
		//calculate hash value of books title
		int h = hash(s);
		//while i ponder, check who's feeling null  ANDD see if we found the golden book ._.
		if(table[h]!=null) {//no null pointer exceptions
			if((table[h].indexOf(s))<0)//makes sure we dont go outta bounds
			{
				return null;//return null
			}
			else//if we arent outta bounds
			{
				return table[h].get(table[h].indexOf(s));//return book
			}
		} 
		//just in case always have a null return
		return null;// return item or null
	}

	public void loadNamesToSearchFor(String fileName){//load names to search for from file
		int count = 0;//int that counts how many titles in file
		try {//try code block     tries to do it and is backed up by a catch in case an input output exception occurs
			BufferedReader bufReader = new BufferedReader(new FileReader(fileName));//creates new bufferedreader object
			while(bufReader.ready() && count < 5) {//while loop that iterates as long as file is still able to be read
				String line = bufReader.readLine();//reads in line from file
				// attributes are separated using "," in the .csv file
				String[] dataTokens = line.split("\",\""); //tokenizes the string into a string array
				if(dataTokens.length >= 1) {//if statement that checks length of line read in
					String name = dataTokens[0].replaceAll("\"", "");
					System.out.println(findByTitle(name));//find name by title
					count++;//increments count by one
				}
			}
			bufReader.close();//closes buffer reader    VERY IMPORTANT
		}
		catch (IOException e) {//catches the exceptions
			e.printStackTrace();//uses an exception method to print where you went wrong so you can find your mistakes easily
		}
	}

	public void loadBooksToHashTable(String fileName){
		int count = 0;
		try {//try code block     tries to do it and is backed up by a catch in case an input output exception occurs
			BufferedReader bufReader = new BufferedReader(new FileReader(fileName));//creates new bufferedreader object
			String line = bufReader.readLine(); // loads first line of csv   which happens to be rewritten over 
			//convenenient to rewrite over first values since they are the values that tell you what each column is ex; ISBN, author, etc
			while(bufReader.ready() && count < 10000) {//while loop that iterates as long as file is still able to be read
				line = bufReader.readLine();//reads in a line from this file
				// attributes are separated using "," in the .csv file
				String[] dataTokens = line.split("\",\""); //tokenizes the string into a string array
				if(dataTokens.length >= 8) {//if statement that checks length of line read in
					String ISBN = dataTokens[0].replaceAll("\"", "");//column 0 is the ISBN
					String bTitle = dataTokens[1].replaceAll("\"", "");//column 1 is the title
					String author = dataTokens[2].replaceAll("\"", "");//column 2 is the author   added this
					String year = dataTokens[3].replaceAll("\"", "");//column 3 is the year   added this
					String publisher = dataTokens[4].replaceAll("\"", "");//column 4 is the publisher   added this
					//					String imageURL1 = dataTokens[5].replaceAll("\"", "");//column 5 is the imageurl   added this
					//					String imageURL2 = dataTokens[6].replaceAll("\"", "");//column 6 is the imageurl   added this
					//					String imageURL3 = dataTokens[7].replaceAll("\"", "");//column 7 is the imageurl   added this

					insert(new Book(ISBN,bTitle,author,year,publisher));
					count++;//increments count by one
				}
			}
			bufReader.close();//closes buffer reader    VERY IMPORTANT
		}
		catch (IOException e) {//catches the exceptions
			e.printStackTrace();//uses an exception method to print where you went wrong so you can find your mistakes easily
		}
	}
}
