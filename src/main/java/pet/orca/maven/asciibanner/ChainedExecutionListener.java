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

	public void add(@NonNull ExecutionListener listener) {
		listeners.add(listener);
	}

	@Override
	public void projectDiscoveryStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectDiscoveryStarted(ee);
		}
	}

	@Override
	public void sessionStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.sessionStarted(ee);
		}
	}

	@Override
	public void sessionEnded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.sessionEnded(ee);
		}
	}

	@Override
	public void projectSkipped(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectSkipped(ee);
		}
	}

	@Override
	public void projectStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectStarted(ee);
		}
	}

	@Override
	public void projectSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectSucceeded(ee);
		}
	}

	@Override
	public void projectFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.projectFailed(ee);
		}
	}

	@Override
	public void mojoSkipped(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoSkipped(ee);
		}
	}

	@Override
	public void mojoStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoStarted(ee);
		}
	}

	@Override
	public void mojoSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoSucceeded(ee);
		}
	}

	@Override
	public void mojoFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.mojoFailed(ee);
		}
	}

	@Override
	public void forkStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkStarted(ee);
		}
	}

	@Override
	public void forkSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkSucceeded(ee);
		}
	}

	@Override
	public void forkFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkFailed(ee);
		}
	}

	@Override
	public void forkedProjectStarted(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkedProjectStarted(ee);
		}
	}

	@Override
	public void forkedProjectSucceeded(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkedProjectSucceeded(ee);
		}
	}

	@Override
	public void forkedProjectFailed(ExecutionEvent ee) {
		for (ExecutionListener listener : listeners) {
			listener.forkedProjectFailed(ee);
		}
	}
}
