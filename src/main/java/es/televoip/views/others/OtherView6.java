package es.televoip.views.others;

import es.televoip.views.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("About6")
@Route(value = "about6", layout = MainView.class)
@AnonymousAllowed
public class OtherView6 extends VerticalLayout {

    public OtherView6() {
        UI.getCurrent().getPage().setTitle("Otro Título6"); // Pongo título a la página
        setSpacing(false);

        Image img = new Image("images/spring-vaadin-televoip.png", "Developers");
        img.setWidth("400px");
        add(img);

        add(new H2("This place intentionally left empty"));
        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
