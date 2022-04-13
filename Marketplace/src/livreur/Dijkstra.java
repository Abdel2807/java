package livreur;
public class Dijkstra {
	 static class Graph{
		 int vertices;
		 int matrix[][];

		 public Graph(int vertex) {
		 this.vertices = vertex;
		 matrix = new int[vertex][vertex];
		 }

		 public void addEdge(int source, int destination, int weight) {
		 matrix[source][destination]=weight;

		 matrix[destination][source] = weight;
		 }

		 int getMinimumVertex(boolean [] mst, int [] key){
		 int minKey = Integer.MAX_VALUE;
		 int vertex = -1;
		 for (int i = 0; i <vertices ; i++) {
		 if(mst[i]==false && minKey>key[i]){
		 minKey = key[i];
		 vertex = i;
		 }
		 }
		 return vertex;
		 }

		 public void dijkstra_GetMinDistances(int sourceVertex){
		 boolean[] spt = new boolean[vertices];
		 int [] distance = new int[vertices];
		 int INFINITY = Integer.MAX_VALUE;

		 for (int i = 0; i <vertices ; i++) {
		 distance[i] = INFINITY;
		 }

		 distance[sourceVertex] = 0;

		 for (int i = 0; i <vertices ; i++) {

		 int vertex_U = getMinimumVertex(spt, distance);

		 spt[vertex_U] = true;

		 for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) {
		 if(matrix[vertex_U][vertex_V]>0)

		 if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY){
		

		 int newKey = matrix[vertex_U][vertex_V] + distance[vertex_U];
		 if(newKey<distance[vertex_V])
		 distance[vertex_V] = newKey;
		 }
		 }
		 }
		 }
		

		// printDijkstra(sourceVertex, distance);
		 

		 public void printDijkstra(int sourceVertex, int [] key){
			 String[] villes = {"Paris ","lyon" ,"nice","nantes","strasbourg","montpellier","lille","rennes","reims","saint-étienne","angers","grenoble","nimes","aix-en-provence" ," brest"};
		 System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
		 for (int i = 0; i <vertices ; i++) {
		 System.out.println("Pour aller de : " + villes[sourceVertex] + " à " +  villes[i] +
		 " distance: " + key[i]);
		 }
		 }
		 }

		 public static void optimiser() {
		 int vertices = 15;
		 Graph graph = new Graph(vertices);
		 int sourceVertex = 0;
		 //Paris
		 graph.addEdge(0, 1, 462);
		 graph.addEdge(0, 2, 931);
		 graph.addEdge(0, 3, 380);
		 graph.addEdge(0, 4, 488);
		 graph.addEdge(0, 5, 746);
		 graph.addEdge(0, 6, 219);
		 graph.addEdge(0, 7, 348);
		 graph.addEdge(0, 8, 143);
		 graph.addEdge(0, 9, 522);
		 graph.addEdge(0, 10, 293);
		 graph.addEdge(0, 11, 575);
		 graph.addEdge(0, 12, 710);
		 graph.addEdge(0, 13, 759);
		 graph.addEdge(0, 14, 589);
		 //lyon
		 graph.addEdge(1, 2, 472);
		 graph.addEdge(1, 3, 681);
		 graph.addEdge(1, 4, 494);
		 graph.addEdge(1, 5, 302);
		 graph.addEdge(1, 6, 689);
		 graph.addEdge(1, 7, 718);
		 graph.addEdge(1, 8, 487);
		 graph.addEdge(1, 9, 62);
		 graph.addEdge(1, 10, 594);
		 graph.addEdge(1, 11, 107);
		 graph.addEdge(1, 12, 251);
		 graph.addEdge(1, 13, 299);
		 graph.addEdge(1, 14, 970);
	     //	 nice
		 graph.addEdge(2, 3, 1143);
		 graph.addEdge(2, 4, 790);
		 graph.addEdge(2, 5, 326);
		 graph.addEdge(2, 6, 1157);
		 graph.addEdge(2, 7, 1186);
		 graph.addEdge(2, 8, 955);
		 graph.addEdge(2, 9, 490);
		 graph.addEdge(2, 10, 1062);
		 graph.addEdge(2, 11, 465);
		 graph.addEdge(2, 12, 279);
		 graph.addEdge(2, 13, 176);
		 graph.addEdge(2, 14, 1440);
		 //
		 graph.addEdge(3, 4, 860);
		 graph.addEdge(3, 5, 824);
		 graph.addEdge(3, 6, 597);
		 graph.addEdge(3, 7, 107);
		 graph.addEdge(3, 8, 515);
		 graph.addEdge(3, 9, 662);
		 graph.addEdge(3, 10, 88);
		 graph.addEdge(3, 11, 786);
		 graph.addEdge(3, 12, 874);
		 graph.addEdge(3, 13, 972);
		 graph.addEdge(3, 14, 296);
		 //nantes
		 graph.addEdge(4, 5, 791);
		 graph.addEdge(4, 6, 549);
		 graph.addEdge(4, 7, 827);
		 graph.addEdge(4, 8, 347);
		 graph.addEdge(4, 9, 550);
		 graph.addEdge(4, 10, 773);
		 graph.addEdge(4, 11, 533);
		 graph.addEdge(4, 12, 739);
		 graph.addEdge(4, 13, 787);
		 graph.addEdge(4, 14, 1069);
		 //strasbourg
		 graph.addEdge(5, 6, 963);
		 graph.addEdge(5, 7, 895);
		 graph.addEdge(5, 8, 787);
		 graph.addEdge(5, 9, 322);
		 graph.addEdge(5, 10, 771);
		 graph.addEdge(5, 11, 297);
		 graph.addEdge(5, 12, 56);
		 graph.addEdge(5, 13, 154);
		 graph.addEdge(5, 14, 1120);
		 //montpellier
		 graph.addEdge(6, 7, 572);
		 graph.addEdge(6, 8, 199);
		 graph.addEdge(6, 9, 749);
		 graph.addEdge(6, 10, 511);
		 graph.addEdge(6, 11, 803);
		 graph.addEdge(6, 12, 938);
		 graph.addEdge(6, 13, 986);
		 graph.addEdge(6, 14, 759);
		 //lille
		 graph.addEdge(7, 8, 483);
		 graph.addEdge(7, 9, 699);
		 graph.addEdge(7, 10, 126);
		 graph.addEdge(7, 11, 823);
		 graph.addEdge(7, 12, 948);
		 graph.addEdge(7, 13, 1013);
		 graph.addEdge(7, 14, 241);
		 //Rennes
		 graph.addEdge(8, 9, 546);
		 graph.addEdge(8, 10, 429);
		 graph.addEdge(8, 11, 600);
		 graph.addEdge(8, 12, 735);
		 graph.addEdge(8, 13, 783);
		 graph.addEdge(8, 14, 725);
		 //Reims
		 graph.addEdge(9, 10, 574);
		 graph.addEdge(9, 11, 155);
		 graph.addEdge(9, 12, 271);
		 graph.addEdge(9, 13, 319);
		 graph.addEdge(9, 14, 950);
		 //Saint-Etienne
		 graph.addEdge(10, 11, 700);
		 graph.addEdge(10, 12, 824);
		 graph.addEdge(10, 13, 890);
		 graph.addEdge(10, 14, 377);
		 //Angers
		 graph.addEdge(11, 12, 245);
		 graph.addEdge(11, 13, 293);
		 graph.addEdge(11, 14, 1075);
		 //Grenoble
		 graph.addEdge(12, 13, 108);
		 graph.addEdge(12, 14, 1169);
		 //nimes 
		 graph.addEdge(13, 14, 1127);
		 //aix en provence ... Brest
		 graph.dijkstra_GetMinDistances(sourceVertex);
		 }
		}