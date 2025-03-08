interface College{
    void fees();
    void faculty();
}
interface University{
    void universityname();
    void noofclgs();
}
class RaghuEnggcollege{
    int n=7000;
    public void noofstudents(){
        System.out.println("more than 5000+ students");
    }
}
class Raghu extends RaghuEnggcollege implements College,University{
    public void fees(){
        System.out.println("76670");
    }
    public void faculty(){
        System.out.println("more than 200+ faculty");
    }
    public void universityname(){
        System.out.println("jntugv");
    }
    public void noofclgs(){
        System.out.println("more than 50+ clgs");
    }
    public void lessstudents(){
        System.out.println("less than "+n+" no of students");
    }

}

public class Interfaces {
    public static void main(String[] args) {
        Raghu r=new Raghu();
        r.faculty();
        r.fees();
        r.universityname();
        r.noofclgs();
        r.noofstudents();
        r.lessstudents();
    }
}
