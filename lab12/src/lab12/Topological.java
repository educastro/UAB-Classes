package lab12;

import java.util.ArrayList;

public class Topological {
	
			ArrayList top;
			
			public Topological(){
				top = new ArrayList<Vertex>();
			}
			public boolean unMarked(Graph G){
				
		    	for(Vertex X : G.vortex){
		    		if(X!=null)
		    		if(X.getColor()!="BLACK")
		    			return true;
		    	}
		    	return false;
		    }
			public Vertex getUnmarked(Graph G){

		    	for(Vertex X : G.vortex){
		    		if(X!=null)
		    		if(X.getColor()!="BLACK")
		    			return X;
		    	}
		    	return null;
			}
			
		    public void topological(Graph G){
		    	
		    	while(unMarked(G)){
		    		Vertex V= getUnmarked(G);
		    		visit(V,G);
		    	}
		    }
		    public void visit(Vertex V,Graph G){
		    	if(V==null) return;
		    	if(V.getColor() == "GRAY") return;
		    	if(V.getColor() == "WHITE"){
		    		V.setColor("GRAY");
		    		Vertex M = V;
		    		for(int i  = 0;i<G.vortex[V.getI()].d.size();i++){
		    			M = G.vortex[G.vortex[V.getI()].d.get(i)];
		    			visit(M,G);
		    		}
		    		V.setColor("BLACK");
		    		top.add(V);
		    	}
		    
		    }
		    public void printTopological(){
		    	for(int i=0;i< top.size();i++){
		    		System.out.print(top.get(i).toString());
		    		if(i!=top.size()-1)System.out.print("->");
		    	}
		    	System.out.println();
		    }

	}


