public class Solution{

  private Cube[] cubes;
  private Queue<Cube> queue;
  private int callsToIsValid;

  public Solution(Cube[] cubes){
    this.cubes = cubes;
    this.queue = new LinkedQueue<Cubes>;
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
