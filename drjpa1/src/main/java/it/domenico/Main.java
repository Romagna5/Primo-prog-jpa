package it.domenico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("domenicoMysql");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		create(1, "gaetano", 32);
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public static void create(int id, String colore, int cilindrata) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();

			Veicolo v = new Veicolo();
			v.setId(id);
			v.setColore(colore);
			v.setCilindrata(cilindrata);

			manager.persist(v);
			transaction.commit();
			
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}


	public static List<Veicolo> readAll() {

		List<Veicolo> students = null;

		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();
			
			students = manager.createNativeQuery("SELECT * FROM veicolo").getResultList();
			//students = manager.createQuery("SELECT s FROM veicolo s", Studente.class).getResultList();

			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
		return students;
	}


	public static void delete(int id) {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();

			Veicolo v = manager.find(Veicolo.class, id);

			manager.remove(v);

			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}


	public static void update(int id, String colore, int cilindrata) {

		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();
			transaction.begin();

			Veicolo v = manager.find(Veicolo.class, id);
			v.setColore(colore);
			v.setCilindrata(cilindrata);
			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

}
