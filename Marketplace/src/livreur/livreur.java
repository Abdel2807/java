package livreur;
import java.io.*;
import java.util.*;
import individu.client;
import java.io.*;
import java.util.*;
import individu.client;

public class livreur  {
	public String vehicule ;
	
	livreur(String vehicule){
		this.vehicule=vehicule;
	}
	public String getvehicule() {
		return this.vehicule ;
	}
	
	public void s_identifier() {
		boolean estidentifié=false ;
		try  (Scanner identifiant = new Scanner(System.in)) {
			System.out.println("Entrez votre identifiant:");
			String id = identifiant.next(); 
			recherche rname = new recherche() ;
			rname.rechercher(id,0);
			int rep =rname.rechercher(id,0);
			if (rep == 1 ) {
				try {
					Scanner password = new Scanner(System.in);
					System.out.println("Entrez votre mot de passe:");
					String pass = password.next(); 
					recherche rpass = new recherche();
					rpass.rechercher(pass,1);
				 int rep2 = rpass.rechercher(pass, 1);
				 if (rep2 ==1 ) {
					 estidentifié=true ;
				 }
				 
				} finally {
					System.out.print(estidentifié);
						
					}
				}
			}
			
		}
	public void notifierclient(client c)  {
		Scanner scanclient = new Scanner(System.in);
		System.out.println("Entrez l'id du client:");
		int clid = scanclient.nextInt();
		scanclient.close();
		for(int i = 0 ; i< client.nosclients.size();i++) {
			if (client.getId(client.nosclients.get(i))==clid ) {
				client.nosclients.get(i).notification=1;
			}
			
		}
	}
	public void optimisertrajet() {
		Dijkstra.optimiser();
	}
}