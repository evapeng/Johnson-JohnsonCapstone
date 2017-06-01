package capstone.cmu.edu.landingpage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TriviaActivity extends Activity {

    //Creating an instance of the QuestionList class to fetch trivia questions
    private QuestionList questionList = new QuestionList();

    private TextView viewScore;//This text view is to display the score
    private TextView viewQuestion; //This text view is to display the question

    //Buttons to display the options to choose the answer from
    private Button option1Button;
    private Button option2Button;
    private Button option3Button;
    private Button option4Button;

    private String answer;
    private int score =0;
    private int qNumber = 0;

    /*
    This method fetches the trivia questions when the user chooses to play a game from the main menu options
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        viewScore = (TextView) findViewById(R.id.score);
        viewQuestion = (TextView) findViewById(R.id.question);
        option1Button = (Button) findViewById(R.id.option1);
        option2Button = (Button) findViewById(R.id.option2);
        option3Button = (Button) findViewById(R.id.option3);
        option4Button = (Button) findViewById(R.id.option4);

        updateQuestion(); //To move to the next question
        //On selecting the first option, it checks whether the option selected is the correct answer and if it is, the score is
        //incremeted by 1
        option1Button.setOnClickListener(new View.OnClickListener() {

                                             public void onClick(View view) {
                                                 if (option1Button.getText() == answer) {
                                                     score = score + 1;
                                                     updateScore(score); //Increment and update score
                                                     updateQuestion(); //Go to the next question
                                                     Snackbar.make(view, "Right Answer", Snackbar.LENGTH_SHORT)
                                                             .setAction("Action", null).show();    //Display if the answer is right
                                                 }
                                                 else {
                                                     //Display that the answer is wrong and also show the right answer
                                                     Snackbar.make(view, "Wrong Answer (Right Answer is : "+answer+")", Snackbar.LENGTH_LONG)
                                                             .setAction("Action", null).show();
                                                     updateQuestion(); //Go to the next question
                                                 }
                                             }
                                         }
        );

        //On selecting the second option, it checks whether the option selected is the correct answer and if it is, the score is
        //incremeted by 1
        option2Button.setOnClickListener(new View.OnClickListener() {

                                             public void onClick(View view) {
                                                 if (option2Button.getText() == answer) {
                                                     score = score + 1;
                                                     updateScore(score); //Increment and update score
                                                     updateQuestion(); //Go to the next question

                                                     Snackbar.make(view, "Right Answer", Snackbar.LENGTH_SHORT)
                                                             .setAction("Action", null).show();     //Display if the answer is right
                                                 }
                                                 else {
                                                     //Display that the answer is wrong and also show the right answer
                                                     Snackbar.make(view, "Wrong Answer (Right Answer is : "+answer+")", Snackbar.LENGTH_LONG)
                                                             .setAction("Action", null).show();
                                                     updateQuestion(); //Go to the next question
                                                 }
                                             }
                                         }
        );

        //On selecting the third option, it checks whether the option selected is the correct answer and if it is, the score is
        //incremeted by 1
        option3Button.setOnClickListener(new View.OnClickListener() {

                                             public void onClick(View view) {
                                                 if (option3Button.getText() == answer) {
                                                     score = score + 1;
                                                     updateScore(score); //Increment and update score
                                                     updateQuestion(); //Go to the next question
                                                     Snackbar.make(view, "Right Answer", Snackbar.LENGTH_SHORT)
                                                             .setAction("Action", null).show();    //Display if the answer is right
                                                 }
                                                 else {
                                                     //Display that the answer is wrong and also show the right answer
                                                     Snackbar.make(view, "Wrong Answer (Right Answer is : "+answer+")", Snackbar.LENGTH_LONG)
                                                             .setAction("Action", null).show();
                                                     updateQuestion(); //Go to the next question
                                                 }
                                             }
                                         }
        );

        //On selecting the fourth option, it checks whether the option selected is the correct answer and if it is, the score is
        //incremeted by 1
        option4Button.setOnClickListener(new View.OnClickListener() {

                                             public void onClick(View view) {
                                                 if (option4Button.getText() == answer) {
                                                     score = score + 1;
                                                     updateScore(score); //Increment and update score
                                                     updateQuestion(); //Go to the next question
                                                     Snackbar.make(view, "Right Answer", Snackbar.LENGTH_SHORT)
                                                             .setAction("Action", null).show();  //Display if the answer is right
                                                 }
                                                 else {
                                                     //Display that the answer is wrong and also show the right answer
                                                     Snackbar.make(view, "Wrong Answer (Right Answer is : "+answer+")", Snackbar.LENGTH_LONG)
                                                             .setAction("Action", null).show();
                                                     updateQuestion(); //Go to the next question
                                                 }
                                             }
                                         }
        );

    }

    /*
    This method fetches the question the first time as well as when the question is to be updated.
    It also fetches the respective options for each question
    */
    private void updateQuestion(){
        viewQuestion.setText(questionList.getQuestion(qNumber));
        option1Button.setText(questionList.getOptionOne(qNumber));
        option2Button.setText(questionList.getOptionTwo(qNumber));
        option3Button.setText(questionList.getOptionThree(qNumber));
        option4Button.setText(questionList.getOptionFour(qNumber));

        answer = questionList.rightAnswer(qNumber);
        qNumber++;
    }

    /*
   This method updates the score when the right answer is chosen
    */
    public void updateScore(int point){
        viewScore.setText(""+score);
    }

    /*
  On clicking the quit button, the main page of the app is displayed
   */
    public void onClickQuit(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
