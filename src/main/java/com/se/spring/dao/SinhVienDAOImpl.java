package com.se.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.spring.entity.SinhVien;

@Repository
public class SinhVienDAOImpl implements SinhVienDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SinhVien> getSinhViens() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<SinhVien> theQuery = currentSession.createQuery("from SinhVien order by id", SinhVien.class);
		List<SinhVien> sinhViens = theQuery.getResultList();
		return sinhViens;
	}

	@Override
	public void saveSinhVien(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(sinhVien);
	}

	@Override
	public SinhVien getSinhVien(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		SinhVien theSinhVien = currentSession.get(SinhVien.class, theId);
		
		return theSinhVien;
	}

	@Override
	public void deleteSinhVien(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from SinhVien where id=:sinhVienId");
		theQuery.setParameter("sinhVienId", theId);
		theQuery.executeUpdate();

	}
	

}
