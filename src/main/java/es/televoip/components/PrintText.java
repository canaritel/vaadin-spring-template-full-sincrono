package es.televoip.components;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;

public class PrintText {

    public enum Color {
        AZUL, ROJO, VERDE, NEGRO, GRIS
    }

    static public void imprime(String texto, Color color, Position posicion, int miliseconds) {
        Notification notification = Notification.show(texto, miliseconds, posicion);

        switch (color) {
            case AZUL ->
                notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);

            case ROJO ->
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

            case VERDE ->
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

            case NEGRO ->
                notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);

            case GRIS -> {
            }

            default -> {
            }
        }
    }

}
