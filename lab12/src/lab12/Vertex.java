package lab12;

import java.util.ArrayList;

public class Vertex {
	
	private String color;
	ArrayList<Integer> d ;
	private int i;
	
	
	public Vertex(int i, int j,String color) {
		d = new ArrayList<Integer>();
		this.i=i;
		this.d.add(j);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString(){
		return i+" "+ color;
		
	}

}
