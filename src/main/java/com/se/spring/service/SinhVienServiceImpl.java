package com.se.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.spring.dao.SinhVienDAO;
import com.se.spring.entity.SinhVien;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	@Autowired
	private SinhVienDAO sinhVienDAO;
	
	@Override
	@Transactional
	public List<SinhVien> getSinhViens() {
		// TODO Auto-generated method stub
		return sinhVienDAO.getSinhViens();
	}

	@Override
	@Transactional
	public void saveSinhVien(SinhVien sinhVien) {
		// TODO Auto-generated method stub
		sinhVienDAO.saveSinhVien(sinhVien);
	}

	@Override
	@Transactional
	public SinhVien getSinhVien(int theId) {
		// TODO Auto-generated method stub
		return sinhVienDAO.getSinhVien(theId);
	}

	@Override
	@Transactional
	public void deleteSinhVien(int theId) {
		// TODO Auto-generated method stub
		sinhVienDAO.deleteSinhVien(theId);
		
	}

}
