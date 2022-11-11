package es.televoip.backend.entity.enums;

// No lo creamos como clase, ya que no vamos a permitir añadir, eliminar o modificar
public enum Role {
    // Los tipos de rol que nuestra aplicación permitirá son:
    // 1. SUPERADMIN: permitido para usuarios con todos los permisos
    // 2. ADMIN: se refiere al Gestor
    // 3. MANAGER: se refiere al Manager
    // 4. USER: se refiere al usuario final
    USER("user"), MANAGER("manager"), ADMIN("admin"), SUPERADMIN("superadmin");

    public final String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

}
