ascii-banner-maven-plugin
=========================

This is a Maven plugin whose job is to display a success or failure banner depending on the
project build result.

![Success screenshot](https://raw.githubusercontent.com/socram8888/ascii-banner-maven-plugin/master/success.png)

Usage
-----

To use this plugin, you need to add a new Mojo to the `pom.xml`:

```
<project>
	...
	<build>
		...
		<plugins>
			...
			<plugin>
				<groupId>pet.orca</groupId>
				<artifactId>ascii-banner-maven-plugin</artifactId>
				<version>1.0</version>
				<executions>
					<execution>
						<id>banner-setup</id>
						<goals>
							<goal>setup</goal>
						</goals>
						<configuration>
							<!--
								These parameters are all optional.
								You may want to specify only a file or only a message,
								and only print on success or on failure.
							-->
							<success>
								<message>Message to print on success, if any</message>
								<file>${project.basedir}/success.txt</file>
							</success>
							<failure>
								<message>Message to print on failure, if any</message>
								<file>${project.basedir}/failure.txt</file>
							</failure>
						</configuration>
					</execution>
				</executions>
			</plugin>
			...
		</plugins>
		...
	</build>
	...
</project>
```

Where to get the images from?
-----------------------------

I have another related project called [ASCIImages](https://github.com/socram8888/ASCIImages)
where you can find some black-and-white and RGB images for printing on terminals, along with
automated tools for building them.

![Failure image](https://raw.githubusercontent.com/socram8888/ascii-banner-maven-plugin/master/failure.png)
