import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ContactTree {//the tree class

	TreeNode root;//where the water goes
	//the little leaves absorb all the water
	public ContactTree(){//creates a tree and makes a null root
		root = null;//null
	}		


	public ContactTree(TreeNode root){//makes the code more versatile
		this.root = root;//not used in the project
	}		


	public void addPerson(String name, String num){//add a person
		//passes a name and phone number as string paramaters
		if(root==null)//if the root is null
		{//make it hold the @ symbol and no phone number
			root = new TreeNode('@', "");
			root.setParent(null);//the root shouldnt have a parent node, its the grandpa
		}
		TreeNode current = root;//temp node that starts at root
		char[] characterArray = name.toCharArray();//converts the name to a char array using java method
		int i;//int that is the index in this char array
		for(i = 0;i<characterArray.length-1;i++)//has to stop before length minus one since the last spot will hold a 
			//phone number, but nowhere else does
		{
			TreeNode prev = current;//temp node creates track of current
			char temp = characterArray[i];//stores the letter as a char
			current = addNode(temp, "",current);//add char without phone number
			current.setParent(prev);//remembers where it used to be and sets that to be the parent
		}
		if(i==characterArray.length-1)//if were at the last letter in the word
		{
			TreeNode prev = current;//temp node creates track of current
			char temp = characterArray[characterArray.length-1];//stores the letter as a char
			current = addNode(temp, num, current);//add char with phone number
			current.setParent(prev);//remembers where it used to be and sets that to be the parent
		}



	}

	public TreeNode addNode(char ch, String number, TreeNode current){//char 97 is lowercase a
		//char 122 is lowercase z
		//char 32 is for blank space
		int indexVal;//the index of where were at

		if((int)ch==32)//if its a balnk space
		{//put it at the end of the array
			indexVal = 26;
		}
		else//put in order from a to z starting at zero
		{
			indexVal = (int)(ch)-97;
		}

		TreeNode[] array = current.getNodeArray();//gets the node array

		TreeNode temp;//temporary TreeNode

		if(array[indexVal]==null)//if there isnt anything in the particular node
		{
			temp = new TreeNode(ch,number);//make a new treenode and store in temp node
			array[indexVal] = temp;//put the temp node in that part of the array
		}

		else//if there is something there
		{
			temp = array[indexVal];//stores whats there in the temp

		}
		return temp;//return temp
	}

	public void deletePerson(String personName){//whos going??
		TreeNode current = root;//make a current temp node that gets root at the beginning
		int countHowManyTimesLetterThere = 0;//incrementer
		if(root==null)//if the root is null
		{
			return;//get outta dodge city
		}
		String personNameInLowerCase = personName.toLowerCase();//convert the name to all lower case
		char[] characterArray = personNameInLowerCase.toCharArray();//break up the name string into a char array
		for(int i = 0; i<characterArray.length;i++)//loop thru the char array
			//goes thru the name once, character by character
		{	
			TreeNode[] arrayForMatchedLetter = current.getNodeArray();//get the node array of the current temp node
			for(int j = 0; j<27;j++)//goes through each node array
			{
				//goes thru many times, looks thru node array seeing which letter is next
				//also hoping that the next letter in the persons name is on the tree
				if(arrayForMatchedLetter[j]!=null)//no null pointers in my neck of the woods
				{
					if(characterArray[i]==arrayForMatchedLetter[j].getCharacter())
					{
						//is the character of the name the same as the one already in the node array of the children
						countHowManyTimesLetterThere++;//increment, keeps track of whether all the letters of the word are on the tree
						current = arrayForMatchedLetter[j];//whatever node matches becomes current, and we move further d0wn the tree
					}

				}
			}
		}
		if(countHowManyTimesLetterThere==characterArray.length-1 || countHowManyTimesLetterThere==characterArray.length)//THIS SHOULD BE UNCOMMENTED
		{		

			if(countHowManyTimesLetterThere==characterArray.length)//THIS SHOULD BE UNCOMMENTED

			{
				current = current.getParent();//gets the parent
			}

			current.setPhoneNumber("");//sets the phone number to blank
			while(current.getChildren()==0)//when it has no children
			{
				TreeNode temp = current;//stores where were at in a temp node
				current = current.getParent();//become your parent
				TreeNode[] arrayToDeleteFrom = current.getNodeArray();//gets the node array of the current
				for(int p = 0;p<arrayToDeleteFrom.length;p++)//loop thru that array we just got
				{

					if(arrayToDeleteFrom[p]==temp)//if the boot fits
					{

						arrayToDeleteFrom[p]=null;//make it null
					}
				}
			}
		}
	}

	public String searchPerson(String personName){//where are you at? peek a boo
		TreeNode current = root;//store the root in a temp node called current
		int countHowManyTimesLetterThere = 0;//how many letters there are
		if(root==null)//if its null
		{
			return null;//i highly doubt they are here
		}
		String personNameInLowerCase = personName.toLowerCase();//make the name lowercase
		char[] characterArray = personNameInLowerCase.toCharArray();//break the string up into a char array
		for(int i = 0; i<characterArray.length;i++)//loop thru the char array
			//goes thru the name once, character by character
		{	
			TreeNode[] arrayForMatchedLetter = current.getNodeArray();//get the current nodes array
			for(int j = 0; j<27;j++)//goes through each node array
			{
				//goes thru many times, looks thru node array seeing which letter is next
				//also hoping that the next letter in the persons name is on the tree
				if(arrayForMatchedLetter[j]!=null)//if it isnt null
				{
					if(characterArray[i]==arrayForMatchedLetter[j].getCharacter())//check if their the same
					{
						countHowManyTimesLetterThere++;//keeps track of how many times they were the same
						current = arrayForMatchedLetter[j];//if it was the same, store that in temp
					}

				}
			}
			if(countHowManyTimesLetterThere==characterArray.length-1 && !current.getPhoneNumber().equals(""))//THIS SHOULD BE UNCOMMENTED
			{//if your at the end of the name and it isnt a blank number
				String l = current.getPhoneNumber();//returns the number
				return l;//tehn it is a name stored in the tree, as ooposed to have searching for only part of a name
			}
		}
		//if name dont exist, return null
		//if name exists, return phone number
		return null;
	}


	public void updatePhoneNumber(String personName, String phoneNumb){//pass it a name and number
		TreeNode current = root;//the root
		int countHowManyTimesLetterThere = 0;//incrementer
		if(root==null)//if its null, then there is nothin theree
		{
			String s = "Person not there";//person not found
			System.out.println(s);//tell the audience
		}
		String personNameInLowerCase = personName.toLowerCase();//NO UPPER CASE ALLOWED :)
		char[] characterArray = personNameInLowerCase.toCharArray();//break it up into a char array
		for(int i = 0; i<characterArray.length;i++)//loop thru it
			//goes thru the name once, character by character
		{	
			TreeNode[] arrayForMatchedLetter = current.getNodeArray();//get the node array
			for(int j = 0; j<27;j++)//goes through each node array
			{
				//goes thru many times, looks thru node array seeing which letter is next
				//also hoping that the next letter in the persons name is on the tree
				if(arrayForMatchedLetter[j]!=null)//if it isn't null
				{//to the null pointer exception :P
					if(characterArray[i]==arrayForMatchedLetter[j].getCharacter())//if the letter of the name matches the node on the tree
					{
						countHowManyTimesLetterThere++;//we made it!!
						current = arrayForMatchedLetter[j];//whatever matched becomes current
					}

				}
			}
			if(countHowManyTimesLetterThere==characterArray.length-1)//if your at the end
			{
				current.setPhoneNumber(phoneNumb);//set the number
			}
		}
	}

	public TreeNode ReadInputFile(String filename){//read in those football players. jk basketball

		// The TreeNode contains the information for each node in the tree
		// A TreeNode should contain a LinkedList<TreeNode> to its children (you can also use array to replace the linked list if you like),
		// a character, and a string (a leaf TreeNode uses it to store a phone number).
		TreeNode root = new TreeNode('@', "");//make the root that weird at thing

		// ** TO DO ** Create an object of your tree operation class so as to call its methods

		try{//try it out, we can catch catch you if you fall
			FileReader file_reader = new FileReader(new File(filename));//makes a filereader object
			BufferedReader buf_reader = new BufferedReader(file_reader);//makes a buffered reader object
			String line = "";//blank string line, good variable to use later

			while((line = buf_reader.readLine()) != null){//if the line read in isn't null

				String[] data = line.split(","); // in the input file, attributes are separated by ","

				if(data.length>=2){//if the amount of words equals or is greater than two

					String name = data[0].replaceAll(" ", "");//replace the space
					String nameToLowerCase = name.toLowerCase();//make it lower case
					String phoneNumber = data[1].replaceAll(" ", "");
					addPerson(nameToLowerCase, phoneNumber);//add the person to this tree

				}

				// ** TO DO ** Add a new name to the tree by calling your add person method (from your tree operation class)
			}

			buf_reader.close();//never leave this open, never
		}
		catch(IOException e){//told you we'd catch you
			e.printStackTrace();//show where you fell
		}

		return root;//return the root
	}



}
