public class Solution{

  private Cube[] cubes;
  private int callsToIsValid;

  public Solution(Cube[] cubes){
    if (cubes.length > 4){
      throw new IndexOutOfBoundsException("too many cubes passed");
    }
    this.cubes = cubes;
    this.callsToIsValid = 0;
  }

  public Solution(Solution other, Cube[] cubes){
    if(cubes==null){
      throw new NullPointerException("Null element passed");
    }

  }

  public int size(){
    return cubes.length;
  }

  public Cube getCube(int pos){
    if (pos > size()){
      throw new IndexOutOfBoundsException("position is out of bounds of the data struct");
    }
    return cubes[pos];
  }

  public boolean isValid(){
    //front right left back
    callsToIsValid++;
    boolean[] sides = new boolean[size()]; //stores the validation of all cubes
    for(int i = 0; i < size(); i++){
      sides[i] = validate(i);
      // System.out.println("SIDE: UNGH: " +sides[i]);
    }
    boolean valid = true;
    for(int j = 0; j < sides.length; j++){
      // System.out.println("SIDE: " + sides[j]);
      if(sides[j] == false){
        valid = false;
        break;
      }
    }
    // System.out.println("VALID :"  +valid);
    return valid;
  }

  public boolean validate(int pos){
    if(pos == size()-1) {
      return true;
    }
    Cube c = getCube(pos);
    boolean f,r,l,b;
    f = r = l = b = false;
    for(int i = 1; i < (size()-pos); i++){
      f = c.getFront() != cubes[i].getFront();
      r = c.getRight() != cubes[i].getRight();
      l = c.getLeft() != cubes[i].getLeft();
      b = c.getBack() != cubes[i].getBack();
    }
    // System.out.println("f: " + f + " r: " + r + " l: " + l + " b: " + b  );
    // System.out.println(f == true && r == true && l == true && b == true);
    return f == true && r == true && l == true && b == true;
  }

  public boolean isValid(Cube next){
    Cube[] temp = new Cube [cubes.length+1];
    Cube[] orig= new Cube [cubes.length];
    for (int i = 0;i<cubes.length;i++){
      temp[i]=cubes[i];
      orig[i]=cubes[i];
    }
    temp[cubes.length]=next;
    cubes=temp;
    boolean check=this.isValid();
    cubes= orig;
    return check;
  }

  public String toString(){
    StringBuffer res = new StringBuffer();
    for (int i=0;i<cubes.length;i++){
      res.append((i+1)+". "+cubes[i].toString()+"\n");
    }
    String s = res.toString();
    return s;



  }

  public int getNumberOfCalls(){
    return callsToIsValid;
  }

  public void resetNumberOfCalls(){
    callsToIsValid = 0;
  }


}
