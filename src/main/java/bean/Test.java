package bean;

public class Test {

    private String year;
    private String classNum;
    private String subjectId;

    /**
     * 1回目点数
     */
    private int point;

    /**
     * 2回目点数
     */
    private Integer point2;

    /**
     * 回数
     */
    private int no;

    /**
     * 学生
     */
    private Student student;

    // ----------------
    // getter setter
    // ----------------

    public String getYear() {
    	return year;
    }

    public void setYear(
    		String year) {

    	this.year = year;
    }

    public String getClassNum() {
    	return classNum;
    }

    public void setClassNum(
    		String classNum) {

    	this.classNum = classNum;
    }

    public String getSubjectId() {
    	return subjectId;
    }

    public void setSubjectId(
    		String subjectId) {

    	this.subjectId = subjectId;
    }

    // ----------------
    // point
    // ----------------

    public int getPoint() {
    	return point;
    }

    public void setPoint(
    		int point) {

    	this.point = point;
    }

    // ----------------
    // point2
    // ----------------

    public Integer getPoint2() {
    	return point2;
    }

    public void setPoint2(
    		Integer point2) {

    	this.point2 = point2;
    }

    // ----------------
    // no
    // ----------------

    public int getNo() {
    	return no;
    }

    public void setNo(
    		int no) {

    	this.no = no;
    }

    // ----------------
    // Student
    // ----------------

    public Student getStudent() {
    	return student;
    }

    public void setStudent(
    		Student student) {

    	this.student = student;
    }
}