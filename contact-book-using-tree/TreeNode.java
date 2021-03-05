
public class TreeNode {//tree node class

	char letterOfName;//the letter of the name in the tree node from a to z, also including a space character
	String phoneNumber;//give me ya digits
	TreeNode[] array = new TreeNode[27];//the node array of the children, cheaper by the 27?
	TreeNode parent;//need parent so you can traverse up and down paths with ease

	public TreeNode(char whatLetterShallIStore, String myDigits){//constructor for the treenode class
		//passed a char and the the phone number
		//only the last letter at the end of a name will store a number

		letterOfName = whatLetterShallIStore;//stores the letter passed in the constructor
		phoneNumber = myDigits;//stores the phone number passed in the constructor
	}

	public TreeNode[] getNodeArray(){//gets the children node array for a given node
		return array;
	}

	public TreeNode getParent(){//gets the momma node
		return parent;
	}

	public void setParent(TreeNode momma)//sets the momma node
	{
		parent = momma;
	}

	public void setCharacter(char a)//sets the character stored in a given node
	{
		letterOfName = a;		
	}

	public String getPhoneNumber()//gets the character stored in a given node
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String a)//sets the phone number for a given node
	{
		phoneNumber = a;
	}

	public int getChildren(){//counts many children a node has
		int howManyChildren = 0;//hopefully they can afford them all
		for(int i = 0;i<array.length;i++)//for loop that goes through each element in the array
		{
			if(array[i]!=null)//no null pointer exceptions please
			{howManyChildren++;}//if it isnt, then increment away
		}
		return howManyChildren;//how many children is how many times it increments
	}

	public char getCharacter()//gets the char of a given node
	{
		return letterOfName;//returns the char using a getter method
	}
}
