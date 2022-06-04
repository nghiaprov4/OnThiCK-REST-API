package com.se.spring.service;

import java.util.List;

import com.se.spring.entity.SinhVien;

public interface SinhVienService {
	public List<SinhVien> getSinhViens();
	public void saveSinhVien(SinhVien sinhVien);
	public SinhVien getSinhVien(int theId);
	public void deleteSinhVien(int theId);
}
