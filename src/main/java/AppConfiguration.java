import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Felix on 04.04.2017.
 */
public class AppConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String path2WordList;

    public String getPath2WordList() {
        return this.path2WordList;
    }
}
