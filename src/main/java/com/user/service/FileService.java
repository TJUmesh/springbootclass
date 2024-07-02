package com.user.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	public String saveImage(String path, MultipartFile file) throws IOException {

		// original File Name
		String name = file.getOriginalFilename();

		// set the path where File Stored
		String filePath = path + File.separator + name;

		// create File Object
		File files = new File(path);

		// check if folder not created then create new folders
		if (!files.exists()) {
			files.mkdir();
		}

		Files.copy(file.getInputStream(), Paths.get(filePath));

		return name;
	}

}
