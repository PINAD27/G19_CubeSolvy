public class Cube{

	private static class State{ // class to store state
		public Color[] in;
		public State(Color[] in){
			this.in = in;
		}
		public void print(){
			for(int i = 0; i < 6; i++){
				System.out.println(in[i]);
			}
		}
	}

	private Color[] faces = new Color[6];
  private int rotations;
	private State initial;
	//private State[] states = new State[24]; //stores cube states
  private String[] order = (new String[]{"I","R","R","R","RR","R","R","R","RR","R","R","R","LR","R","R","R","LR","R","R","R","RR","R","R","R"});

	public enum Color {
		BLUE,RED,GREEN,WHITE
 	}

	public Cube(Color[] faces){
		this.initial = new State(faces);
		this.faces = faces;
  }

	public Cube(Cube other){ //copied cube
		Cube c = other.copy();
		this.faces = c.faces;
		this.rotations = c.rotations;
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
		rotations++;
  }

  	public void reset(){
			Identity();
  	}

  public void Rotate(){
    Color front = faces[1];
    Color right = faces[2];
    Color back = faces[3];
    Color left = faces[4];
    //front = left, right = front,  back = right, left = back
    faces[1] = left;
    faces[2] = front;
    faces[3] = right;
    faces[4] = back;
  }

  public void RightRoll(){
    Color up = faces[0];
    Color right = faces[2];
    Color left = faces[4];
    Color down = faces[5];
    //up = left, right = up, left = down, down = right
    faces[0] = left;
    faces[2] = up;
    faces[4] = down;
    faces[5] = right;
  }

  public void LeftRoll(){
    Color up = faces[0];
    Color right = faces[2];
    Color left = faces[4];
    Color down = faces[5];
    //up = right, right = down, left = up, down = left
    faces[0] = right;
    faces[2] = down;
    faces[4] = up;
    faces[5] = left;
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
    faces = initial.in;
  }

	public void setInitialState(State s){
		this.initial = s;
	}

	public void setRotations(int r){
		this.rotations = r;
	}


	public Cube copy(){ //cube copy
		Cube c;
		int c_rotations = this.rotations;
		Color[] c_faces = new Color[6];
		State c_initial = null;
		for(int i = 0; i < 6; i++){
			c_faces[i] = faces[i];
		}
		for(int i = 0; i < rotations; i++){
			c_initial.in[i] = initial.in[i];
		}
		c = new Cube(c_faces);
		c.setInitialState(c_initial);
		c.setRotations(c_rotations);
		return c;
	}

public static void main(String[] args) {
		Cube c;
	 c = new Cube ( new Color [] { Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}) ;

   int count = 0;
   while(count++ < 24){
     c.next();
     System.out.println(c);
   }
	 c.Identity();
	 System.out.println(c);
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
