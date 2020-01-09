package com.codingdojo.relationships.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;



@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public List<License> allLicenses(){
		return licenseRepo.findAll();
	}
	
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	
	public License findLicense(Long id) {
		Optional<License> license = licenseRepo.findById(id);
		if(license.isPresent()) {
			return license.get();
		}
		else {
			return null;
		}
	}
	
	public static int licenseNumber;

	public static int getLicenseNumber() {
		return licenseNumber;
	}

	public static void setLicenseNumber(int licenseNumber) {
		LicenseService.licenseNumber = licenseNumber;
	}

	public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	
	//public String generateLicenseNumber() {
		//if(licenseRepo.findByNumber.isEmpty()) {
			//licenseNumber +=1;
			//return stringLicenseNumber(licenseNumber);
		//}
		//else {
			//List<License> top = licenseRepo.findByNumber() ;
			//licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
			//return stringLicenseNumber(licenseNumber);
		//}
	//}
}
