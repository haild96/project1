package main;

import java.util.ArrayList;

public class Main{
	static int INFINITY = 99999; 
	static String result="";
public static void main(String []agrs) {
	new DrawGraphics();
}
public static void bellmanford(Graph g, int source,int end) {
	System.out.println("s:"+source+"end:"+end);
	for(int i =0;i<g.getEdges().size();i++) {
		System.out.println("f: "+g.getEdges().get(i).getFirstPoint()+"l:"+g.getEdges().get(i).getLastPoint()+"w:"+g.getEdges().get(i).getWeight());
	}
	
	int i, j, u, v, w;
	int tV = g.getV(); //tổng số đỉnh của đồ thị
	int tE = g.getE(); //tổng số cạnh

	int d[] = new int[tV];  
	int p[] = new int[tV]; 

	for (i = 0; i < tV; i++) {
		d[i] = INFINITY;
		p[i] = 0;
	}
	
	d[source] = 0;
	
	for(i = 0; i <tV-1; i++) {
		for(j = 0; j < tE; j++) {
			//get data
			u = g.getEdges().get(j).getFirstPoint();
			v = g.getEdges().get(j).getLastPoint();
			w = g.getEdges().get(j).getWeight();
			
			if(d[u] != INFINITY && d[v] > d[u] + w) {
				d[v] = d[u] + w;
				p[v] = u;
			}
		}
	}
	for(i = 0; i < tE; i++) {
		u = g.getEdges().get(i).getFirstPoint();
		v = g.getEdges().get(i).getLastPoint();
		w = g.getEdges().get(i).getWeight();
		if(d[u] != INFINITY && d[v] > d[u] + w) {
			System.out.println("Đồ thị chứa chu trình âm");
			result="Đồ thị chứa chu trình âm";
			return;
		}
	}
	for(int i1=0;i1<p.length;i1++) {
		System.out.println(p[i1]+"|");
	}
	timduong(p,source,end);
	
}
private static void timduong(int[] p,int source, int end) {
	result="";
	int i =end;
	ArrayList roadlist = new ArrayList<>();
	roadlist.add(end);
	while(p[i] !=source) {
		i=p[i];
		roadlist.add(i);
	}
	roadlist.add(source);
	for(int j=roadlist.size()-1;j>0;j--) {
		int temp = (int) roadlist.get(j)+1;
		String kq =temp+" -> ";
		result+=kq;
	}
	result+=(end+1)+"";
}

}