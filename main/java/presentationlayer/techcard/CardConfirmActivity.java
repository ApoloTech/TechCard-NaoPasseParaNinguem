package presentationlayer.techcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CardConfirmActivity extends AppCompatActivity {

    private TextView txtCardConfirm;
    private Button btnYes;
    private Button btnNo;
    private TextView txtWhatIsTechCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_confirm);

        txtCardConfirm = (TextView)findViewById(R.id.txtCardConfirm);
        btnYes = (Button) findViewById(R.id.btnYes);
        btnNo = (Button) findViewById(R.id.btnNo);
        txtWhatIsTechCard = (TextView)findViewById(R.id.txtWhatIsTechCard);

        Bundle bunda = getIntent().getExtras();
        String email = bunda.getString("email");
        String password = bunda.getString("password");
        //TODO armazenar os dados

    }

    public void GoRegisterTechCard(View v){
        Intent it = new Intent(this,CardRegisterActivity.class);
        startActivity(it);
    }

    public void GoToMap(View v){
        Intent it = new Intent(this,MyMapActivity.class);
        startActivity(it);
        finish();
    }

    public void WhatTheFuckIsThis(View v){
        Intent it = new Intent(this,AboutActivity.class);
        startActivity(it);
    }


}
