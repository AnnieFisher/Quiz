package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Users;

public class UsersTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("QuizJPA");
		em = emf.createEntityManager();
	}

	@Test
	public void test() {
		Users user= em.find(Users.class, 1);
		assertEquals("fisha26", user.getUsername());
		assertEquals("password", user.getPassword());
		
	}
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
