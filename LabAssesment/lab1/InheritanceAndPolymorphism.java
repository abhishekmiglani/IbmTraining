package lab1;

public class InheritanceAndPolymorphism {
	public static void main(String[] args) {
		Book bk = new Book("101" , "Brothers" , "10" , "Unknown");
		System.out.println(bk.bookAuthor());
	}
}

abstract class Items {
	private String uid;
	private String title;
	private String noOfCopies;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(String noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Items [uid=" + uid + ", title=" + title + ", noOfCopies=" + noOfCopies + "]";
	}

	public Items(String uid, String title, String noOfCopies) {
		super();
		this.uid = uid;
		this.title = title;
		this.noOfCopies = noOfCopies;
	}

	public boolean equals(String s1, String s2) {

		if (s1.equals(s2))
			return true;
		else
			return false;
	}

	abstract int videoYearOfRelease();

	abstract String cdMusicalGenre();

	abstract String bookAuthor();

	abstract Items addItem();
}

abstract class WrittenItems extends Items {
	private String author;

	public String getDataAuthor() {
		return author;
	}

	public void setDataAuthor(String author) {
		this.author = author;
	}

	public WrittenItems(String uid, String title, String noOfCopies, String author) {
		super(uid, title, noOfCopies);
		this.author = author;
	}

	@Override
	public String toString() {
		return "WrittenItems [author=" + author + ", getUid()=" + getUid() + ", getTitle()=" + getTitle()
				+ ", getNoOfCopies()=" + getNoOfCopies() + ", toString()=" + super.toString()
				+ ", videoYearOfRelease()=" + videoYearOfRelease() + ", cdMusicalGenre()=" + cdMusicalGenre()
				+ ", bookAuthor()=" + bookAuthor() + ", addItem()=" + addItem() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}

class Book extends WrittenItems {

	public Book(String uid, String title, String noOfCopies, String author) {
		super(uid, title, noOfCopies, author);
		// TODO Auto-generated constructor stub
	}

	@Override
	int videoYearOfRelease() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String cdMusicalGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String bookAuthor() {
		// TODO Auto-generated method stub
		return getAuthor();
	}

	@Override
	Items addItem() {
		// TODO Auto-generated method stub
		return new Book(getUid(), getTitle(),  getNoOfCopies(),  getAuthor());
	}

	public boolean equals(String s1, String s2) {

		if (s1.equals(s2))
			return true;
		else
			return false;
	}

}

class JournalPaper extends WrittenItems {
	private int yearPublished;

	public JournalPaper(String uid, String title, String noOfCopies, String author) {
		super(uid, title, noOfCopies, author);
		// TODO Auto-generated constructor stub
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	int videoYearOfRelease() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String cdMusicalGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String bookAuthor() {
		// TODO Auto-generated method stub
		return getAuthor();
	}

	@Override
	Items addItem() {
		// TODO Auto-generated method stub
		return new JournalPaper(getUid(), getTitle(), getNoOfCopies(), getAuthor());
	}

	@Override
	public String toString() {
		return "JournalPaper [yearPublished=" + yearPublished + "]";
	}

	public boolean equals(String s1, String s2) {

		if (s1.equals(s2))
			return true;
		else
			return false;
	}

}

abstract class MediaItem extends Items {

	private int runTime;

	public int getRuntime() {
		return runTime;
	}

	public void setRuntime(int runtime) {
		this.runTime = runtime;
	}

	public MediaItem(String uid, String title, String noOfCopies) {
		super(uid, title, noOfCopies);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MediaItem [runTime=" + runTime + "]";
	}

	@Override
	public boolean equals(String s1, String s2) {

		if (s1.equals(s2))
			return true;
		else
			return false;
	}
}

class video extends MediaItem {
	private String director;
	private String genre;
	private int yearReleased;

	public video(String uid, String title, String noOfCopies, String director, String genre, int yearReleased) {
		super(uid, title, noOfCopies);
		this.director = director;
		this.genre = genre;
		this.yearReleased = yearReleased;
	}

	@Override
	int videoYearOfRelease() {
		// TODO Auto-generated method stub
		return yearReleased;
	}

	@Override
	String cdMusicalGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	@Override
	String bookAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Items addItem() {
		// TODO Auto-generated method stub
		return new video(getUid(), getTitle(), getNoOfCopies(), director, genre, yearReleased);
	}

}

class CD extends MediaItem {
	private String genre;
	private String artist;

	public CD(String uid, String title, String noOfCopies, String genre, String artist) {
		super(uid, title, noOfCopies);
		this.genre = genre;
		this.artist = artist;
	}

	@Override
	int videoYearOfRelease() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	String cdMusicalGenre() {
		// TODO Auto-generated method stub
		return getGenre();
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	String bookAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Items addItem() {
		// TODO Auto-generated method stub
		return new CD(getUid(), getTitle(), getNoOfCopies(), getGenre(), getArtist());
	}

}
