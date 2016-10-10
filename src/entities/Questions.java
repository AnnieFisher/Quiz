package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Questions")
	private int id;

	private String questionsText;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Questions",referencedColumnName="id_Questions",  nullable =false)
	private Set<Answers> answers;

	@ManyToOne
	@JoinColumn(name = "quiz_id", referencedColumnName = "idQuizes")
	@JsonBackReference
	private Quizes quiz;

	public int getId() {
		return id;
	}

	public String getQuestionsText() {
		return questionsText;
	}

	public void setQuestionsText(String questionsText) {
		this.questionsText = questionsText;
	}

	public Set<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}

	public Quizes getQuiz() {
		return quiz;
	}

	public void setQuiz(Quizes quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", questionsText=" + questionsText + ", quiz=" + quiz + "]";
	}


	
}
