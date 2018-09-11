package com.osi.finx.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemitCounter implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RemitCounter.class);
	
	private InputStream inputStream = null;
	private int recordCount = 0;
	
	public RemitCounter(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	@Override
	public void run() {
		LOGGER.debug("RemitCounter :: run :: START");
		Scanner scanner = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			org.apache.commons.io.IOUtils.copy(inputStream, baos);
			byte[] bytes = baos.toByteArray();
			
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			scanner = new Scanner(bais, "UTF-8");
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				recordCount++;
			}
			if (scanner.ioException() != null) {
				LOGGER.error("RemitCounter :: run :: ERROR :: ", scanner.ioException().getCause());
				LOGGER.debug("RemitCounter :: run :: END");
				throw scanner.ioException();
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("RemitCounter :: run :: ERROR :: ", e);
			LOGGER.debug("RemitCounter :: run :: END");
		} catch (IOException ioe) {
			LOGGER.error("RemitCounter :: processRemittanceFile :: ERROR :: ", ioe);
			LOGGER.debug("RemitCounter :: processRemittanceFile :: END");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
