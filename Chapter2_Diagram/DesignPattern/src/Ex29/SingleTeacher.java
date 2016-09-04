package Ex29;

public class SingleTeacher {

    private static SingleTeacher teacher = new SingleTeacher();

    public SingleTeacher() {
    }

    public static SingleTeacher getInstance() {
        if (teacher == null) {
            teacher = new SingleTeacher();
        }
        return teacher;
    }
    public String shareDocument(){
        return "Tai lieu tham khao: \nChuong 1\nChuong 2\nChuong 3\nChuong 4";
    }
}
