public class Solve{

  // public enum Color {
	// 	BLUE,RED,GREEN,WHITE;
 	// }

  private static Queue<Solution> queue;
  private static Cube a;
  private static Cube b;
  private static Cube c;
  private static Cube d;
  private static Cube[] cubes;

  public Solve(){
  queue = new LinkedQueue<Solution>();
  a = new Cube(new Color[]{Color.BLUE,Color.GREEN,Color.WHITE,Color.GREEN,Color.BLUE,Color.RED});
  b = new Cube(new Color[]{Color.WHITE,Color.GREEN,Color.BLUE,Color.WHITE,Color.RED,Color.RED});
  c = new Cube(new Color[]{Color.GREEN,Color.WHITE,Color.RED,Color.BLUE,Color.RED,Color.RED});
  d = new Cube(new Color[]{Color.BLUE,Color.RED,Color.GREEN,Color.GREEN,Color.WHITE,Color.WHITE});
  cubes = new Cube[]{a,b,c,d};
 }

 public static Queue<Solution> generateAndTest(){
   int = 0;
   Queue<Solution> result = new LinkedQueue<Solution>();
   Solution s = new Solution(cubes);
   queue.enqueue(s);
   while(i < 24){

   }

   System.out.println(count);
   return result;
 }
 public Queue<Solution> breadthFirstSearch(){
   Queue<Solution> result = new LinkedQueue<Solution>();
   Queue<Solution> open = new LinkedQueue<Solution>();
   Queue<Solution> solutions = new LinkedQueue<Solution>();

   while(!open.isEmpty()){
     Solution current = open.dequeue();

   }
   return null;
 }

 public static void main(String[] args) {
   Solve s = new Solve();
   s.generateAndTest();
 }

}
