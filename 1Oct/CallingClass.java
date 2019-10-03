class ConstructDemo{
int id;
String name;
ConstructDemo(int id,String name){
	this.id=id;
	this.name=name;

}
	
}
class CallingClass{
	public static void main(String[] args) {
		ConstructDemo cd = new ConstructDemo(5,"pradeep");
		System.out.println(cd.id + " " + cd.name);
	}
}