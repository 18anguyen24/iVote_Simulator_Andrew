import java.util.ArrayList;
import java.util.Random;

public class Student {
ArrayList<String> SavedStudentList = new ArrayList<String>();

    // empty constructor
    public Student()
    {
        // sup professor
    }


    // 100 different student names
    private String randomStudent()
    {
        String[] ppl = {
                "John",
                "William",
                "James",
                "Charles",
                "George",
                "Frank",
                "Joseph",
                "Thomas",
                "Henry",
                "Robert",
                "Edward",
                "Harry",
                "Walter",
                "Arthur",
                "Fred",
                "Albert",
                "Samuel",
                "David",
                "Louis",
                "Joe",
                "Charlie",
                "Clarence",
                "Richard",
                "Andrew",
                "Daniel",
                "Ernest",
                "Will",
                "Jesse",
                "Oscar",
                "Lewis",
                "Peter",
                "Benjamin",
                "Frederick",
                "Willie",
                "Alfred",
                "Sam",
                "Roy",
                "Herbert",
                "Jacob",
                "Tom",
                "Elmer",
                "Carl",
                "Lee",
                "Howard",
                "Martin",
                "Michael",
                "Bert",
                "Herman",
                "Jim",
                "Francis",
                "Harvey",
                "Earl",
                "Eugene",
                "Ralph",
                "Ed",
                "Claude",
                "Edwin",
                "Ben",
                "Charley",
                "Paul",
                "Edgar",
                "Isaac",
                "Otto",
                "Luther",
                "Lawrence",
                "Ira",
                "Patrick",
                "Guy",
                "Oliver",
                "Theodore",
                "Hugh",
                "Clyde",
                "Alexander",
                "August",
                "Floyd",
                "Homer",
                "Jack",
                "Leonard",
                "Horace",
                "Marion",
                "Philip",
                "Allen",
                "Archie",
                "Stephen",
                "Chester",
                "Willis",
                "Raymond",
                "Rufus",
                "Warren",
                "Jessie",
                "Milton",
                "Alex",
                "Leo",
                "Julius",
                "Ray",
                "Sidney",
                "Bernard",
                "Dan",
                "Jerry",
        };
            Random random = new Random();
        return ppl[random.nextInt(ppl.length)];
    }

    // generate student with ID  *does not handle unique*
    public String Student_With_uniqueID()
    {
        Random random = new Random();
        return randomStudent() + "_"+random.nextInt(1000);
    }





    public  ArrayList<String> randomStudentGenerator(int numberOfStudents)
    {
        // creating calling student class
        Student studentName = new Student();

        // arrayList to hold all names
        ArrayList<String> studentNameList = new ArrayList<String>();

        // while loop to get random Student name with unique id
        while (numberOfStudents >0 )
        {
            String rngStudent = studentName.Student_With_uniqueID();
            if(!studentNameList.contains(rngStudent))
            {
                studentNameList.add(rngStudent);
                numberOfStudents--;
            }
        }

        this.SavedStudentList = studentNameList;
        return studentNameList;
    }




}
