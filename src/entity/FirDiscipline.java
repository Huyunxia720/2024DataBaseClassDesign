package entity;

public class FirDiscipline {
    private String disciplineNum;
    private String disType;
    private String firOverview;
    private String firDisName;
    private Integer supplyIndicator;
    private Integer allIndicator;
    private String note;

    // Getters and Setters
    public String getDisciplineNum() {
        return disciplineNum;
    }

    public void setDisciplineNum(String disciplineNum) {
        this.disciplineNum = disciplineNum;
    }

    public String getDisType() {
        return disType;
    }

    public void setDisType(String disType) {
        this.disType = disType;
    }

    public String getFirOverview() {
        return firOverview;
    }

    public void setFirOverview(String firOverview) {
        this.firOverview = firOverview;
    }

    public String getFirDisName() {
        return firDisName;
    }

    public void setFirDisName(String firDisName) {
        this.firDisName = firDisName;
    }

    public Integer getSupplyIndicator() {
        return supplyIndicator;
    }

    public void setSupplyIndicator(Integer supplyIndicator) {
        this.supplyIndicator = supplyIndicator;
    }

    public Integer getAllIndicator() {
        return allIndicator;
    }

    public void setAllIndicator(Integer allIndicator) {
        this.allIndicator = allIndicator;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}