package cgginterns.hybernate.map1;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo1{
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		// creating a question object
		Question q = new Question();
		q.setQuestionId(1212);
		q.setQuestion("what is java");
		Answer a = new Answer();
		a.setAnswerId(343);
		a.setAnswer("java is programming language");
		a.setQuestion(q);
		Answer a1 = new Answer();
		a1.setAnswerId(344);
		a1.setAnswer("java is platform independent language");
		a1.setQuestion(q);
		Answer a2 = new Answer();
		a2.setAnswerId(345);
		a2.setAnswer("java is high level  language");
		a2.setQuestion(q);
		ArrayList<Answer> list = new ArrayList<>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		q.setAnswer(list);
		//creating another question object
		Question q1 = new Question();
		q1.setQuestionId(234);
		q1.setQuestion("what is netbeans");
		//creating the answer object 
		Answer a4 = new Answer();
		a4.setAnswerId(346);
		a4.setAnswer("it is ide");
		a4.setQuestion(q1);
		Answer a5 = new Answer();
		a5.setAnswerId(347);
		a5.setAnswer("it is easy to use");
		a5.setQuestion(q1);
		Answer a6 = new Answer();
		a6.setAnswerId(348);
		a6.setAnswer("something");
		a6.setQuestion(q1);
		ArrayList<Answer> list1 = new ArrayList<>();
		list.add(a4);
		list.add(a5);
		list.add(a6);
		q.setAnswer(list1);
		Session session = factory.openSession();
		session.beginTransaction();
		//saving answers
		session.save(q);
		session.save(a);
		session.save(a1);
		session.save(a2);
		session.save(q1);
		session.save(a4);
		session.save(a5);
		session.save(a6);
		session.getTransaction().commit();
//		Question question = (Question)session.get(Question.class, 1212);
//		System.out.println(question.getQuestion());	
//		ArrayList<Answer> answers = question.getAnswer();
//		for(Answer answer:answers) {
//			System.out.println(answer.getAnswer());
//		}
		session.close();
		factory.close();
	}
}
