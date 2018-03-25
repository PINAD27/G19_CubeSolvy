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
    return cube[pos];
  }

  public boolean isValid(){
    //front right left back
    boolean sides = new boolean[size()]; //stores the validation of all cubes
    for(int i = 0; i < size()-1; i++){
      sides[i] = validate(i);
    }
    boolean valid = true;
    for(int j = 0; j < sides.length; j++){
      if(sides[j] == false){
        valid = false;
        break;
      }
    }
    return valid;
  }

  public boolean validate(int pos){
    Cube c = getCube(pos);
    for(int i = 1; i < (size()-pos); i++){
      boolean f = c.getFront() != cubes[i].getFront();
      boolean r = c.getRight() != cubes[i].getRight();
      boolean l = c.getLeft() != cubes[i].getLeft();
      boolean b = c.getBack() != cubes[i].getBack();
    }
    return f == r == l == b;
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




    callsToIsValid++;
    return true;
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
