package com.ilci.magasin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public abstract class MyServices {

	public static void uploadFile(String fileName, String uploadDir, MultipartFile multipartFile) {
		Path uploadPath = Paths.get(uploadDir);

		try (InputStream inputStream = multipartFile.getInputStream()) {

			Path filepath = uploadPath.resolve(fileName);

			Files.copy(inputStream, filepath, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			System.out.println("upload file " + e.getMessage());
		}

	}

}
