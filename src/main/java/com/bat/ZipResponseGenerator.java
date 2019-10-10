package com.bat;

/**
 * @author a.cr.kumar.singh
 */

import static com.bat.AppConstants.PATH_SEPERATOR;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

public class ZipResponseGenerator {

	private final Logger LOG = Logger.getLogger(ZipResponseGenerator.class);

	
	public byte[] createResponse(String dir, String project) throws Exception {
		if (project == null || project == "")
			throw new IllegalArgumentException("Missing project param in query params !!!");

		String projectDir = dir.concat(PATH_SEPERATOR).concat(project);
		LOG.info("dir " + dir);
		LOG.info("project " + project);
		LOG.info("projectDir " + projectDir);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zipOut = new ZipOutputStream(baos);
		File fileToZip = new File(projectDir);

		zipFile(fileToZip, fileToZip.getName(), zipOut);
		zipOut.close();
		baos.close();
		return baos.toByteArray();
	}

	private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
		if (fileToZip.isHidden()) {
			return;
		}
		if (fileToZip.isDirectory()) {
			if (fileName.endsWith(PATH_SEPERATOR)) {
				zipOut.putNextEntry(new ZipEntry(fileName));
				zipOut.closeEntry();
			} else {
				zipOut.putNextEntry(new ZipEntry(fileName + PATH_SEPERATOR));
				zipOut.closeEntry();
			}
			File[] children = fileToZip.listFiles();
			for (File childFile : children) {
				zipFile(childFile, fileName + PATH_SEPERATOR + childFile.getName(), zipOut);
			}
			return;
		}
		FileInputStream fis = new FileInputStream(fileToZip);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zipOut.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		}
		fis.close();
	}
	
}