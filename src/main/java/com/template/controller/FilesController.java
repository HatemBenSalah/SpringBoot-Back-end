package com.template.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.template.entity.FilesEntity;
import com.template.exception.FileStorageException;
import com.template.exception.ResourceNotFoundException;
import com.template.repositories.FilesRepository;

@RestController
@RequestMapping("/filesController")
public class FilesController {

	 @Autowired
	 private FilesRepository fileRep;
	 
	 @GetMapping("/getAll")
	 public List<FilesEntity> getAll() {
		return fileRep.findAll();
		 
	 }
	 
	 @PostMapping("/uploadFile")
	 public FilesEntity uploadFile(@RequestParam("file") MultipartFile file){
		 try {
			 FilesEntity newFile = new FilesEntity();
			 newFile.setCreatedON(new Date()+"");
			 newFile.setFileName(file.getOriginalFilename());
			 newFile.setData(file.getBytes());
			 newFile.setFileType(file.getContentType());
			 newFile.setUpdatedOn(new Date()+"");
			 fileRep.save(newFile);
			 return newFile;
		 }catch (IOException ex) {
			 throw new FileStorageException("Could not store file , Please try again!", ex);
		 }
		 
	 }
	 
	 @GetMapping("/downloadFile/{id}")
	 public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable(value="id") Integer id)
	 throws ResourceNotFoundException, FileNotFoundException{
		 FilesEntity file = fileRep.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("an error in the download file"));
		 return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(file.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
	                .body(new ByteArrayResource(file.getData()));
	 }
	 
	 @PutMapping("/updateFile/{id}")
	 public FilesEntity updateFile(@RequestParam("newFile") MultipartFile newFile, @PathVariable(value="id") Integer oldFileId)
	 throws ResourceNotFoundException, IOException{
		 FilesEntity file = fileRep.findById(oldFileId)
				 .orElseThrow(() -> new ResourceNotFoundException("the File ID does not exist, error in updateFile"));
		 file.setFileName(newFile.getName());
		 file.setData(newFile.getBytes());
		 file.setFileType(newFile.getContentType());
		 file.setUpdatedOn(new Date()+"");
		 fileRep.save(file);
		 
		 return file;
	 }
}
