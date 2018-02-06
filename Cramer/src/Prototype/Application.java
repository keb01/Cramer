package Prototype;

public class Application {
	public static void main(String[] args) {
	DAO<Produit> DAOp = new ProduitDAO();
	Produit p1 = DAOp.find(1);
	System.out.println(p1.getDescription());
	}
}
