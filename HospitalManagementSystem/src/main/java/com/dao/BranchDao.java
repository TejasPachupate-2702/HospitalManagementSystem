package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Branch;
import com.entity.Hospital;
import com.util.DbConnection;

public class BranchDao {

	public static void addBranch(Branch b) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(b);
		et.commit();
	}

	public static void findAllBranch() {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		String jpql = "Select b from Branch b";
		et.begin();
		Query query = em.createQuery(jpql);
		List li = query.getResultList();
		System.out.println(li);
		et.commit();
	}

	public static void DeleteBranchById(int id) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Branch br = em.find(Branch.class, id);
		em.remove(br);
		et.commit();

	}

	public static void findAllHospitalDetailofBranch(int id) {
		EntityManager em = DbConnection.getConnection();
		EntityTransaction et = em.getTransaction();

		String jpql = "Select br from Branch br where br.branch_id=?1";
		et.begin();
		Query query = em.createQuery(jpql);
		query.setParameter(1, id);
		List li = query.getResultList();
		System.out.println(li);
		et.commit();

	}

}
