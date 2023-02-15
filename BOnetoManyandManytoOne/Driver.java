package BOnetoManyandManytoOne;

import java.util.*;
import javax.persistence.*;

@Entity
class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@OneToMany
	List<TwitterAccount> i;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TwitterAccount> getI() {
		return i;
	}

	public void setI(List<TwitterAccount> i) {
		this.i = i;
	}

}

@Entity
class TwitterAccount {
	@Id
	String Twname;
	@ManyToOne
	Student s;

	public String getTwname() {
		return Twname;
	}

	public void setTwname(String twname) {
		Twname = twname;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

}

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		student.setName("Nithin");
		
		TwitterAccount Account = new TwitterAccount();
		Account.setTwname("@Nithin");
		Account.setS(student);
		
		TwitterAccount Account2 = new TwitterAccount();
		Account2.setTwname("@NithinSK");
		Account2.setS(student);
		
		TwitterAccount Account3 = new TwitterAccount();
		Account3.setTwname("@NSK");
		Account3.setS(student);
		
		List<TwitterAccount> l = new ArrayList<TwitterAccount>();
		l.add(Account);
		l.add(Account2);
		l.add(Account3);
		
		student.setI(l);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(Account);
		entityManager.persist(Account2);
		entityManager.persist(Account3);
		entityTransaction.commit();

	}
}