package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Scores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idScores")
	private int id;

//	@JoinColumn(name = "id_Quizes")
//	private int id_Quizes;

	private float value;

	@ManyToOne
	@JoinColumn(name="id_Quizes")
	@JsonBackReference (value ="quizScores")
	private Quizes quiz;
	
	@ManyToOne
	@JoinColumn(name = "id_Users")
	@JsonBackReference (value = "userScores")
	private Users user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Quizes getQuiz() {
		return quiz;
	}

	public void setQuiz(Quizes quiz) {
		this.quiz = quiz;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Scores [id=" + id + ", value=" + value + ", quiz=" + quiz + ", user=" + user + "]";
	}



}
