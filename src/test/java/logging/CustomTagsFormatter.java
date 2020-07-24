package logging;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestRunFinished;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CustomTagsFormatter implements EventListener {

    //https://blog.j-labs.pl/2019/09/Custom-formatters-in-Cucumber
    //http://www.thinkcode.se/blog/2019/03/07/how-to-implement-a-cucumberjvm-plugin

    private final MyNiceAppendable out;
    private Set<String> tags = new TreeSet<>();

    public CustomTagsFormatter(Appendable out) {
        this.out = new MyNiceAppendable(out);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::collectTags);
        publisher.registerHandlerFor(TestRunFinished.class, this::generateJson);
    }

    private void collectTags(TestCaseStarted event) {
        tags.addAll(new HashSet<>(event
                .getTestCase()
                .getTags()));
    }

    private void generateJson(TestRunFinished event) {
        out.println(String.join(",", tags.toString()));
    }

}
