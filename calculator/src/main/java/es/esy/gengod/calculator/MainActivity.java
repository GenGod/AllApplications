package es.esy.gengod.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public boolean isEquals = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView resultView = (TextView)findViewById(R.id.ResultView);
        final TextView expressionView = (TextView)findViewById(R.id.ExpressionView);

        resultView.setText("");
        expressionView.setText("0");
        View.OnClickListener buttonsListener = v -> {
            Button temp = (Button)v;
            if (expressionView.getText().equals("0") || isEquals)
            {
                expressionView.setText(temp.getText());
            }
            else
                expressionView.setText((expressionView.getText() + temp.getText().toString()));
            isEquals = false;
        };

        @SuppressLint("SetTextI18n") View.OnClickListener operatorsButtonsListener = v -> {
            Button temp = (Button)v;
            if (!expressionView.getText().toString().equals("0") || isEquals)
            {
                if (!Character.isDigit(expressionView.getText().charAt(expressionView.length() - 1)))
                {
                    StringBuilder text = new StringBuilder(expressionView.getText());
                    text.deleteCharAt(text.length() - 1);
                    expressionView.setText(text.toString() + temp.getText());
                }
                else
                    expressionView.setText((expressionView.getText() + temp.getText().toString()));
            }
            else {
                expressionView.setText((expressionView.getText() + temp.getText().toString()));
            }
            isEquals = false;
        };

        View.OnClickListener commaButtonListener = v -> {
            if (expressionView.getText().length() == 1) {
                expressionView.setText((expressionView.getText() + "."));
            }
            else {
                String[] s = expressionView.getText().toString().split("[^\\d^.]");
                boolean isNeed = true;
                if (s[s.length - 1].contains("."))
                    isNeed = false;
                if (isNeed || isEquals) {
                    expressionView.setText((expressionView.getText() + "."));
                }
            }
            isEquals = false;
        };

        @SuppressLint("SetTextI18n") View.OnClickListener negativeButtonListener = v -> {
            StringBuilder text = new StringBuilder(expressionView.getText());
            if ((text.indexOf("0") != 0) || isEquals)
            {
                if (text.indexOf("-") == 0)
                    expressionView.setText(text.deleteCharAt(0));
                else
                    expressionView.setText("-" + expressionView.getText());
            }
            isEquals = false;
        };

        View.OnClickListener ceButtonListener = v -> {
            expressionView.setText("0");
            resultView.setText("");
        };

        View.OnClickListener backSpaceButtonListener = v -> {
            if (expressionView.getText().length() > 0 || isEquals) {
                StringBuilder temp = new StringBuilder(expressionView.getText());
                if (expressionView.getText().length() == 1)
                    expressionView.setText("0");
                else
                    expressionView.setText(temp.deleteCharAt(temp.length() - 1));
            }
            isEquals = false;
        };

        View.OnClickListener equalsButtonListener = v -> {
            String[] strings = expressionView.getText().toString().trim().split("[^\\d^.]");
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < expressionView.getText().toString().length(); i++) {
                if (expressionView.getText().charAt(i) == '+' || expressionView.getText().charAt(i) == '-'
                        || expressionView.getText().charAt(i) == '*' || expressionView.getText().charAt(i) == '/')
                {
                    t.append(expressionView.getText().charAt(i));
                }
            }
            StringBuilder temp = new StringBuilder();
            int j = 0;
            for (int i = 0; i < strings.length; i++)
            {
                switch (t.charAt(j)) {
                    case '+':
                        if (temp.length() == 0) {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(strings[i]) + Double.parseDouble(strings[i + 1])));
                            if (i < strings.length - 1) ++i;
                        }
                        else {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(temp.toString()) + Double.parseDouble(strings[i])));
                        }
                        break;
                    case '-':
                        if (temp.length() == 0) {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(strings[i]) - Double.parseDouble(strings[i + 1])));
                            if (i < strings.length - 1) ++i;
                        }
                        else {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(temp.toString()) - Double.parseDouble(strings[i])));
                        }
                        break;
                    case '*':
                        if (temp.length() == 0) {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(strings[i]) * Double.parseDouble(strings[i + 1])));
                            if (i < strings.length - 1) ++i;
                        }
                        else {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(temp.toString()) * Double.parseDouble(strings[i])));
                        }
                        break;
                    case '/':
                        if (temp.length() == 0) {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(strings[i]) / Double.parseDouble(strings[i + 1])));
                            if (i < strings.length - 1) ++i;
                        }
                        else {
                            temp.replace(0, temp.length(), Double.toString(Double.parseDouble(temp.toString()) / Double.parseDouble(strings[i])));
                        }
                        break;
                }
                j++;
            }
            isEquals = true;
            String firstPart = temp.substring(0, temp.indexOf("."));
            String secondPart = temp.substring(temp.indexOf(".") + 1);
            if (secondPart.equals("0"))
                resultView.setText(firstPart);
            else
                resultView.setText(temp);
        };

        final Button oneButton = (Button)findViewById(R.id.OneButton);
        oneButton.setOnClickListener(buttonsListener);
        final Button twoButton = (Button)findViewById(R.id.TwoButton);
        twoButton.setOnClickListener(buttonsListener);
        final Button threeButton = (Button)findViewById(R.id.ThreeButton);
        threeButton.setOnClickListener(buttonsListener);
        final Button fourButton = (Button)findViewById(R.id.FourButton);
        fourButton.setOnClickListener(buttonsListener);
        final Button fiveButton = (Button)findViewById(R.id.FiveButton);
        fiveButton.setOnClickListener(buttonsListener);
        final Button sixButton = (Button)findViewById(R.id.SixButton);
        sixButton.setOnClickListener(buttonsListener);
        final Button sevenButton = (Button)findViewById(R.id.SevenButton);
        sevenButton.setOnClickListener(buttonsListener);
        final Button eightButton = (Button)findViewById(R.id.EightButton);
        eightButton.setOnClickListener(buttonsListener);
        final Button nineButton = (Button)findViewById(R.id.NineButton);
        nineButton.setOnClickListener(buttonsListener);
        final Button zeroButton = (Button)findViewById(R.id.ZeroButton);
        zeroButton.setOnClickListener(buttonsListener);
        final Button backSpaceButton = (Button)findViewById(R.id.BackSpaceButton);
        backSpaceButton.setOnClickListener(backSpaceButtonListener);
        final Button ceButton = (Button)findViewById(R.id.CEButton);
        ceButton.setOnClickListener(ceButtonListener);
        final Button comaButton = (Button)findViewById(R.id.ComaButton);
        comaButton.setOnClickListener(commaButtonListener);
        final Button divButton = (Button)findViewById(R.id.DivButton);
        divButton.setOnClickListener(operatorsButtonsListener);
        final Button plusButton = (Button)findViewById(R.id.PlusButton);
        plusButton.setOnClickListener(operatorsButtonsListener);
        final Button minusButton = (Button)findViewById(R.id.MinusButton);
        minusButton.setOnClickListener(operatorsButtonsListener);
        final Button multButton = (Button)findViewById(R.id.MultButton);
        multButton.setOnClickListener(operatorsButtonsListener);
        final Button negativeButton = (Button)findViewById(R.id.NegativeButton);
        negativeButton.setOnClickListener(negativeButtonListener);
        final Button equalsButton = (Button)findViewById(R.id.EqualsButton);
        equalsButton.setOnClickListener(equalsButtonListener);
    }
}