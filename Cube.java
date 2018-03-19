public class Cube{
	private Color[] faces = new Color[6];

	public enum Color {
		BLUE,RED,GREEN,WHITE

 	}

	public Cube(Color[] faces){
		this.faces= faces;


	}
	public Color getUp(){
		return faces[0];
	}
	public Color getFront(){
		return faces[1];
	}
	public Color getRight(){
		return faces[2];
	}
	public Color getBack(){
		return faces[3];
	}
	public Color getLeft(){
		return faces[4];
	}
	public Color getDown(){
		return faces[5];
	}
	public String toString(){
		StringBuffer bf = new StringBuffer();
		String f;
		bf.append("[");
		for (int i = 0;i<faces.length;i++){
			if (i== faces.length-1){
				bf.append(faces[i]);
			}
			else{
				bf.append(faces[i]+",");
			}
		}
		bf.append("]");
		f= bf.toString();
		return f;


	}
	public static void main (String[] args){
		Cube c;
	 c = new Cube ( new Color [] { Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}) ;		
	 System.out.println(c);
	}






  
}
