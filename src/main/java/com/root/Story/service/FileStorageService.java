package com.root.Story.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.root.Story.FileStorageProperties;
import com.root.Story.responseTemplates.BaseResponseTemplate;
import com.root.Story.responseTemplates.RestUploadFileResponse;
import com.root.Story.utils.FileStorageException;
import com.root.Story.utils.MyFileNotFoundException;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}


	public ResponseEntity<BaseResponseTemplate> storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {			
			if (fileName.contains("..")) {
				return new ResponseEntity<BaseResponseTemplate>(new BaseResponseTemplate(HttpStatus.OK, "Invalid file name", null), HttpStatus.OK);
			}
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/story/video/").path(fileName).toUriString();
			return new ResponseEntity<BaseResponseTemplate>(new BaseResponseTemplate(HttpStatus.OK, "File Uploaded",
					new RestUploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize())), HttpStatus.OK);
		} catch (IOException ex) {
			return new ResponseEntity<BaseResponseTemplate>(new BaseResponseTemplate( HttpStatus.OK, "File Upload Error", null), HttpStatus.OK);
		}
	}


	public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

}
