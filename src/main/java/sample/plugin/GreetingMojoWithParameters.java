package sample.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Says "Hi" to a user given in a parameters
 */
@Mojo(name = "sayhiTo")
public class GreetingMojoWithParameters extends AbstractMojo {

    /**
     * The user to display.
     * The parameter annotation identifies the variable as a mojo parameter.
     *
     * The default value can include expressions which reference the project, such as "${project.version}"
     * See http://maven.apache.org/ref/current/maven-core/apidocs/org/apache/maven/plugin/PluginParameterExpressionEvaluator.html
     *
     * The property parameter can be used to allow configuration of the mojo parameter from the command line by referencing a system property that the user sets via the -D option.
     */
    @Parameter( property = "sayhiTo.user", defaultValue = "World" )
    private String user;

    public void execute() throws MojoExecutionException {
        getLog().info("Hello, "+this.user+"!");
    }
}
