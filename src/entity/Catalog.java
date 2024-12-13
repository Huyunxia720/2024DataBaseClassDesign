package entity;

public class Catalog {
    private String TNo;
    private String DisciplineNum;
    private String SecondaryNum;
    private String TIdentity;
    private Integer CYear;
    private String IsQualification;

    // Getter and Setter methods
    public String getTNo() {
        return TNo;
    }

    public void setTNo(String TNo) {
        this.TNo = TNo;
    }

    public String getDisciplineNum() {
        return DisciplineNum;
    }

    public void setDisciplineNum(String DisciplineNum) {
        this.DisciplineNum = DisciplineNum;
    }

    public String getSecondaryNum() {
        return SecondaryNum;
    }

    public void setSecondaryNum(String SecondaryNum) {
        this.SecondaryNum = SecondaryNum;
    }

    public String getTIdentity() {
        return TIdentity;
    }

    public void setTIdentity(String TIdentity) {
        this.TIdentity = TIdentity;
    }

    public Integer getCYear() {
        return CYear;
    }

    public void setCYear(Integer CYear) {
        this.CYear = CYear;
    }

    public String getIsQualification() {
        return IsQualification;
    }

    public void setIsQualification(String IsQualification) {
        this.IsQualification = IsQualification;
    }
}