package Museum;

public class Sculpture extends Art {
	private String material;
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void viewArt() {
		String resultString="";// TODO Auto-generated method stub
		resultString+="Title:      "+ getTitle()+"\n";
		resultString+="Author:      "+ getAuthor()+"\n";
		resultString+="Description:      "+ getDescription()+"\n";
		resultString+="PaintType:      "+ material+"\n";
		System.out.println(resultString);
		// TODO Auto-generated method stub
		
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	

}
