/*
 * ©2018 Marcos Del Sol Vives <marcos@orca.pet>
 * SPDX-License-Identifier: ISC
 */

package pet.orca.maven.asciibanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import lombok.Data;
import org.apache.maven.plugin.logging.Log;

/**
 * File and/or message.
 */
@Data
public class FileMessage {
	/**
	 * Pattern to split by new line.
	 */
	private static final Pattern NL_PATTERN = Pattern.compile("\r?\n");

	/**
	 * Message to display.
	 */
	private String message;

	/**
	 * File to load and display.
	 */
	private File file;

	/**
	 * Outputs the message and/or file to info level of debug.
	 * @param log log handle
	 */
	public void display(Log log) {
		displayMessage(log);
		displayFile(log);
	}

	/**
	 * Outputs the message to the log "info" level line by line. If the message is null, this method
	 * does nothing.
	 *
	 * @param log log handle
	 */
	public void displayMessage(Log log) {
		if (message != null) {
			for (String line : NL_PATTERN.split(message)) {
				log.info(line);
			}
		}
	}

	/**
	 * Streams the message file to the log "info" level line by line. If the file is null, this
	 * method does nothing.
	 *
	 * @param log log handle
	 */
	public void displayFile(Log log) {
		if (file != null) {
			try (BufferedReader reader = bufferedReader(file)) {
				while (true) {
					String line = reader.readLine();
					if (line == null) {
						break;
					}
					log.info(line);
				}
			} catch (IOException e) {
				log.error("Unable to read from " + file, e);
			}
		}
	}

	/**
	 * Opens a buffered reader for the given file.
	 * @param file file to open
	 * @return a new BufferedReader handle
	 * @throws IOException if any I/O error occurs
	 */
	private BufferedReader bufferedReader(File file) throws IOException {
		return new BufferedReader(new InputStreamReader(
				new FileInputStream(file), StandardCharsets.UTF_8));
	}
}
