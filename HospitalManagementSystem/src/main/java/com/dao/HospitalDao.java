package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Hospital;
import com.util.DbConnection;

public class HospitalDao {

	public static void addHospital(Hospital h) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(h);
		et.commit();
	}

	public static void findAllHospital() {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		String jpql = "Select h from Hospital h";
		et.begin();
		Query query = em.createQuery(jpql);
		List li = query.getResultList();
		System.out.println(li);
		et.commit();
	}

	public static void DeleteHospitalById(int id) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Hospital h = em.find(Hospital.class, id);
		em.remove(h);
		et.commit();

	}

	public static void findAllPatientOfParticularHos(int id) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		String jpql = "Select h from Hospital h where h. hospital_id=?1";
		et.begin();
		Query query = em.createQuery(jpql);
		query.setParameter(1, id);
		List li = query.getResultList();
		System.out.println(li);
		et.commit();

	}

}
