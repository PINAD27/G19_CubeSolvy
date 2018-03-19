public class Cube{
	private Color[] faces = new Color[6];
  public static final Queue<Cube> queue = new LinkedQueue<Cube>(); //MAKE PRIVATE LATER DELETEm
  private int rotations;
  private String[] order = (new String[]{"I","R","R","R","RR","R","R","R","RR","R","R","R","LR","R","R","R","LR","R","R","R","RR","R","R","R"});

	public enum Color {
		BLUE,RED,GREEN,WHITE
 	}

	public Cube(Color[] faces){

		this.faces = faces;
    Cube c = this;
    queue.enqueue(c);
  }

  public boolean hasNext(){
    return rotations < 23;
  }

  public void next() throws IllegalStateException{
    if(order[rotations].equals("I")){
      Identity();
    }
    else if(order[rotations].equals("R")){
      Rotate();
    }
    else if(order[rotations].equals("RR")){
      RightRoll();
    }
    else if(order[rotations].equals("LR")){
      LeftRoll();
    }
    else{
      throw new IllegalStateException();
    }
  }
  /*
  public void reset(){


  }
  */

  public void Rotate(){
    Color rotated[] = faces;
    Color front = rotated[1];
    Color right = rotated[2];
    Color back = rotated[3];
    Color left = rotated[4];
    //front = left, right = front,  back = right, left = back
    rotated[1] = left;
    rotated[2] = front;
    rotated[3] = right;
    rotated[4] = back;
    Cube c = new Cube(rotated);
    queue.enqueue(c);
    rotations++;
  }

  public void RightRoll(){
    Color rotated[] = faces;
    Color up = rotated[0];
    Color right = rotated[2];
    Color left = rotated[4];
    Color down = rotated[5];
    //up = left, right = up, left = down, down = right
    rotated[0] = left;
    rotated[2] = up;
    rotated[4] = down;
    rotated[5] = right;
    Cube c = new Cube(rotated);
    queue.enqueue(c);
    rotations++;
  }

  public void LeftRoll(){
    Color rotated[] = faces;
    Color up = rotated[0];
    Color right = rotated[2];
    Color left = rotated[4];
    Color down = rotated[5];
    //up = right, right = down, left = up, down = left
    rotated[0] = right;
    rotated[2] = down;
    rotated[4] = up;
    rotated[5] = left;
    Cube c = new Cube(rotated);
    queue.enqueue(c);
    rotations++;
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

  public void Identity(){
    Cube c = queue.getFront();
    System.out.println("identin " + c);
    faces = c.faces;
  }

public static void main(String[] args) {
		Cube c;
	 c = new Cube ( new Color [] { Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}) ;
   int count = 0;
   while(count++ < 24){
     c.next();
     System.out.println(c);
   }
   /*
	 System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.RightRoll();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.RightRoll();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.LeftRoll();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.LeftRoll();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.RightRoll();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   c.Rotate();
   System.out.println(c);
   System.out.println(c.hasNext());

   System.out.println(c.queue);
   */

}


}
