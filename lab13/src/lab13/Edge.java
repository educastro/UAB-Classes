package lab13;

public class Edge {
	
	public int v1, v2;
	public int edgeID;
	public double edgeWeight;
	
	public Edge(int v1, int v2, double edgeWeight){
		this.v1 = v1;
		this.v2 = v2;
		this.edgeWeight = edgeWeight;
	}
	
	public int getV1() {
		return v1;
	}
	public void setV1(int v1) {
		this.v1 = v1;
	}
	public int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	public int getEdgeID() {
		return edgeID;
	}
	public void setEdgeID(int edgeID) {
		this.edgeID = edgeID;
	}
	public double getEdgeWeight() {
		return edgeWeight;
	}
	public void setEdgeWeight(double edgeWeight) {
		this.edgeWeight = edgeWeight;
	}
	
    public int other(int vertex) {
        if      (vertex == v1) return v2;
        else if (vertex == v2) return v1;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

}
