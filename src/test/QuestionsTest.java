package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Questions;

public class QuestionsTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("QuizJPA");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		Questions question= em.find(Questions.class, 1);
		assertEquals("How old am I?", question.getQuestionsText());
		
	}
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
