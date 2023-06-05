package cgginterns.hybernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating an object for Question Class

		Question q = new Question();

		q.setQuestionId(110);
		q.setQuestion("what is java?");

		// creating object for answer class

		Answer a = new Answer();
		a.setAnswerId(342);
		a.setAnswer("java is a programming language");
		q.setAnswer(a);
		a.setQuestion(q);

		Question q1 = new Question();

		q1.setQuestionId(243);
		q1.setQuestion("what is collection frameWork?");

		Answer a1 = new Answer();
		a1.setAnswerId(345);
		a1.setAnswer(" API to work with group of objects");
		q1.setAnswer(a1);
		a1.setQuestion(q1);

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(q);
		session.save(q1);
		session.save(a);
		session.save(a1);

		session.getTransaction().commit();
		
		//fetching Question
//		Question question = (Question)session.get(Question.class,110);
//		System.out.println(question.getQuestion());
//		System.out.println(question.getAnswer().getAnswer());
		
		//fetching question based on answer
		
		Answer ans = (Answer)session.get(Answer.class,345);
		System.out.println(ans.getAnswer());
		System.out.println(ans.getQuestion().getQuestion());
		session.close();
		factory.close();
	}
}
