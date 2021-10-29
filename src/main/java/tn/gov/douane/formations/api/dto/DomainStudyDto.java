package tn.gov.douane.formations.api.dto;

public class DomainStudyDto {

    private int id;
    private String domainStudyLabel;

    public DomainStudyDto() {
    }

    public DomainStudyDto(int id, String domainStudyLabel) {
        this.id = id;
        this.domainStudyLabel = domainStudyLabel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomainStudyLabel() {
        return this.domainStudyLabel;
    }

    public void setDomainStudyLabel(String domainStudyLabel) {
        this.domainStudyLabel = domainStudyLabel;
    }
}
