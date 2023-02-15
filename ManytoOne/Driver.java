package ManytoOne;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

@Entity
class Train{
	@Id
	String t_name;

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
}

@Entity
class Passenger{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@ManyToOne
	Train t;
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
	public Train getT() {
		return t;
	}
	public void setT(Train t) {
		this.t = t;
	}
}

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransactionaction =entityManager.getTransaction();
		
		Train train=new Train();
		train.setT_name("Shatabdi Express");
		
		Passenger p=new Passenger();
		p.setName("Nithin");
		p.setT(train);
		
		Passenger p2=new Passenger();
		p2.setName("Rahul");
		p2.setT(train);
		
		Passenger p3=new Passenger();
		p3.setName("Subba");
		p3.setT(train);
		
		entityTransactionaction.begin();
		entityManager.persist(train);
		entityManager.persist(p);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityTransactionaction.commit();
	}
}