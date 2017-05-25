package presentationlayer.techcard;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.ResultTransform;

import businesslayer.techcard.Validation;
import businessobjects.techcard.User;
import datalayer.techcard.UserService;

import static businesslayer.techcard.Validation.isValidCNPJ;
import static businesslayer.techcard.Validation.isValidCPF;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtLastName;
    private EditText txtBirth;
    private EditText txtPhone;
    private EditText txtEmail;
    private EditText txtDocument;
    private EditText txtPasswordReg;
    private EditText txtPasswordReg2;
    private Button btnSignUp;

    private UserService Usersvc = new UserService();

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = (EditText)findViewById(R.id.txtName);
        txtLastName = (EditText)findViewById(R.id.txtLastName);
        txtBirth = (EditText)findViewById(R.id.txtBirth);
        txtPhone = (EditText)findViewById(R.id.txtPhone);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtDocument = (EditText)findViewById(R.id.txtDocument);
        txtPasswordReg = (EditText)findViewById(R.id.txtPasswordReg);
        txtPasswordReg2 = (EditText)findViewById(R.id.txtPasswordReg2);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);

    }


    public void RegisterUser(View v){
                if(!txtName.getText().toString().isEmpty() && !txtLastName.getText().toString().isEmpty() &&
                !txtBirth.getText().toString().isEmpty() && !txtPhone.getText().toString().isEmpty() &&
                !txtEmail.getText().toString().isEmpty() && !txtDocument.getText().toString().isEmpty() &&
                !txtPasswordReg.getText().toString().isEmpty() && !txtPasswordReg2.getText().toString().isEmpty()){
                    if(txtBirth.getText().toString().length() == 10 && txtBirth.getText().toString().contains("/")){
                    if(txtPhone.getText().toString().length() == 11 || txtPhone.getText().toString().length() == 10){
                    if(txtEmail.getText().toString().contains("@") && txtEmail.getText().toString().length() > 8) {
                        if(isValidCPF(txtDocument.getText().toString()) || isValidCNPJ(txtDocument.getText().toString())) {
                        if(txtPasswordReg.getText().toString().length() >= 8) {
                            if (txtPasswordReg.getText().toString().equals(txtPasswordReg2.getText().toString())) {
                                try {
                                    System.out.println("Aqui estou eu!");
                                    String name = txtName.getText().toString();
                                    String lastname = txtLastName.getText().toString();
                                    String birth = txtBirth.getText().toString();
                                    String phone = txtPhone.getText().toString();
                                    String email = txtEmail.getText().toString();
                                    String document = txtDocument.getText().toString();
                                    String password = txtPasswordReg.getText().toString();
                                    String password2 = txtPasswordReg2.getText().toString();
                                    User user = new User(name, lastname, birth, phone, email, document, password);
                                    Intent it = new Intent(this, CardConfirmActivity.class);
                                    startActivity(it);
                                    finish();
                                    new UserRegister().execute();
                                    //TODO Fazer registro funcionar

                                    Bundle bunda = new Bundle();
                                    bunda.putString("email", email);
                                    bunda.putString("password", password);

                                    Intent data = new Intent(getBaseContext(), CardConfirmActivity.class);
                                    data.putExtras(bunda);
                                    startActivity(data);
                                }catch (Exception e){
                                    Toast toast = Toast.makeText(this, "Não foi possível se cadastrar, tente novamente mais tarde!",
                                            Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            } else {
                                txtPasswordReg2.setError("As senhas inseridas não são iguais, redigite as duas e tente novamente");
                            }
                        }else{
                            txtPasswordReg.setError("Insira uma senha com pelo menos 8 caracteres!");
                        }
                        }else{
                            txtDocument.setError("Insira um CPF ou CNPJ válido.");
                        }
                        }else{
                       txtEmail.setError("Digite um E-mail válido.");
                    }
                    }else{
                        txtPhone.setError("Digite seu número corretamente, com DDD e sem traços e tente novamente.");
                    }
                    }else{
                        txtBirth.setError("Redigite sua data de nascimento e tente novamente. Exemplo: 24/11/1997");
                    }

        }else{
            AlertDialog alert;
            alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Ops, Algum campo está vazio!");
            alert.setMessage("Verifique se todos os campos foram preenchidos e tente novamente.");
            alert.show();
        }

    }

    private class UserRegister extends AsyncTask<String,Void,Void>{
        private User user;
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(RegisterActivity.this);

            String name = txtName.getText().toString();
            String lastname = txtLastName.getText().toString();
            String birth = txtBirth.getText().toString();
            String phone = txtPhone.getText().toString();
            String email = txtEmail.getText().toString();
            String document = txtDocument.getText().toString();
            String password = txtPasswordReg.getText().toString();
            String password2 = txtPasswordReg2.getText().toString();
            user = new User(name, lastname, birth, phone, email, document, password);

            dialog.show();
        }


        @Override
        protected Void doInBackground(String... params) {
            try {
                Usersvc.post(user);
            } catch (RuntimeException e) {
                Log.d("e", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void whatever) {
            dialog.dismiss();
            finish();
        }

    }
}

