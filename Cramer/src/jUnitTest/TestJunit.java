package jUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import Model.MagasinDAO;


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
	}

}
