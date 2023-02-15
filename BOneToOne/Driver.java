package BOneToOne;
import javax.persistence.*;

@Entity
class Adharcard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Aid;
	String Anumber;
	String address;
	@OneToOne
	Person p;

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	public int getAid() {
		return Aid;
	}

	public void setPid(int Aid) {
		this.Aid = Aid;
	}

	public String getAnumber() {
		return Anumber;
	}

	public void setAnumber(String Anumber) {
		this.Anumber = Anumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

@Entity
class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	@OneToOne
	Adharcard a;

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

	public Adharcard getA() {
		return a;
	}

	public void setA(Adharcard a) {
		this.a = a;
	}
}

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Adharcard adharcard = new Adharcard();
		adharcard.setAddress("Bengaluru");
		adharcard.setAnumber("12Beng42");

		Person person = new Person();
		person.setName("Nithin");

		person.setA(adharcard);
		adharcard.setP(person);

		entityTransaction.begin();
		entityManager.persist(adharcard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
}