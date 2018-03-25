public class Solve{

  // public enum Color {
	// 	BLUE,RED,GREEN,WHITE;
 	// }

  private static Queue<Solution> queue;
  private static Cube a = new Cube(new Color[]{Color.BLUE,Color.GREEN,Color.WHITE,Color.GREEN,Color.BLUE,Color.RED});
  private static Cube b = new Cube(new Color[]{Color.WHITE,Color.GREEN,Color.BLUE,Color.WHITE,Color.RED,Color.RED});
  private static Cube c = new Cube(new Color[]{Color.GREEN,Color.WHITE,Color.RED,Color.BLUE,Color.RED,Color.RED});
  private static Cube d = new Cube(new Color[]{Color.BLUE,Color.RED,Color.GREEN,Color.GREEN,Color.WHITE,Color.WHITE});
  private static Cube[] cubes =new Cube[]{a,b,c,d};

  public Solve(){
  queue = new LinkedQueue<Solution>();

 }

 public static Queue<Solution> generateAndTest(){
   for(int i = 0; i < 4; i++){
     while(cubes[i].hasNext()){
       cubes[i].next();
       Solution s = new Solution(cubes);
       if(s.isValid()){
         queue.enqueue(s);
       }
     }
   }
   return queue;
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
   System.out.println(generateAndTest());
 }

}
