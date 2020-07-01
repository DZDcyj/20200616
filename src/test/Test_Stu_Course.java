package test;

import User.ClassToUser;
import Utils.StudentToClassDaoImpl;
import Utils.TeacherToClassDaoImpl;

public class Test_Stu_Course {
    public static void main(String args[]){
        ClassToUser classToUser = new ClassToUser();
        StudentToClassDaoImpl studentToClassDao = new StudentToClassDaoImpl();
        TeacherToClassDaoImpl teacherToClassDao = new TeacherToClassDaoImpl();

        classToUser.setCourse_id(20200627);
        classToUser.setUser_id(2);

        //studentToClassDao.insert(20200627,2);
        //studentToClassDao.insert(20200626,2);
        //studentToClassDao.delete(20200625,2);
        teacherToClassDao.insert(20200625,2);

    }
}
