package com.summer.vshoppingcart.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.summer.vshoppingcart.domain.Product;
import com.summer.vshoppingcart.utils.AppConfig;

@Repository
public class FileStorageRepository {

	@Autowired
	AppConfig appConfig;

	public String storeProductImage(Product product) {
		String path = "";

		CommonsMultipartFile multipartFile = product.getImage();
		String orginalName = product.getImage().getOriginalFilename();
		String filePath = appConfig.getEnvironment().getProperty("filepath")
				+ File.separator + product.getType() + File.separator + product.getName();
		File file = new File(filePath);
		if(!file.exists()) {
			if(file.mkdirs()) {
				path = storeFile(file, orginalName, multipartFile);	
			}
		}else {
			path = storeFile(file, orginalName, multipartFile);
		
		}
		
		
		return path;
	}

	private String storeFile(File file, String orginalName, CommonsMultipartFile multipartFile) {
		String path = null;
		try {
			File destination = new File(file, orginalName);
			multipartFile.transferTo(destination);
			path = destination.getCanonicalPath();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			path = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = null;
		}		
	return path;
	}
}
