package champollion;

import static champollion.Typeintervention.CM;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rbastide
 */
public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Intervention e,e2 ;
        Salle salle1 ;
		
	@Before
	public void setUp() throws ParseException {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                salle1 = new Salle ("B012", 30);
                Date date = new SimpleDateFormat("dd/mm/yyyy").parse("12/11/2015");
                Date date2 = new SimpleDateFormat("dd/mm/yyyy").parse("22/01/2015");
                e = new Intervention(date, 2, false, uml, salle1,CM);
                e2 = new Intervention(date2, 4, false, java, salle1,CM);
	}
	
        @Test 
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 0, 10, 3);
            untel.ajouteEnseignement(java, 2, 4, 0);
            assertEquals(19, untel.heuresPrevues(), 0.001f);
        }

        @Test
        public void testHeuresPrevuesPourUE(){
            untel.ajouteEnseignement(uml, 0, 10, 3);
            untel.ajouteEnseignement(java, 2, 4, 0);
            assertEquals(7, untel.heuresPrevuesPourUE(java), 0.001f);
        }
        
	@Test
	public void testNouvelEnseignantSansService() {
		// Le dernier paramètre représente la "marge d'erreur" acceptable
		assertEquals(0, untel.heuresPrevues(), 0.001f);
	}
	
	@Test
	public void testajouterHeures() {
		untel.ajouteEnseignement(uml, 0, 10, 0);
		// Il a maintenant 10 heures prévues pour cette UE
		assertEquals(10, untel.heuresPrevuesPourUE(uml), 0.001f);
		untel.ajouteEnseignement(uml, 0, 20, 0);
		// Il a maintenant 20 heures prévues pour cette UE
		assertEquals(20, untel.heuresPrevuesPourUE(uml), 0.001f);
                untel.ajouteEnseignement(uml, 5, 3, 2);
                assertEquals(12, untel.heuresPrevuesPourUE(uml),0.001f );
		
	}
        
        @Test
        public void testSousService (){
            untel.ajouteEnseignement(uml, 2, 8, 4);
            untel.ajouterIntervention(e);
            assertEquals(true, untel.enSousService());
        }
	
        
        @Test
        public void  testHeurePlannifiees(){
            untel.ajouterIntervention(e);
            untel.ajouterIntervention(e2);
            assertEquals(9, untel.heurePlannifiees(), 0.001f);
            
        }
}
