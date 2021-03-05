
public class Book{

	String ISBN;//string parameter that holds the books isbn number
	String title;//string parameter that holds the books title
	String author;//string parameter that holds the books author
	String year;//string parameter that holds the books title
	String publisher;	//string parameter that holds the books publisher
	String imageURL1;//the professor told me i dont need to worry about the image urls
	String imageURL2;//the three image urls are the same image three times in three different sizes
	String imageURL3;//the three sizes are small mdeium and large


	public Book(String ISBN,String title,String author,String year,String publisher){
		//String imageURL1,String imageURL2,String imageURL3
		this.ISBN = ISBN;//uses this keyword to assign ISBN parameter passed in parameter list to global parameter with same name
		this.title = title;//uses this keyword to assign title parameter passed in parameter list to global parameter with same name
		this.author = author;//uses this keyword to assign author parameter passed in parameter list to global parameter with same name
		this.year = year;//uses this keyword to assign year parameter passed in parameter list to global parameter with same name
		this.publisher = publisher;//uses this keyword to assign publisher parameter passed in parameter list to global parameter with same name
		//		this.imageURL1 = imageURL1;
		//		this.imageURL2 = imageURL2;
		//		this.imageURL3 = imageURL3;
	}
	
	public Book(String ISBN,String title,String author,String year,String publisher,String imageURL1,String imageURL2,String imageURL3){
		this.ISBN = ISBN;//uses this keyword to assign ISBN parameter passed in parameter list to global parameter with same name
		this.title = title;//uses this keyword to assign title parameter passed in parameter list to global parameter with same name
		this.author = author;//uses this keyword to assign author parameter passed in parameter list to global parameter with same name
		this.year = year;//uses this keyword to assign year parameter passed in parameter list to global parameter with same name
		this.publisher = publisher;//uses this keyword to assign publisher parameter passed in parameter list to global parameter with same name
		this.imageURL1 = imageURL1;//uses this keyword to assign imageURL1 parameter passed in parameter list to global parameter with same name
		this.imageURL2 = imageURL2;//uses this keyword to assign imageURL2 parameter passed in parameter list to global parameter with same name
		this.imageURL3 = imageURL3;//uses this keyword to assign imageURL3 parameter passed in parameter list to global parameter with same name
	}


	
	public String toString(){
		return "ISBN: " + ISBN + ", " + "title: " + title + ", " + "author: " + author + ", " + "year: " + year + ", " + "publisher: " + publisher;
		
	}



}
