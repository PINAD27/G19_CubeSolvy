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
    return cubes[pos];
  }

  public boolean isValid(){
   return true;  
  }

  public boolean isValid(Cube next){

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
