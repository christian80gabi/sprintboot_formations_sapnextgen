package tn.gov.douane.formations.api.dto;

public class RoleDto {

    private int id;
    private String roleLabel;
    private String roleDescription;

    public RoleDto() {
    }

    public RoleDto(int id, String roleLabel, String roleDescription) {
        this.id = id;
        this.roleLabel = roleLabel;
        this.roleDescription = roleDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleLabel() {
        return this.roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }
}
