package es.televoip.backend.entity.enums;

public enum Gender {
    HOMBRE("Hombre"), MUJER("Mujer");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }

}
