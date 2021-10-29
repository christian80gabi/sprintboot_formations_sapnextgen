package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.LevelSkill;
import tn.gov.douane.formations.api.model.SkillSection;

public class SkillDto {

    private int id;
    private String skillCode;
    private String skillDescription;
    private String skillDocument;
    private String skillLink;
    private String skillName;
    private String skillPlace;
    private String skillPeriodStart;
    private String skillPeriodEnd;
    private int skillQuota;
    private String skillResult;
    private int levelSkillId;
    private int skillSectionId;
    private LevelSkill levelSkill;
    private SkillSection skillSection;

    public SkillDto() {
    }

    public SkillDto(int id, String skillCode, String skillDescription, String skillDocument, String skillLink, String skillName, String skillPlace,
                    int skillQuota, String skillResult, int levelSkillId, int skillSectionId) {
        this.id = id;
        this.skillCode = skillCode;
        this.skillDescription = skillDescription;
        this.skillDocument = skillDocument;
        this.skillLink = skillLink;
        this.skillName = skillName;
        this.skillPlace = skillPlace;
        this.skillQuota = skillQuota;
        this.skillResult = skillResult;
        this.levelSkillId = levelSkillId;
        this.skillSectionId = skillSectionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillCode() {
        return this.skillCode;
    }

    public void setSkillCode(String skillCode) {
        this.skillCode = skillCode;
    }

    public String getSkillDescription() {
        return this.skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillDocument() {
        return this.skillDocument;
    }

    public void setSkillDocument(String skillDocument) {
        this.skillDocument = skillDocument;
    }

    public String getSkillLink() {
        return this.skillLink;
    }

    public void setSkillLink(String skillLink) {
        this.skillLink = skillLink;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillPlace() {
        return this.skillPlace;
    }

    public void setSkillPlace(String skillPlace) {
        this.skillPlace = skillPlace;
    }

    public String getSkillPeriodStart() {
        return skillPeriodStart;
    }

    public void setSkillPeriodStart(String skillPeriodStart) {
        this.skillPeriodStart = skillPeriodStart;
    }

    public String getSkillPeriodEnd() {
        return skillPeriodEnd;
    }

    public void setSkillPeriodEnd(String skillPeriodEnd) {
        this.skillPeriodEnd = skillPeriodEnd;
    }

    public int getSkillQuota() {
        return this.skillQuota;
    }

    public void setSkillQuota(int skillQuota) {
        this.skillQuota = skillQuota;
    }

    public String getSkillResult() {
        return this.skillResult;
    }

    public void setSkillResult(String skillResult) {
        this.skillResult = skillResult;
    }

    public int getLevelSkillId() {
        return this.levelSkillId;
    }

    public void setLevelSkillId(int levelSkillId) {
        this.levelSkillId = levelSkillId;
    }

    public int getSkillSectionId() {
        return this.skillSectionId;
    }

    public void setSkillSectionId(int skillSectionId) {
        this.skillSectionId = skillSectionId;
    }

    public LevelSkill getLevelSkill() {
        return levelSkill;
    }

    public void setLevelSkill(LevelSkill levelSkill) {
        this.levelSkill = levelSkill;
    }

    public SkillSection getSkillSection() {
        return skillSection;
    }

    public void setSkillSection(SkillSection skillSection) {
        this.skillSection = skillSection;
    }
}
