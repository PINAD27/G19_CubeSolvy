public class Cube{

	// private static class State{ // class to store state
	// 	public Color[] in;
	// 	public State(Color[] in){
	// 		this.in = in;
	// 	}
	// 	public void print(){
	// 		for(int i = 0; i < 6; i++){
	// 			System.out.println(in[i]);
	// 		}
	// 	}
	// }

	private Color[] faces = new Color[6];
  private int rotations;
	private int[] initial;
	//private State[] states = new State[24]; //stores cube states
  private String[] order = (new String[]{"I","R","R","R","RR","R","R","R","RR","R","R","R","LR","R","R","R","LR","R","R","R","RR","R","R","R"});


	public Cube(Color[] faces){
		this.initial = new int[6];
    this.rotations=0;
    for (int i =0;i<faces.length;i++){
      if(faces[i]== Color.BLUE){
        initial[i]=1;
      }
      else if(faces[i]== Color.RED){
        initial[i]=2;
      }
      else if(faces[i]== Color.GREEN){
        initial[i]=3;
      }
      else{
        initial[i]=4;
      }
    }
    Color[] temp = faces;
		this.faces = temp;
  }

	public Cube(Cube other){ //copied cube
		Cube c = other.copy();
		this.initial = c.initial;
		this.rotations = c.rotations;
		this.faces = c.faces;
	 }


  public boolean hasNext(){
    return this.rotations < 23;
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
     for (int i =0;i<faces.length;i++){
      if(initial[i]==1){
        faces[i]=Color.BLUE;
      }
      else if(initial[i]==2){
        faces[i]= Color.RED;
      }
      else if(initial[i]==3){
        faces[i]= Color.GREEN;
      }
      else{
        faces[i]= Color.WHITE;
      }
    }

  }

	public void setInitial(int[] s){
		this.initial = s;
	}

	public void setRotations(int r){
		this.rotations = r;
	}


	public Cube copy(){ //cube copy
		Cube c;
		int c_rotations = this.rotations;
		int temp[] = new int[6];
		Color[] c_faces = new Color[6];
		int[] c_initial = new int[6];

		for (int i =0;i<faces.length;i++){
      if(faces[i]== Color.BLUE){
        temp[i]=1;
      }
      else if(faces[i]== Color.RED){
        temp[i]=2;
      }
      else if(faces[i]== Color.GREEN){
        temp[i]=3;
      }
      else{
        temp[i]=4;
      }
    }

		for (int i =0;i<temp.length;i++){
		 if(temp[i]==1){
			 c_faces[i]=Color.BLUE;
		 }
		 else if(temp[i]==2){
			 c_faces[i]= Color.RED;
		 }
		 else if(temp[i]==3){
			 c_faces[i]= Color.GREEN;
		 }
		 else{
			 c_faces[i]= Color.WHITE;
		 }
	 }

		for(int i = 0; i < 6; i++){
			c_initial[i] = initial[i];
		}
		c = new Cube(c_faces);
		c.setInitial(c_initial);
		c.setRotations(c_rotations);
		return c;
	}

public static void main(String[] args) {
	 Cube c,z,o;
	 c = new Cube ( new Color [] { Color.RED, Color.RED, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
   z= new Cube ( new Color [] { Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.RED, Color.BLUE});
	 o= new Cube ( new Color [] { Color.BLUE, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.WHITE});
   Cube[] cubes = new Cube[4];
   for (int i=0;i<4;i++){
    cubes[i]=c;
   }

   // int count = 0;
   // while(count++ < 24){
   //   c.next();
   //   System.out.println(c);
   // }
	 // c.Identity();
	 // System.out.println(c);
	 // Cube l = c.copy();
	 // l.Rotate();
	 // System.out.println("C:\n"  + c + "\nL:" + l);

   // System.out.println("gsfdfdsfasfsfdsafdsafdsfasf");
   Solution s = new Solution(cubes);
   Cube[] g = new Cube [2];
   g[0]=c;
	 g[1] = o;
   Solution p = new Solution (g);
   // System.out.println(s.isValid());
   System.out.println(p.isValid(z));
   // System.out.println(s);
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
