package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Hospital;
import com.entity.Patient;
import com.util.DbConnection;

public class PatientDao {

	public static void addPatient(Patient p) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
	}

	public static void findAllPatient() {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		String jpql = "Select p from Patient p";
		et.begin();
		Query query = em.createQuery(jpql);
		List li = query.getResultList();
		System.out.println(li);
		et.commit();
	}

	public static void DeletePatientById(int id) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Patient p = em.find(Patient.class, id);
		em.remove(p);
		et.commit();

	}

	public static void UpdatePatientHistory(int id, String h) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		String sql = "Update Patient set medicalhistory=?1 where patientid=?2";
		et.begin();
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, h);
		query.setParameter(2, id);
		query.executeUpdate();
		et.commit();

	}
}
