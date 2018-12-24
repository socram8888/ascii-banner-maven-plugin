/*
 * ©2018 Marcos Del Sol Vives <marcos@orca.pet>
 * SPDX-License-Identifier: ISC
 */

package pet.orca.maven.asciibanner;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.maven.execution.AbstractExecutionListener;
import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.plugin.logging.Log;

/**
 * Execution listener which displays the message according to success or failure.
 */
public class AsciiBannerExecutionListener extends AbstractExecutionListener {
	/**
	 * Log handle.
	 */
	private final Log logger;

	/**
	 * Success message/file.
	 */
	@Getter @Setter
	private FileMessage success;

	/**
	 * Failure message/file.
	 */
	@Getter @Setter
	private FileMessage failure;

	/**
	 * Creates a new instance with the given logger.
	 * @param logger log handle, not null
	 */
	public AsciiBannerExecutionListener(@NonNull Log logger) {
		this.logger = logger;
	}

	/**
	 * Logs the appropiate banner(s) depending on compilation result.
	 * @param event execution event
	 */
	@Override
	public void sessionEnded(ExecutionEvent event) {
		if (!logger.isInfoEnabled()) {
			return;
		}

		if (event.getSession().getResult().hasExceptions()) {
			if (failure != null) {
				failure.display(logger);
			}
		} else {
			if (success != null) {
				success.display(logger);
			}
		}
	}
}
