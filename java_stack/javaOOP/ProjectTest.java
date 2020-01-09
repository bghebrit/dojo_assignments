public class ProjectTest{
    public static void main(String[] args){
        Project p = new Project();
        Project p1 = new Project("bini", "man");
        Project p2 = new Project("nati");
        p.elevatorPitch();
        p1.elevatorPitch();
        p2.elevatorPitch();
        p.setName("bini");
        p.getName();


    }
}