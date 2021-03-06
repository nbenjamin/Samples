package com.summer.vshoppingcart.repository.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Repository;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.summer.vshoppingcart.domain.Product;

@Repository
public class ImageRespositoryImpl {

	@Autowired
	GridFsOperations gridFsOperations;

	public String storeProductImage(Product product) {
		String fileId = null;
		try {
			GridFSFile gridFSFile = gridFsOperations
					.store(product.getImage().getInputStream(), product
							.getImage().getOriginalFilename());
			gridFSFile.getId().toString();
			fileId = gridFSFile.getId().toString();
		} catch (IOException e) {
			// time to add logger
			e.printStackTrace();
		}
		return fileId;
	}

	public GridFSDBFile get(String id) {
		GridFSDBFile gridFSDBFile = gridFsOperations.findOne(new Query(Criteria
				.where("_id").is(new ObjectId(id))));
		return gridFSDBFile;
	}

	public byte[] findOne(String id) {
		InputStream is;
		ByteArrayOutputStream bais;
	
		GridFSDBFile dbFile= get(id);
		is = dbFile.getInputStream();
		bais = new ByteArrayOutputStream();
		byte bytes[] =new byte[(int) dbFile.getLength()];
		int count = -1;
        try {
			while((count = is.read(bytes)) != -1) {  
			    bais.write(bytes, 0, count); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			bais.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return bais.toByteArray();
	}
}
