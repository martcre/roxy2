package de.martcre.roxy.roxy2;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;

@Tag("my-test")
public class TestComponent extends Component {

    public TestComponent(String text) {
        setText(text);
    }

    public TestComponent() {
    }

    public void setText(String text) {
        getElement().setText(text);
    }

    public String getText() {
        return getElement().getText();
    }

}
