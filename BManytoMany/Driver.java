package BManytoMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Persistence;
@Entity
class Hospital {
	@Id
	String Hname;
	@ManyToMany
	List<Doctor>d;
	public String getHname() {
		return Hname;
	}
	public void setHname(String hname) {
		Hname = hname;
	}
	public List<Doctor> getD() {
		return d;
	}
	public void setD(List<Doctor> d) {
		this.d = d;
	}

}

@Entity
class Doctor {
	@Id
	String Dname;
		@ManyToMany
	List<Hospital>h;
		public String getDname() {
			return Dname;
		}
		public void setDname(String dname) {
			Dname = dname;
		}
		public List<Hospital> getH() {
			return h;
		}
		public void setH(List<Hospital> h) {
			this.h = h;
		}

		
		
}

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital h=new Hospital();
		h.setHname("Aster");
		
		Hospital h1=new Hospital();
		h1.setHname("Columbia Asia");
		
		Hospital h2=new Hospital();
		h2.setHname("HCG");
		
		List<Hospital>l=new ArrayList<Hospital>();
		
		l.add(h);
		l.add(h1);
		l.add(h2);
		
		Doctor Doctor=new Doctor();
		Doctor.setDname("Nithin");
		Doctor.setH(l);
		Doctor Doctor1=new Doctor();
		Doctor1.setDname("Akash");
		Doctor1.setH(l);
		Doctor Doctor2=new Doctor();
		Doctor2.setDname("Geetha");
		Doctor2.setH(l);
		
		List<Doctor>l1=new ArrayList<Doctor>();
		l1.add(Doctor);
		l1.add(Doctor1);
		l1.add(Doctor2);
		
		h.setD(l1);
		h2.setD(l1);
		h1.setD(l1);
		
		entityTransaction.begin();
		entityManager.persist(Doctor2);
		entityManager.persist(Doctor1);
		entityManager.persist(Doctor);
		entityManager.persist(h2);
		entityManager.persist(h1);
		entityManager.persist(h);
		entityTransaction.commit();

	}
}
