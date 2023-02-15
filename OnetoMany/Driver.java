package OnetoMany;
 
import java.util.*;
import javax.persistence.*;

@Entity
class Members {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	String pName;
	int pNumber;

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
}

@Entity
class Theatre {
	@Id
	String tName;
	@OneToMany
	List<Members> p;

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public List<Members> getP() {
		return p;
	}

	public void setP(List<Members> p) {
		this.p = p;
	}

}

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Members person1 = new Members();
		person1.setpName("Nithin");
		person1.setpNumber(123);
		
		Members person2 = new Members();
		person2.setpName("Mudit");
		person2.setpNumber(456);
		
		Members person3 = new Members();
		person3.setpName("rohit");
		person3.setpNumber(789);
		
		List<Members> l = new ArrayList<Members>();
		l.add(person1);
		l.add(person2);
		l.add(person3);

		Theatre theatre = new Theatre();
		theatre.settName("veeresh");
		theatre.setP(l);

		entityTransaction.begin();
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.persist(theatre);
		entityTransaction.commit();

	}
}