package Museum;

public class Painting extends Art {

		private String paintType;
		
		public Painting(String title,String author, String description, String paintType) {
			super(title, author, description);
			this.paintType=paintType;
			
		}

		@Override
		public void viewArt() {
			String resultString="";// TODO Auto-generated method stub
			resultString+="Title:      "+ getTitle()+"\n";
			resultString+="Author:      "+ getAuthor()+"\n";
			resultString+="Description:      "+ getDescription()+"\n";
			resultString+="PaintType:      "+ paintType+"\n";
			System.out.println(resultString);
			
		}

		public String getPaintType() {
			return paintType;
		}

		public void setPaintTypeString(String paintTypeString) {
			this.paintType = paintTypeString;
		}
		
		
		
}



