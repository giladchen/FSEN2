package ProjectImp.ObesrverPattern;

import ProjectImp.ProjectHandler;

public class TestObserver {

    public static void main(String[] args) {
        ProjectHandler projectHandler = new ProjectHandler();
        projectHandler.addStudent("u1", "123");
        projectHandler.addStudent("u2", "456");
        projectHandler.addStudent("u3", "789");
        projectHandler.addStudent("u4", "321");
        projectHandler.addTechnicalAdviser("prop1", "123456");
        projectHandler.addTechnicalAdviser("prop2", "654321");

        int p1Code = projectHandler.addProject("prop1", "123456",
                "Mister", "Proposer",
                "0521234567", "prop1@prop.email",
                "proposers1 INC", "p1",
                "project 1", 250);
        int p2Code = projectHandler.addProject("prop2", "654321",
                "Misses", "Proposette",
                "0527654321", "prop2@prop.email",
                "proposers2 INC", "p2",
                "project 2", 300);

        projectHandler.registerStudentForEmail("u1", "u1@gmail.com", p1Code);
        projectHandler.registerStudentForBoth("u2", "u2@gmail.com", "0501112222", p1Code);
        projectHandler.registerStudentForText("u4", "0546667777", p2Code);

        projectHandler.registerStudentForBoth("u3", "u3@gmail.com", "0523334444", p1Code);
        projectHandler.unregisterStudentFromMessages("u3", p1Code);

        projectHandler.approveProject(p1Code);
        projectHandler.approveProject(p2Code);
    }
}
