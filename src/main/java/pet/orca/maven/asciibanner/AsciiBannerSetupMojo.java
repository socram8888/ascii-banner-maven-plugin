/*
 * ©2018 Marcos Del Sol Vives <marcos@orca.pet>
 * SPDX-License-Identifier: ISC
 */

package pet.orca.maven.asciibanner;

import org.apache.maven.execution.MavenExecutionRequest;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.InstantiationStrategy;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Mojo which sets up the execution listener.
 */
@Mojo(
		name = "setup",
		defaultPhase = LifecyclePhase.INITIALIZE,
		instantiationStrategy = InstantiationStrategy.SINGLETON
)
public class AsciiBannerSetupMojo extends AbstractMojo {

	/**
	 * Stuff to display on success.
	 */
	@Parameter
	private FileMessage success;

	/**
	 * Stuff to display on failure.
	 */
	@Parameter
	private FileMessage failure;

	/**
	 * True to ensure the plugin only runs once.
	 */
	@Parameter(defaultValue = "true")
	private boolean runOnce;

	/**
	 * Maven session.
	 */
	@Parameter(defaultValue = "${session}", readonly = true)
	private MavenSession mavenSession;

	/**
	 * True if the mojo has been executed at least once.
	 */
	private boolean executed = false;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		if (runOnce && executed) {
			return;
		}
		executed = true;

		MavenExecutionRequest request = mavenSession.getRequest();

		AsciiBannerExecutionListener abel = new AsciiBannerExecutionListener(getLog());
		abel.setSuccess(success);
		abel.setFailure(failure);

		ChainedExecutionListener cel = new ChainedExecutionListener();
		cel.add(request.getExecutionListener());
		cel.add(abel);
		request.setExecutionListener(cel);
	}
}
