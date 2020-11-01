import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/bookProduct.feature",
    glue = "phpTravels.steps",
    plugin = {"progress", "html:out"},
    snippets= SnippetType.CAMELCASE,
    dryRun = false)
public class JavaRunner {

}
