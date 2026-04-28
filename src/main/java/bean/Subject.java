package bean;

public class Subject {

    private String schoolCd;
    private String cd;
    private String name;

    public Subject(String schoolCd, String cd, String name) {
        this.schoolCd = schoolCd;
        this.cd = cd;
        this.name = name;
    }

    public String getSchoolCd() {
        return schoolCd;
    }

    public String getCd() {
        return cd;
    }

    public String getName() {
        return name;
    }
}