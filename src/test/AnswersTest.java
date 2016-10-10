package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Answers;

public class AnswersTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("QuizJPA");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		Answers answer= em.find(Answers.class, 1);
		assertEquals("30", answer.getAnswerText());
		assertEquals(false, answer.isCorrect());
	}
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}


}
