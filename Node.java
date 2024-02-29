package pkg;
	
public class Node 
{
	int data;
	int edges;
	Node[]edge= new Node[3];
	Node next;
	Node prev;
	      
	Node(int data)
	{
	    this.data = data;
	    edge[1] = null;
	    edges=2;
	}
}