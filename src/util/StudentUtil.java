package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassname();
        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registeredStudent() {
        int count = InputUtil.requirNumber("What`s registrations student numbers?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". Register");
            Config.students[i] = StudentUtil.fillStudent();
        }

        MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("type name,surname or class name");
        Student[] result = findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];

        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requirNumber("what`s updates number's user? ");
        System.out.println("Enter new data updates");
        Student s = StudentUtil.fillStudent();

        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requirNumber("what`s updates number's user? ");
        System.out.println("Enter new data updates");
        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requireText("what's updates users?  'name','surname',or classname");


        if (changeParams.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requireName());
        }

        if (changeParams.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requireSurname());
        }
        if (changeParams.contains("'classname'")) {
            selectedStudent.setClassName(MenuUtil.requireClassname());
        }
        if (changeParams.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requireAge());
        }
    }

    public static void updateStudentsWithSplit() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requirNumber("what`s updates number's user? ");
        System.out.println("Enter new data updates");
        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requireText("what's updates users?  'name','surname',or classname");

        String[] parametrs = changeParams.split(",");
        for (int i = 0; i < parametrs.length; i++) {
            String param = parametrs[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(MenuUtil.requireClassname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            }
        }
    }


}
