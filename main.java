package pkg;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
public class main 
{
	static Node head = null;
	static Node tail = null;
    static int tar = 1;
	public static void main(String[]args)
	{
		//creating the graph
		
		Node[]list = new Node[41];
		Node cur = new Node(1);
		head = cur;
		
		for (int i = 2; i <= 40; i++)
		{
			Node rn = new Node(i);
			cur.edge[0] = rn;
			rn.edge[1] = cur;
			cur = rn;
		}
		head.edge[1] = cur;
		cur.edge[0] = head;
		
		Node point = head;
		for (int i = 1; i < 41; i++)
		{
			list[i] = point;
			point = point.edge[0];
		}
		
		//adding 10 random edges to the graph
		System.out.println("10 Random Edges:");
		System.out.println("----------------");
		Random randI = new Random();
	    boolean[][]visited = new boolean[41][41];
	    int count = 0;
	    while (count < 10)
	    {
	    	int r1 = randI.nextInt(40)+1;
	 	    int r2 = randI.nextInt(40)+1;
	 	    if (list[r1].edges >= 3)
	 	    {
	 	    	for (int j = 0; j < visited.length; j++)
	 	    	{
	 	    		visited[j][r1] = true;
	 	    		visited[r1][j] = true;
	 	    	}
	 	    	continue;
	 	    }
	 	   if (list[r2].edges >= 3)
	 	    {
	 	    	for (int j = 0; j < visited.length; j++)
	 	    	{
	 	    		visited[j][r2] = true;
	 	    		visited[r2][j] = true;
	 	    	}
	 	    	continue;
	 	    }
	 	   if (visited[r1][r2] == true)
	 	   {
	 		   continue;
	 	   }
	 	   if (r1 == r2)
	 	   {
	 		   continue;
	 	   }

	 	   visited[r1][r2] = true;
	 	   visited[r2][r1] = true;
	 	   list[r1].edge[2] = list[r2];
	 	   list[r2].edge[2] = list[r1];
	 	   list[r1].edges++;
	 	   list[r2].edges++;
	 	   count++;
	 	   System.out.println(r1 + " <-> " + r2);
	    }
	    
	    //Printing Full Cycle Graph
	    
	    System.out.println();
	    System.out.println("Full Graph:");
	    System.out.println("-----------");
	    for (int i = 1; i < 41; i++)
	    {
	    	System.out.print("|" + list[i].data + "| ");
	    }
	    System.out.println();
	    for (int i = 1; i < 41; i++)
	    {
	    	if (list[i].edge[2] != null)
	    	{
	    		System.out.print("|"+list[i].edge[2].data+"| ");
	    	}
	    	else if( i > 10)
	    	{
	    		System.out.print("|  | ");
	    	}
	    	else
	    		System.out.print("| | ");
	    }
	    
	    System.out.println();
	    System.out.println();

	    //initialize step counters for Agent 0-7
	    int step0 = 0;
	    int step1 = 0;
	    int step2 = 0;
	    int step3 = 0;
	    int step4 = 0;
	    int step5 = 0;
	    int step6 = 0;
	    int step7 = 0;
	    
	    //run Agent 0
	    for (int i = 0; i < 100000; i++)
	    {
	    	tar = randI.nextInt(40)+1;
	    	step0 += a0(list);
	    }
	    
	    //run Agent 1
	    for (int i = 0; i < 100000; i++)
	    {
	    	  tar = randI.nextInt(40)+1;
	    	  step1 += a1(list);
	    }
	    
	    //run Agent 2
	    for (int i = 0; i < 100000; i++)
	    {
	    	tar = randI.nextInt(40)+1;
	    	step2 += a2(list);
	    }
	    
	    //run Agent 3
	    for (int i = 0; i < 100000; i++)
	    {
	    	  tar = randI.nextInt(40)+1;
	    	  step3 += a3(list);
	    }
	    
	    //run Agent 4
	    for (int i = 0; i < 100000; i++)
	    {
	    	  tar = randI.nextInt(40)+1;
	    	  step4 += a4(list);
	    }
	    
	    //run Agent 5
	    for (int i = 0; i < 100000; i++)
	    {
	    	  tar = randI.nextInt(40)+1;
	    	  step5 += a5(list);
	    }
	    
	    //run Agent 6
	    for (int i = 0; i < 100000; i++)
	    {
	    	  tar = randI.nextInt(40)+1;
	    	  step6 += a6(list);
	    }
	    
	    //run Agent 7
	    for (int i = 0; i < 100000; i++)
	    {
	    	  tar = randI.nextInt(40)+1;
	    	  step7 += a7(list);	 
	    }
	    
	    //Printing Trials
	    System.out.println("Average Steps Across 100000 Trials:");
	    System.out.println("-----------------------------------");
	    System.out.println("Agent 0: " + step0/100000);
	    System.out.println("Agent 1: " + step1/100000);
	    System.out.println("Agent 2: " + step2/100000);
	    System.out.println("Agent 3: " + step3/100000);
	    System.out.println("Agent 4: " + step4/100000);
	    System.out.println("Agent 5: " + step5/100000);
	    System.out.println("Agent 6: " + step6/100000);
	    System.out.println("Agent 7: " + step7/100000);
	    
	}
	
	public static int a0(Node list[])		//function to run Agent 0
	{
		int step = 0;
		Random randI = new Random();
		int agent = randI.nextInt(40)+1;
		
		while(!check(tar,agent))
		{
			move(list);
			step++;
		}
		
		return step;
	}
	
	public static int a1(Node list[])		//function to run Agent 1
	{
		int step = 0;
		Random randI = new Random();
		int agent = randI.nextInt(40)+1;
		
		while (!check(tar,agent))
		{
			move(list);
			agent = findShortestPathAndMove(agent, list, tar);
			step++;
		}
		return step;
	}
	
	public static int a2(Node list[])		//function to run Agent 2
	{
		int step = 0;
		Random randI = new Random();
		int agent = randI.nextInt(40)+1;
		double [] prob = new double[4];
		prob[0] = 0;
		
		while(!check(tar,agent))
		{
			move(list);
			for(int i = 1; i<list[tar].edges+1; i++)
			{
				prob[i] = 100/list[tar].edges;
			}
			tar = large(prob);
			agent = findShortestPathAndMove2(agent, list, tar);
			step++;
			for(int i = 0; i<4; i++)
			{
				prob[i] = 0;
			}
		}
		return step;
	}
	
	public static int a3(Node list[])		//function to run Agent 3
	{
		int step=0;
		Random randI = new Random();
		int agent=randI.nextInt(40)+1;
		while(!check(tar,agent))
		{
			move(list);
			step++;
		}
		return step;
	}
	
	public static int a4(Node list[])		//function to run Agent 4
	{	
		double[] prob= new double[41];
		for(int i=1;i<prob.length;i++)
		{
			prob[i]=1.0/40.0;
		}
		Random randI = new Random();
		int agent=randI.nextInt(40)+1;
		int step=0;
		while(!check(tar,agent))
		{
			move(list);
			redist(prob,prob[agent],agent);
			prob[agent]=0;
			agent=large(prob);	
			step++;
		}
		return step;
	}
	
	public static int a5(Node list[])		//function to run Agent 5
	{
		double[] prob= new double[41];
		for(int i=1;i<prob.length;i++)
		{
			prob[i]=1.0/40.0;
		}
		Random randI = new Random();
		int agent=randI.nextInt(40)+1;
		int step=0;

		while(!check(tar,agent))
		{
			move(list);
			redist2(prob,prob[agent],agent,list);
			prob[agent]=0;
			agent=large(prob);
			
			step++;
		}
		return step;
	}
	
	public static int a6(Node[] list)		//function to run Agent 6
	{
		double[] prob= new double[41];
		for(int i=1;i<prob.length;i++)
		{
			prob[i]=1.0/40.0;
		}
		Random randI = new Random();
		int agent=randI.nextInt(40)+1;
		int step=0;
		while(!check(tar,agent))
		{
			int check=large(prob);
			if(check(tar,check))
			{
				for(int i=0;i<prob.length;i++)
				{
					prob[i]=0;
				}
				prob[check]=1;
				agent=findShortestPathAndMove(agent,list,check);
			}
			else
			{
				redist(prob,prob[check]+prob[agent],check);
				prob[agent]=0;
				prob[check]=0;
				agent=findShortestPathAndMove(agent,list,large(prob));
			}
			if(agent==tar)
			{
				break;
			}
			move(list);
			step++;
		}
		return step;
	}
	
	public static int a7(Node[] list)		//function to run Agent 7
	{
		double[] prob = new double[41];
		for (int i = 1; i < prob.length; i++)
		{
			prob[i] = 1.0/40.0;
		}
		Random randI = new Random();
		int agent = randI.nextInt(40)+1;
		int step = 0;
		while (!check(tar,agent))
		{	
			redist2(prob,prob[agent],agent,list);
			prob[agent] = 0;
			int check = large(prob);
			if (check(tar,check))
			{
				for (int i = 0; i < prob.length; i++)
				{
					prob[i] = 0;
				}
				for (int i = 0; i < list[check].edges; i++)
				{
					prob[list[check].edge[i].data] = 1.0/list[check].edges;
				}
				agent = findShortestPathAndMove(agent,list,check);
			}
			else
			{
				agent = findShortestPathAndMove(agent,list,check);
			}
			step++;
			if(step > 1000)
			{
				System.out.println(tar+"| "+agent);
			}	
			if(agent == tar)
			{
				break;
			}
			move(list);
		}
		return step;	
	}
	
	public static int findShortestPathAndMove(int agent, Node list[], int target)		//search function to find shortest path to target and return next node agent should move to
	{
		LinkedList<Integer> queue = new LinkedList<Integer>();
		List<Integer> path = new ArrayList<Integer>();
        boolean visited[] = new boolean[41];
        int distance[] = new int [41];
        int tar = target;
        path.add(tar);
        for (int i = 0; i < 41; i++) 
        {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[agent] = 0;
        queue.add(agent);
        while (!queue.isEmpty()) 
        {
            int current = queue.remove();
        	if (visited[list[current].data] == false)
            for (int i = 0; i < list[current].edges; i++) 
            {
                    if(distance[list[current].edge[i].data] > distance[current]+1)
                    {
                    	distance[list[current].edge[i].data] = distance[current] + 1;
                    	queue.add(list[current].edge[i].data);
                    }
            }
        	visited[list[current].data] = true;
        }
        while(tar != agent)
        {
        	int min = Integer.MAX_VALUE;
        	int loc = 0;
        	for (int i = 0; i < list[tar].edges; i++)
        	{
        		if (distance[list[tar].edge[i].data] < min)
        		{
        			min = distance[list[tar].edge[i].data];
        			loc = list[tar].edge[i].data;
        		}
        	}
        	tar = loc;
        	path.add(loc);
        }
        if(path.size() <= 2)
        {
        	return path.get(0);
        }
        else
        	return path.get(path.size() - 2);
    }
	
	public static int findShortestPathAndMove2(int agent, Node list[], int target)		//search function to find shortest path to target and return next node agent should move to, specialized for Agent 2
	{
		LinkedList<Integer> queue = new LinkedList<Integer>();
		List<Integer> path = new ArrayList<Integer>();
        boolean visited[] = new boolean[41];
        int distance[] = new int [41];
        int tar = target;
        path.add(tar);
        for (int i = 0; i < 41; i++) 
        {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[agent] = 0;
        queue.add(agent);
        while (!queue.isEmpty()) 
        {
            int current = queue.remove();
        	if (visited[list[current].data] == false)
            for (int i = 0; i < list[current].edges; i++) 
            {
                    if(distance[list[current].edge[i].data] > distance[current]+1)
                    {
                    	distance[list[current].edge[i].data] = distance[current] + 1;
                    	queue.add(list[current].edge[i].data);
                    }
            }
        	visited[list[current].data] = true;
        }
        while(tar != agent)
        {
        	int min = Integer.MAX_VALUE;
        	int loc = 0;
        	for (int i = 0; i < list[tar].edges; i++)
        	{
        		if (distance[list[tar].edge[i].data] < min)
        		{
        			min = distance[list[tar].edge[i].data];
        			loc = list[tar].edge[i].data;
        		}
        	}
        	tar = loc;
        	path.add(loc);
        }
        if(path.size() <= 2)
        {
        	return path.get(0);
        }
        else
        	return path.get(path.size() - 2);
    }
	
	public static void redist2(double [] prob, double probo,int loc,Node[]list)			//function to redistribute the probability that target is at each node
	{
		HashSet<Integer> l = new HashSet<Integer>();
		double inc = probo/39;
		for (int i = 0; i < list[loc].edges; i++)
		{
			int edgess = list[loc].edge[i].edges;
			inc += (prob[list[loc].edge[i].data]/edgess)/(39.0-edgess);
			prob[list[loc].edge[i].data] -= (prob[list[loc].edge[i].data]/edgess);
			l.add(list[loc].edge[i].data);
		}
		
		for (int i = 1; i < prob.length; i++)
		{
			if (i != loc && !l.contains(i))
			prob[i] += inc;
		}
	}
	
	public static int large(double[]prob)			//function to find the node with the largest probability of having target
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		double max = prob[1];
		for (int i = 0; i < prob.length; i++)
		{
			if (prob[i] == max)
			{
				max = prob[i];
				list.add(i);
			}
			else if (prob[i] > max)
			{
				max = prob[i];
				list.clear();
				list.add(i);
			}
		}
		Random randI = new Random();
		int l = randI.nextInt(list.size());
		return list.get(l);
	}
	
	public static void redist(double [] prob, double probo,int loc)		//function to redistribute the probability that target is at each node
	{
		double inc = probo/39;
		for (int i = 1; i < prob.length; i++)
		{
			if(i != loc)
			prob[i] += inc;
		}
	}
	
	public static boolean check(int target, int agent)		//function to check whether the agent has found target or not
	{
		if(target == agent)
		{
			return true;
		}
		return false;
	}
	
	public static void move(Node list[])		//function to move the position of the target
	{
		Random randI = new Random();
		int random=randI.nextInt(list[tar].edges-1);
		tar = list[tar].edge[random].data;	
	}
}