package com.se.spring.dao;

import java.util.List;

import com.se.spring.entity.SinhVien;

public interface SinhVienDAO {
	public List<SinhVien> getSinhViens();
	public void saveSinhVien(SinhVien sinhVien);
	public SinhVien getSinhVien(int theId);
	public void deleteSinhVien(int theId);
	

}
