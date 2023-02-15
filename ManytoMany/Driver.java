package ManytoMany;

import java.util.*;
import javax.persistence.*;

@Entity
class Traveller {
	@Id
	String tname;
	@ManyToMany
	List<TouristPlace> p;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public List<TouristPlace> getP() {
		return p;
	}

	public void setP(List<TouristPlace> p) {
		this.p = p;
	}

}

@Entity
class TouristPlace {
	@Id
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Driver {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		TouristPlace place = new TouristPlace();
		place.setName("Udupi");

		TouristPlace place1 = new TouristPlace();
		place1.setName("Agumbe");

		TouristPlace place2 = new TouristPlace();
		place2.setName("Mysuru");

		List<TouristPlace> l = new ArrayList<TouristPlace>();
		l.add(place2);
		l.add(place1);
		l.add(place);

		Traveller t = new Traveller();
		t.setTname("ramesh");
		t.setP(l);

		Traveller t2 = new Traveller();
		t2.setTname("suresh");
		t2.setP(l);

		Traveller t3 = new Traveller();
		t3.setTname("lokesh");
		t3.setP(l);

		entityTransaction.begin();
		entityManager.persist(place);
		entityManager.persist(place1);
		entityManager.persist(place2);
		entityManager.persist(t);
		entityManager.persist(t2);
		entityManager.persist(t3);
		entityTransaction.commit();

	}
}