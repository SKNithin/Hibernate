package OnetoOne;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

@Entity
class PanCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	String pnumber;
	String address;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

@Entity
class Person1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@OneToOne
	PanCard p;

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

	public PanCard getP() {
		return p;
	}

	public void setP(PanCard p) {
		this.p = p;
	}

}

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory e = Persistence.createEntityManagerFactory("dev");
		EntityManager m = e.createEntityManager();
		EntityTransaction t = m.getTransaction();
		PanCard pan = new PanCard();
		pan.setAddress("Bengaluru");
		pan.setPnumber("1sk05g");

		Person1 person = new Person1();
		person.setName("Nithin");
		person.setP(pan);
		t.begin();
		m.persist(pan);
		m.persist(person);
		t.commit();
	}
}