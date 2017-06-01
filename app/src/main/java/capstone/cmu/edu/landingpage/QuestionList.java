package capstone.cmu.edu.landingpage;

public class QuestionList {

    //Questions stored in an array that is accessed by the qNumber attribute in the TriviaActivity class
    private String questions [] = {
            "Which factor does not affect blood glucose levels? ",
            "What causes Type 1 Diabetes?",
            "Who can develop gestational diabetes?",
            "What symptoms can a diabetes person experience?",
            "How many types of diabetes are there?",
            "What is the cure for diabetes?",
            "Which of the following can cause your BG levels to rise?",
            "Which of the following health issues is not mitigated via diabetes management?",
            "What percentage of people have Type 1 Diabetes?",
            "The hormone created in the pancreas is called _______.",
            "Which of the following quantities is not necessary to monitor in diabetes management?",
            "Your target A1C should be  _____.",
            "What places can be used to check your blood sugar?",
            "You need to lose at least _____ % of your body weight to aid in diabetes management",
            "Which is not a symptom of low blood sugar?",
            "According to the World Health Organization, total diabetes-related fatalities are projected to rise by more than _____ in the next decade.",
            "Vitamin ____ reduces the risk of diabetes.",
            "Prediabetes puts you at an increased risk of _____ diabetes.",
            "Answer if true or false and fill in the blank. Certain ethnicities can be at a higher risk of developing type ____ diabetes.",
            "Today, there are more than ____ classes of oral medicines to manage and treat diabetes."

    };

    //Options stored in a 2D array. 4 options for each question are displayed to the user
    private String options [][] = {
            {"Carbohydrates", "Stress", "Sugar substitutes", "Illness"},
            {"Being at an unhealthy weight", "Diet", "Sedentary lifestyle", "Autoimmune response"},
            {"Pregnant women", "Men", "Infants", "People aged 55+"},
            {"Fatigue", "Frequent urination", "Slow to heal wounds", "All of the above"},
            {"One", "Two", "Three", "More than four"},
            {"Time", "Insulin", "There is no cure", "Diet"},
            {"Pasta", "Fish", "Eggs", "All of the above"},
            {"Kidney failure", "Vision loss", "Melanoma", "Heart Disease"},
            {"10", "5", "33", "19"},
            {"Lipid", "Insulin", "Cholesterol", "All of the above"},
            {"Blood glucose", "A1C", "Heartbeats per minute" ,"Cholesterol"},
            {"At least less than 7%", "At least less than 9%", "More than 15%", "More than 30%"},
            {"Fingertips", "Forearms", "Thighs", "All of the above"},
            {"20", "5-10", "More than half", "All of the above"},
            {"Trouble focusing", "Spinal aches", "Clammy/sweaty skin", "Hunger"},
            {"90%", "22%", "10%", "50%"},
            {"A", "C", "D", "E"},
            {"Type 1", "Type 2", "Gestational", "All of the above"},
            {"True, 1", "True, 2", "False, 1", "False, 2"},
            {"10", "12", "9", "7"}

    };

    //This array stores the list of correct answers
    private String correctAnswers [] = {
            "Sugar substitutes", "Autoimmune response", "Pregnant women", "All of the above", "Three",
            "There is no cure", "Pasta", "Melanoma", "5", "Insulin", "Heartbeats per minute", "At least less than 7%", "All of the above", "5-10", "Spinal aches",
            "50%", "D", "Type 2", "True, 2", "7"
    };

    /*
This method fetches the question to display to the user
 */
    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    /*
This method fetches the first option for the question displayed
 */
    public String getOptionOne (int a){
        String option1 = options[a][0];
        return option1;
    }

    /*
This method fetches the second option for the question displayed
*/
    public String getOptionTwo (int a){
        String option2 = options[a][1];
        return option2;
    }

    /*
This method fetches the third option for the question displayed
*/
    public String getOptionThree (int a){
        String option3 = options[a][2];
        return option3;
    }

    /*
This method fetches the fourth option for the question displayed
*/
    public String getOptionFour (int a){
        String option4 = options[a][3];
        return option4;
    }

    /*
This method is used to verify if the option chosen by the user is the right answer
*/
    public String rightAnswer(int a){
        String answer = correctAnswers[a];
        return answer;
    }
}
