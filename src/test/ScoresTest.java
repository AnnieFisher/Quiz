package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Quizes;
import entities.Scores;
import entities.Users;

public class ScoresTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("QuizJPA");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		Scores score= em.find(Scores.class, 1);
		assertEquals(90.00, score.getValue(),.001);
				
	}
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}


}
