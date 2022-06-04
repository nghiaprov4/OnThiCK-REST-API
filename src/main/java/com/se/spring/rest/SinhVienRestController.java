package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.SinhVien;
import com.se.spring.service.SinhVienService;

@RestController
@RequestMapping("/api")
public class SinhVienRestController {
	@Autowired
	private SinhVienService sinhVienService;
	
	@GetMapping("/sinhviens")
	public List<SinhVien> getSinhViens() {
		return sinhVienService.getSinhViens();
	}
	
	@GetMapping("/sinhviens/{sinhVienId}")
	public SinhVien getSinhVien(@PathVariable int sinhVienId) {
		
		SinhVien theSinhVien = sinhVienService.getSinhVien(sinhVienId);
		if (theSinhVien == null) {
			System.out.println("Loi");
		}
		return theSinhVien;
	}
	
	@PostMapping("/sinhviens")
	public SinhVien addSinhVien(@RequestBody SinhVien theSinhVien) {
		sinhVienService.saveSinhVien(theSinhVien);
		return theSinhVien;
	}

	@PutMapping("/sinhviens")
	public SinhVien updateSinhVien(@RequestBody SinhVien theSinhVien) {
		sinhVienService.saveSinhVien(theSinhVien);
		return theSinhVien;
	}
	
	@DeleteMapping("/sinhviens/{sinhVienId}")
	public String deleteSinhVien(@PathVariable int sinhVienId) {
		SinhVien tempSinhVien = sinhVienService.getSinhVien(sinhVienId);
		if(tempSinhVien == null) {
			System.out.println("Loi");

		}
		sinhVienService.deleteSinhVien(sinhVienId);
		
		return "Sinh vien id " + sinhVienId;
	}

}
