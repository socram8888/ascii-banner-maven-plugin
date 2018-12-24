/*
 * ©2018 Marcos Del Sol Vives <marcos@orca.pet>
 * SPDX-License-Identifier: ISC
 */

package pet.orca.maven.asciibanner;

import java.util.Collection;
import java.util.LinkedList;
import lombok.NonNull;
import org.apache.maven.execution.AbstractExecutionListener;
import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.execution.ExecutionListener;

/**
 * Execution listener which forwards calls to all of its children.
 */
public class ChainedExecutionListener extends AbstractExecutionListener {

	/**
	 * Listener collection.
	 */
	private final Collection<ExecutionListener> listeners;

	/**
	 * Creates a new chained execution listener with an empty list.
	 */
	public ChainedExecutionListener() {
		this.listeners = new LinkedList<>();
	}

	/**
	 * Creates a new chained execution listener with the given collection.
	 * @param listeners listener collection, not null
	 */
	public ChainedExecutionListener(@NonNull Collection<ExecutionListener> listeners) {
		this.listeners = listeners;
	}

	/**
	 * Adds a new {@link ExecutionListener} to the list.
	 * @param listener new listener to add, not null
	 */
	public void add(@NonNull ExecutionListener listener) {
		listeners.add(listener);
	}

	/**
	 * Calls the {@code projectDiscoveryStarted} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void projectDiscoveryStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectDiscoveryStarted(ee);
		}
	}

	/**
	 * Calls the {@code sessionStarted} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void sessionStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.sessionStarted(ee);
		}
	}

	/**
	 * Calls the {@code sessionEnded} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void sessionEnded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.sessionEnded(ee);
		}
	}

	/**
	 * Calls the {@code projectStarted} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void projectSkipped(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectSkipped(ee);
		}
	}

	/**
	 * Calls the projectSkipped method of the children.
	 * @param ee execution event
	 */
	@Override
	public void projectStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectStarted(ee);
		}
	}

	/**
	 * Calls the {@code projectSucceeded} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void projectSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectSucceeded(ee);
		}
	}

	/**
	 * Calls the {@code projectFailed} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void projectFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectFailed(ee);
		}
	}

	/**
	 * Calls the {@code mojoSkipped} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void mojoSkipped(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoSkipped(ee);
		}
	}

	/**
	 * Calls the {@code mojoStarted} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void mojoStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoStarted(ee);
		}
	}

	/**
	 * Calls the {@code mojoSucceeded} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void mojoSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoSucceeded(ee);
		}
	}

	/**
	 * Calls the {@code mojoFailed} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void mojoFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoFailed(ee);
		}
	}

	/**
	 * Calls the {@code forkStarted} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void forkStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkStarted(ee);
		}
	}

	/**
	 * Calls the {@code forkSucceeded} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void forkSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkSucceeded(ee);
		}
	}

	/**
	 * Calls the {@code forkFailed} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void forkFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkFailed(ee);
		}
	}

	/**
	 * Calls the {@code forkedProjectStarted} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void forkedProjectStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkedProjectStarted(ee);
		}
	}

	/**
	 * Calls the {@code forkedProjectSucceeded} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void forkedProjectSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkedProjectSucceeded(ee);
		}
	}

	/**
	 * Calls the {@code forkedProjectFailed} method of the children.
	 * @param ee execution event
	 */
	@Override
	public void forkedProjectFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkedProjectFailed(ee);
		}
	}
}
