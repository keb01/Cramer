package Prototype;

public class Application {
	public static void main(String[] args) {
	MagasinDAO DAOp = new MagasinDAO();
	Magasin p1 = DAOp.find(1);
	DAOp.getListeProduit(p1);
	
	for( Produit p : p1.getListeProduits() ){
		System.out.println(p.getNom());

	}
	
	
		}
}
