/*
 * ©2018 Marcos Del Sol Vives <marcos@orca.pet>
 * SPDX-License-Identifier: ISC
 */

package pet.orca.maven.asciibanner;

import org.apache.maven.execution.MavenExecutionRequest;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.execution.MavenSession;

/**
 * Mojo which sets up the execution listener.
 */
@Mojo(
		name="setup"
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
	 * Maven session.
	 */
	@Parameter(defaultValue = "${session}", readonly = true)
	private MavenSession mavenSession;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
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
