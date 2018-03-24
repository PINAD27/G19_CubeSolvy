public class Solution{

  private Queue<Cube> cubes;
  private int callsToIsValid;

  public Solution(Cube[] cubes){
    this.cubes = new Queue<Cube>();
    if (cubes.length > 4){
      throw new IndexOutOfBoundsException("too many cubes passed");
    }
    for(int i = 0; i < cubes.length; i++){
      cube.enqueue(cubes[i].copy());
    }
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
