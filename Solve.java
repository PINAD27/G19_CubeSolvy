public class Solve{

  // public enum Color {
	// 	BLUE,RED,GREEN,WHITE;
 	// }

  private static Queue<Solution> queue;
  private static Cube a = new Cube(new Color[]{Color.BLUE,Color.GREEN,Color.WHITE,Color.GREEN,Color.BLUE,Color.RED});
  private static Cube b = new Cube(new Color[]{Color.WHITE,Color.GREEN,Color.BLUE,Color.WHITE,Color.RED,Color.RED});
  private static Cube c = new Cube(new Color[]{Color.GREEN,Color.WHITE,Color.RED,Color.BLUE,Color.RED,Color.RED});
  private static Cube d = new Cube(new Color[]{Color.BLUE,Color.RED,Color.GREEN,Color.GREEN,Color.WHITE,Color.WHITE});
  public static Cube[] cubes =new Cube[]{a,b,c,d};

  public Solve(){
  queue = new LinkedQueue<Solution>();
 }

 public static Queue<Solution> generateAndTest(){
 	int count = 1;
   while (cubes[0].hasNext()){
   	cubes[0].next();
	cubes[1].setRotations(0);
   	while (cubes[1].hasNext()){

   		cubes[1].next();
   		cubes[2].setRotations(0);
   		while (cubes[2].hasNext()){

   			cubes[2].next();
   			cubes[3].setRotations(0);
   			while (cubes[3].hasNext()){

   				count ++;
   				cubes[3].next();
   				Cube[] temp = cubes.clone();

   				Solution p = new Solution(temp);
   				System.out.println(p.isValid)
   				if (p.isValid()){
   					queue.enqueue(p);
   				}

   			}
   		}
   	}

   }
   System.out.println(count);



   return queue;
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
 	System.out.println(s.generateAndTest());
 }

}
