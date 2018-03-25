public class Solution{

  private Cube[] cubes;
  private int callsToIsValid;

  public Solution(Cube[] cubes){
    if (cubes.length > 4){
      throw new IndexOutOfBoundsException("too many cubes passed");
    }
    this.cubes = cubes;
    this.callsToIsValid = 0
  }

  public Solution(Solution other, Cube[] cubes){
    if(cubes==null){
      throw new NullPointerException("Null element passed");
    }

  }

  public int size(){

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

    callsToIsValid++;
  }

  public String toString(){

  }

  public int getNumberOfCalls(){
    return callsToIsValid;
  }

  public void resetNumberOfCalls(){
    callsToIsValid = 0;
  }


}
