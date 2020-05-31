package de.martcre.roxy.roxy2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.Objects;

import static com.sun.tools.internal.xjc.reader.Ring.add;

@Theme(value = Lumo.class, variant = Lumo.DARK)
@CssImport("./styles/roxy.css")
public class MainLayout extends Composite<VerticalLayout> implements RouterLayout {

    private VerticalLayout contentPanel;

    public MainLayout() {
        getContent().add(new Label("my header"));
        getContent().addAndExpand(getContentPanel());
        getContent().add(new Label("my footer"));
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        if (content != null) {
            getContentPanel().getElement().appendChild(Objects.requireNonNull(content.getElement()));
        }
    }

    public VerticalLayout getContentPanel() {
        if (contentPanel == null) {
            contentPanel = new VerticalLayout();
        }
        return contentPanel;
    }
}
