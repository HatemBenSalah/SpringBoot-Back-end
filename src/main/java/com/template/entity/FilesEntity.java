package com.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FILES")
public class FilesEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	public FilesEntity() {
		super();
	}

	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name= "DATA")
	private byte[] data;
	
	@Column(name="CREATED_ON")
	private String createdON;
	
	@Column(name="UPDATED_ON")
	private String updatedOn;

	public String getCreatedON() {
		return createdON;
	}

	public void setCreatedON(String createdON) {
		this.createdON = createdON;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public FilesEntity(String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
