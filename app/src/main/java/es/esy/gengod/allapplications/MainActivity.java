package es.esy.gengod.allapplications;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView numbersTextView = (TextView)findViewById(R.id.numbersTextView);
        numbersTextView.setText("Count = " + count + ".");
        final Button plusOneButton = (Button)findViewById(R.id.plusOneButton);
        final Button minusOneButton = (Button)findViewById(R.id.minusOneButton);
        //int count = 0;
        View.OnClickListener plusOneButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                count += (1 + r.nextInt(8));
                //count++;
                if (count > 20) {
                    AlertDialog.Builder error = new AlertDialog.Builder(MainActivity.this);
                    error.setTitle("Проигрыш!")
                            .setMessage("Вы проиграли. Вы набрали " + count + ".")
                    .setCancelable(false)
                    .setNegativeButton("Сбросить значение и начать новую игру?", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            count = 0;
                            numbersTextView.setText("Count = " + count + ".");
                        }
                    });
                    AlertDialog dialog = error.create();
                    dialog.show();
                }
                else if (count == 20) {
                    AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                    di.setTitle("Победа!")
                            .setMessage("Вы выиграли!")
                            .setCancelable(false)
                            .setPositiveButton("Сбросить значение и начать новую игру?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    count = 0;
                                    numbersTextView.setText("Count = " + count + ".");
                                }
                            });
                }
                else {
                    numbersTextView.setText("Увеличение произведено!\nCount = " + count + ".");
                }
            }
        };
        View.OnClickListener minusOneButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random(System.currentTimeMillis());
                count += (4 + r.nextInt(4));
                if (count > 20) {
                    AlertDialog.Builder error = new AlertDialog.Builder(MainActivity.this);
                    error.setTitle("Проигрыш!")
                            .setMessage("Вы проиграли. Вы набрали " + count + ".")
                            .setCancelable(false)
                            .setNegativeButton("Сбросить значение и начать новую игру?", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    count = 0;
                                    numbersTextView.setText("Count = " + count + ".");
                                }
                            });
                    AlertDialog dialog = error.create();
                    dialog.show();
                }
                else if (count == 20) {
                    AlertDialog.Builder di = new AlertDialog.Builder(MainActivity.this);
                    di.setTitle("Победа!")
                            .setMessage("Вы выиграли!")
                            .setCancelable(false)
                            .setPositiveButton("Сбросить значение и начать новую игру?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    count = 0;
                                    numbersTextView.setText("Count = " + count + ".");
                                }
                            });
                }
                else {
                    numbersTextView.setText("Увеличение произведено!\nCount = " + count + ".");
                }
            }
        };
        plusOneButton.setOnClickListener(plusOneButtonListener);
        minusOneButton.setOnClickListener(minusOneButtonListener);

    }


}
