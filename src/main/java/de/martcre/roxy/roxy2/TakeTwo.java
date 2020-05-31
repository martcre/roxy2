package de.martcre.roxy.roxy2;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = "taketwo", layout = MainLayout.class)
public class TakeTwo extends Div {

    public TakeTwo() {
        add(new Text("Take Two"));
    }
}
