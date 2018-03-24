public class LinkedQueue<T> implements Queue<T>{

  private static class Elem<E>{ //Shielded class
    public E value;
    public Elem<E> next;

    public Elem(E value, Elem<E> next){
      this.value = value;
      this.next = next; //actually the one behind it
    }
  }

  private Elem<T> front;
  private Elem<T> rear;

  public LinkedQueue(){
    front = rear = null;
   }

  public boolean isEmpty(){
    return ((front == null) && (rear == null));
  }

  public void enqueue(T newElement){
    if(newElement == null){
      throw new NullPointerException("null pointer in queue");
    }
    Elem<T> newElem = new Elem<T>(newElement, null);
    if(isEmpty()){
      front = newElem;
      rear = newElem;
    } else{
      rear.next = newElem; //other elem type is rear, it's next pointer points to new elem
      rear = newElem; //rear elem type is now the newElem, it's next is currently null, will be reassigned when enqueue is called.
    }
  }

  public T dequeue(){
    if(isEmpty()){
      throw new IllegalStateException("empty queue");
    }
    Elem<T> outE = front;
    front = front.next;
    if(front == null){
      rear = null;
    }
    return outE.value;
  }

  public String toString() {

      StringBuffer returnedValue = new StringBuffer("[");

      if(!isEmpty()) {
          Elem<T> cursor = front;
          returnedValue.append(cursor.value);
          while(cursor.next != null) {
              cursor = cursor.next;
              returnedValue.append(", "  + cursor.value);
          }
      }

      returnedValue.append("]");
      return returnedValue.toString();

  }


  public T getFront(){
    return front.value;
  }
}
