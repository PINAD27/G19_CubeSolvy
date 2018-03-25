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
    return cube[pos];
  }

  public boolean isValid(){

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
