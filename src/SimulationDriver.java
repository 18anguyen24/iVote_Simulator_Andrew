import java.util.*;

public class SimulationDriver {
    public static void main(String[] args)
    {
//        testRandomStudentGen(20);
//        testQuestion();
// 1) configuring question and answer for voters.
        boolean multipleChoices = true;    // true = muliple Choice,  false = single choice
        Scanner scan = new Scanner(System.in);
        while(true)
        {

            System.out.println("Welcome trainer, will this be a multiple choice or single choice of voting? 1 = multiple choices OR 2 = single choice: ");
            String votingType = scan.nextLine();

             if (Objects.equals(votingType, "1"))
            {
                    break;
            }
            else if (Objects.equals(votingType, "2")) {
                multipleChoices = false;
                break;
            }

           else
            {
                System.out.println("I'm sorry trainer, I did not understand your input.");
            }
        }



// getting question
Question questionArr = new Question();
        scan  = new Scanner(System.in);
      int numQuestion;

        // while loop to ask user to type in from 1 to the number of available questions from the Question class.  Typing in a non-int will break program.
        while (true)
        {
            System.out.println("There are a total of  "+questionArr.availableQuestions.length + " voting questions. Type in a number from 1 to " + questionArr.availableQuestions.length);
            numQuestion = scan.nextInt();
            if(numQuestion >= 1 && numQuestion <=questionArr.availableQuestions.length)
            {
                break;
            }
            else
            {
                System.out.println("invalid entries, please try again.");
            }
        }

//////////////////////////////////////////////////////////////////////////////////////
        // random number of student
        Random random = new Random();
        int numStudent = random.nextInt((20-10))+10;
        Student students = new Student();

        students.randomStudentGenerator(numStudent);



        for (int i = 0; i <numQuestion; i++)
        {
            System.out.println(questionArr.availableQuestions[i]);
        }


        ////=========test single and multiple here ===========

        if(multipleChoices == false) // single choice only
        {
            String[][] tempHolder =    singleAnswerInput(numStudent, numQuestion);

            for (int i = 0; i <numStudent ; i++)
            {
                System.out.println(students.SavedStudentList.get(i));
                System.out.println(Arrays.toString(tempHolder[i])+"\n");
            }

            // converting SavedStudentList to String[], because Java....
            String[] testArr = new String[students.SavedStudentList.size()];
            for (int i = 0; i <students.SavedStudentList.size() ; i++)
            {
                testArr[i] = students.SavedStudentList.get(i);
            }

                    VotingService service = new VotingService(tempHolder,testArr);
        }




        if(multipleChoices == true) // multiple choice only
        {
            String[][] tempHolder =  multipleAnswerInput(numStudent,numQuestion);

            for (int i = 0; i <numStudent ; i++)
            {
                System.out.println(students.SavedStudentList.get(i));
                System.out.println(Arrays.toString(tempHolder[i])+"\n");
            }


            // converting SavedStudentList to String[], because Java....
            String[] testArr = new String[students.SavedStudentList.size()];
            for (int i = 0; i <students.SavedStudentList.size() ; i++)
            {
                testArr[i] = students.SavedStudentList.get(i);
            }
            VotingService service = new VotingService(tempHolder,testArr);

        }



         ///// ==========end here======
    }

    public static String[][] multipleAnswerInput (int numberOfStudent, int numQuestion)
    {

        System.out.println("");
        System.out.println("number of student voted = "+ numberOfStudent+" and their votes\n");

        String aQuestionWithMultipleChoice = "";
        ArrayList<String>  poolAnswer  = new ArrayList<String>();
        poolAnswer.add("A");
        poolAnswer.add("B");
        poolAnswer.add("C");
        poolAnswer.add("D");

        String[][] answerInput = new String[numberOfStudent][numQuestion];

        for (int i = 0; i < numberOfStudent; i++)
        {
            for (int j = 0; j < numQuestion; j++)
            {
                int numberOfRandomAnswer = randInt();
                ArrayList<String> tempPool = new ArrayList<String>(poolAnswer);

                while (numberOfRandomAnswer>0)
                {
                    int randomChoice = randInt();
                    if(randomChoice == 1 && tempPool.contains("A") )
                    {
                        // cancatinate A to string
                        aQuestionWithMultipleChoice +="A";
                        // delete A from tempPool
                        tempPool.remove("A");
                        // -- numberOfRandom

                    }

                    if(randomChoice == 2 && tempPool.contains("B") )
                    {
                        // concat A to string
                        aQuestionWithMultipleChoice +="B";
                        // delete A from tempPool
                        tempPool.remove("B");
                        // -- numberOfRandom

                    }

                    if(randomChoice == 3 && tempPool.contains("C") )
                    {
                        // concat A to string
                        aQuestionWithMultipleChoice +="C";
                        // delete A from tempPool
                        tempPool.remove("C");
                        // -- numberOfRandom

                    }

                    if(randomChoice == 4 && tempPool.contains("D") )
                    {
                        // concat A to string
                        aQuestionWithMultipleChoice +="D";
                        // delete A from tempPool
                        tempPool.remove("D");
                        // -- numberOfRandom

                    }
                    numberOfRandomAnswer--;

                }
                answerInput[i][j] = aQuestionWithMultipleChoice;
                aQuestionWithMultipleChoice = "";   // resetting the input answer to blank

            }

        }


        return answerInput;
    }


    public static int randInt ()
    {
        int min = 1;
        int max = 4;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }


    public static String[][]singleAnswerInput(int  numberOfStudent, int numberQuestion)
    {
        // setting array size on the number of student taking the test.
        // returns an array with answer.
        // each index is a string that hold 1 random input

        // random from 1-4;  1 = A , 2 = B , 3 = C , 4 = C
        System.out.println("");
        System.out.println("Number of students voted = "+ numberOfStudent+" and their votes");
        System.out.println("==================================================================================================");


        String[][] answerInput = new String[numberOfStudent][numberQuestion];

        Random random = new Random();
        int min = 1;
        int max = 4;

        String tempAnswer = "";

        for (int i = 0; i <numberOfStudent ; i++)
        {

            for (int j = 0; j <numberQuestion  ; j++)
            {
                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
                if( random_int == 1)
                {
                    answerInput[i][j]  = "A";
                }
                if(random_int == 2)
                {
                    answerInput[i][j] = "B";
                }

                if(random_int == 3)
                {
                    answerInput[i][j] ="C";
                }

                if(random_int == 4)
                {
                    answerInput[i][j] = "D";
                }

            }
        }

        return answerInput;
    }



}






