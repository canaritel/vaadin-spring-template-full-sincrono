package es.televoip.views.helloworld;

import es.televoip.views.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import es.televoip.components.PrintText;

@Route(value = "", layout = MainView.class)
public class HelloWorldView extends VerticalLayout {

    private final TextField nameField = new TextField("Your name");
    private final Button button = new Button("Say hello", e -> showNotification());
    private final ProgressBar progressBar = new ProgressBar();

    public HelloWorldView() {

        this.setWidthFull();
        this.setSpacing(true);
        this.setPadding(true);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setPadding(true);
        layout.setSpacing(true);
        UI.getCurrent().getPage().setTitle("Hello View"); // Pongo título a la página

        HorizontalLayout layout2 = new HorizontalLayout();
        layout2.setWidthFull();
        layout2.setSpacing(false);
        layout2.setPadding(true);
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        progressBar.setWidth("300px");

        layout.add(nameField, button);
        layout2.add(progressBar);
        layout.setAlignItems(FlexComponent.Alignment.BASELINE);
        layout2.setJustifyContentMode(JustifyContentMode.START);
        add(layout, layout2);

    }

    private void showNotification() {
        PrintText.imprime("Save!", PrintText.Color.AZUL, Position.MIDDLE, 3000);
    }

}
