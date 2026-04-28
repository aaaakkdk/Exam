package bean;
 
public class Subject {
 
    private String schoolCd;
    private int cd;
    private String name;
 
    public Subject(String schoolCd, int cd, String name) {
        this.schoolCd = schoolCd;
        this.cd = cd;
        this.name = name;
    }
 
    public String getSchoolCd() {
        return schoolCd;
    }
 
    public int getCd() {
        return cd;
    }
 
    public String getName() {
        return name;
    }
}
 