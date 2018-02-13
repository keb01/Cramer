package jUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.MagasinDAO;
import Model.ArticleDAO;


public class TestJunit {

	@Test
	public void test() {
		MagasinDAO mg = new MagasinDAO();
		assertNotNull((mg.getAllMagasins()).get(0));
		assertEquals(97,mg.getAllMagasins().size());
		//ArrayList<Magasin> liste = new ArrayList<Magasin>();
		assertNotNull((mg.find(1)));
		assertNotNull((mg.getCategorieMagasin()));
		assertEquals(32,mg.getCategorieMagasin().size());
		
		
		ArticleDAO pro = new ArticleDAO();
		//test: le produit 1 existe bien
		assertNotNull((pro.find(1)));
		//test: le produit 1 existe bien et se trouve dans le magasin 1
		assertNotNull((pro.findInMagasin(1,1)));
		
	}
	

}
