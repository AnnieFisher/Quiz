package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Quizes;

public class QuizesTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("QuizJPA");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		Quizes quiz= em.find(Quizes.class, 1);
		assertEquals("first", quiz.getName());
		
	}
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
