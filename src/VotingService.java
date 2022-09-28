import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class VotingService  {
    private  ArrayList<String> testResults = new ArrayList<String>();
    public VotingService(String[][]voteCollection, String[] studentNameList )  // student name is only use to make sure that no one gets to vote twice
    {
        System.out.println("Question Tallies");
        System.out.println("==================================================================================================");
        String tempString = "";
        ArrayList<Integer> tempCheckDupeNames =  rejectList(studentNameList);
        HashMap<String, Integer> ansChoicesTally = new HashMap<String, Integer>();
        ansChoicesTally.put("A", 0);
        ansChoicesTally.put("B", 0);
        ansChoicesTally.put("C", 0);
        ansChoicesTally.put("D", 0);

        for (int i = 0; i < voteCollection[i].length; i++)
        {
            if(! tempCheckDupeNames.contains(i))    // rejecting index with older voter that voted before.  Keeps the latest votes
            {
                //go through each question a person has
                for (int k = 0; k < studentNameList.length; k++)
                {
                    for(int z = 0; z < voteCollection[k][i].length(); z++)
                    {
                        if (voteCollection[k][i].charAt(z)  == 'A')
                        {
                            Integer count = ansChoicesTally.get("A");
                            ansChoicesTally.put("A",  ++count);
                        }
                        else if (voteCollection[k][i].charAt(z) == 'B')
                        {
                            Integer count = ansChoicesTally.get("B");
                            ansChoicesTally.put("B",  ++count);
                        }
                        else if (voteCollection[k][i].charAt(z)  == 'C')
                        {
                            Integer count = ansChoicesTally.get("C");
                            ansChoicesTally.put("C",  ++count);
                        }
                        else if (voteCollection[k][i].charAt(z) == 'D')
                        {
                            Integer count = ansChoicesTally.get("D");
                            ansChoicesTally.put("D",  ++count);
                        }
                    }
                }
                printQuestionTalliesMap(ansChoicesTally, i + 1);
                ansChoicesTally.put("A",  0);
                ansChoicesTally.put("B",  0);
                ansChoicesTally.put("C",  0);
                ansChoicesTally.put("D",  0);
            }
        }
    }

    public void printQuestionTalliesMap(HashMap<String,Integer> ansChoicesTally, Integer questNum)
    {
        System.out.println("Question #" + questNum + ": ");
        ansChoicesTally.forEach((key, value) ->
                {
                    System.out.println(key + " = " + value + "");
                }
        );
    }


    private  ArrayList<Integer> rejectList(String[] studentNameList)
    {
        ArrayList<Integer> rejectArray = new ArrayList<Integer>();
        if(studentNameList.length>0)
        {
            for (int i = studentNameList.length-1 ; i >= 0; i--)
            {
                String x = studentNameList[i];
                for (int j = i; j >= 0; j--)
                {
                    if(j>0)
                    {
                        if(x.equals(studentNameList[j-1]))
                        {rejectArray.add(j - 1);}
                    }
                }
            }
        }

        System.out.println(Arrays.toString(rejectArray.toArray()));
        return rejectArray;
    }


    }













