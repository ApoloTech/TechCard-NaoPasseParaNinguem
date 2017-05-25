package presentationlayer.techcard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtPassword;
    private Button btnSignIn;
    private TextView txtForgetPassword;
    private TextView txtSignUp;

    //SharedPreferences prefs= getSharedPreferences("preferencia",MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = (EditText)findViewById(R.id.txtLogin);
        txtPassword= (EditText)findViewById(R.id.txtPassword);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        txtSignUp = (TextView)findViewById(R.id.txtSignUp);
        txtForgetPassword = (TextView)findViewById(R.id.txtForgetPassword);

        }

    public void Login(View v){
        if (!txtLogin.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()) {
            if (txtLogin.getText().toString().equals("Paulo") && txtPassword.getText().toString().equals("123")) {
                Intent GoToMap = new Intent(this, MapEditActivity.class);
                startActivity(GoToMap);
                finish();
                //TODO Fazer Login
            }else{
                AlertDialog alert;
                alert = new AlertDialog.Builder(this).create();
                alert.setTitle("Ops, Ocorreu um erro!");
                alert.setMessage("Usuário ou senha estão incorretos!");
                alert.show();
            }
        }else {
                AlertDialog alert;
                alert = new AlertDialog.Builder(this).create();
                alert.setTitle("Ops, Ocorreu um erro!");
                alert.setMessage("Campos de Usuário e Senha estão vazios!");
                alert.show();
            }
    }


    public void GoToRegister(View v) {
        Intent GoRegister = new Intent(this, RegisterActivity.class);
        startActivity(GoRegister);
    }


    public void GoToRecoverPassword(View v){
        Intent GoRecover = new Intent(this, RecoverPasswordActivity.class);
        startActivity(GoRecover);
    }
}
