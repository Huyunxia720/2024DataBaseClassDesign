package entity;

public class IsSelected {
    private String disciplineNum; 
    private String secondaryNum; 
    private boolean state; // 状态，true表示已选完，false表示未选完

    public String getDisciplineNum() {
        return disciplineNum;
    }

    public void setDisciplineNum(String disciplineNum) {
        this.disciplineNum = disciplineNum;
    }

    public String getSecondaryNum() {
        return secondaryNum;
    }

    public void setSecondaryNum(String secondaryNum) {
        this.secondaryNum = secondaryNum;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}