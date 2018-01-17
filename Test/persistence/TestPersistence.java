package persistence;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import scoring.HighScores;
import scoring.Score;

public class TestPersistence {
	
	private HighScores hs;

	@Before
	public void setUp() throws Exception {
		hs = HighScores.getInstance();

	    // create scores
		Score s = new Score(0);
		Score s1 = new Score(1);
		Score s2 = new Score(-1);
		Score s3 = new Score(15);
		Score s4 = new Score(5);
		Score s5 = new Score(-3);

		s.setPlayer("BEN");
		s1.setPlayer("CALEB");
		s2.setPlayer("BRANDON");
		s3.setPlayer("MOM");
		s4.setPlayer("DAD");
		s5.setPlayer("RACHEL");
	    
	    // manage everything
	    hs.addScore(s);
	    hs.addScore(s1);
	    hs.addScore(s2);
	    hs.addScore(s3);
	    hs.addScore(s4);
	    hs.addScore(s5);
	}

	@After
	public void tearDown() throws Exception {
		hs.delete();
	}

	@Test
	public void test() {
		// initialize model file
	    PersistenceXStream.initializeModelManager("output"+File.separator+"test.xml");
	    // save model that is loaded during test setup
	    if (!PersistenceXStream.saveToXMLwithXStream(hs)) {
	        fail("Could not save file.");
	    }
	    
	    // clear the model in memory
	    hs.delete();
	    assertEquals(0, hs.getHighScores().size());

	    // load model
	    hs = (HighScores) PersistenceXStream.loadFromXMLwithXStream();
	    if (hs == null) {
	        fail("Could not load file.");
	    }
	    
	    // check scores
	    assertEquals(5, hs.getHighScores().size());
	    assertEquals("MOM", hs.getHighScore(0).getPlayer());
	    assertEquals("DAD", hs.getHighScore(1).getPlayer());
	}

}