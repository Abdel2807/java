package livreur;
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
		boolean estidentifiť=false ;
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
					 estidentifiť=true ;
				 }
				 
				} finally {
					System.out.print(estidentifiť);
						
					}
				}
			}
			
		}
	public class recherche {
		public  int  rechercher (String a , int i) {
			String pathfile="src/identificationClient.txt";
			String line=" ";
			int yest=0 ;
			try {
				BufferedReader br= new BufferedReader(new FileReader(pathfile));
				String[] columns = null ;
				while(br.ready()) {
				line=br.readLine();
				columns = line.split(";");
				if(a.equals(columns[i])) {
					yest = 1;
					
				}
				System.out.println(yest);
				br.close();
				}
				
				return yest ;
				
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File not Found");
			}catch(IOException e) {
				e.printStackTrace();
			}
			return yest ;
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
}