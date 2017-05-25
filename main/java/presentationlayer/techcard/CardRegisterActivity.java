package presentationlayer.techcard;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import businessobjects.techcard.Card;

public class CardRegisterActivity extends AppCompatActivity {
    private EditText txtCard_Title;
    private EditText txtCard_Description;
    private EditText txtCard_Phone;
    private EditText txtCard_Phone2;
    private EditText txtCard_Key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_register);

        txtCard_Title = (EditText)findViewById(R.id.txtCard_Title);
        txtCard_Description = (EditText)findViewById(R.id.txtCard_Description);
        txtCard_Phone = (EditText)findViewById(R.id.txtCard_Phone);
        txtCard_Phone2 = (EditText)findViewById(R.id.txtCard_Phone2);
        txtCard_Key = (EditText)findViewById(R.id.txtCard_Key);
    }

    public void RegisterCard(View v) {
        if (!txtCard_Title.getText().toString().isEmpty() && !txtCard_Description.toString().toString().isEmpty()) {
            if (txtCard_Title.getText().toString().length() >= 6) {
                if (txtCard_Description.getText().toString().length() >= 10) {
                    if(!txtCard_Key.getText().toString().isEmpty()){
                        if(txtCard_Phone.equals(null) && txtCard_Phone2.equals(null)) {
                            try {
                                String title = txtCard_Title.getText().toString();
                                String description = txtCard_Description.getText().toString();
                                String key = txtCard_Key.getText().toString();
                                Card card = new Card(title, description, null, null, key);
                                System.out.printf("Onde você pensa que está? Aqui é BRASIL!");
                            }catch (Exception e){
                                Toast toast = Toast.makeText(this, "Não foi possível cadastrar o TechCard agora, tente novamente mais tarde!",
                                        Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }else if(!txtCard_Phone.equals(null) && txtCard_Phone2.equals(null)) {
                            try {
                                String title = txtCard_Title.getText().toString();
                                String description = txtCard_Description.getText().toString();
                                String key = txtCard_Key.getText().toString();
                                String phone = txtCard_Phone.getText().toString();
                                Card card = new Card(title, description, phone, null, key);
                                System.out.printf("Onde você pensa que está? Aqui é BRASIL!");
                            }catch (Exception e){
                                Toast toast = Toast.makeText(this, "Não foi possível cadastrar o TechCard agora, tente novamente mais tarde!",
                                        Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }else if(txtCard_Phone.equals(null) && !txtCard_Phone2.equals(null)){
                            try {
                                String title = txtCard_Title.getText().toString();
                                String description = txtCard_Description.getText().toString();
                                String key = txtCard_Key.getText().toString();
                                String phone = txtCard_Phone.getText().toString();
                                Card card = new Card(title, description, phone, null, key);
                                System.out.printf("Onde você pensa que está? Aqui é BRASIL!");
                            }catch (Exception e){
                                Toast toast = Toast.makeText(this, "Não foi possível cadastrar o TechCard agora, tente novamente mais tarde!",
                                        Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }else{
                            try {
                                String title = txtCard_Title.getText().toString();
                                String description = txtCard_Description.getText().toString();
                                String phone = txtCard_Phone.getText().toString();
                                String phone2 = txtCard_Phone2.getText().toString();
                                String key = txtCard_Key.getText().toString();
                                Card card = new Card(title, description, phone, phone2, key);
                                System.out.printf("Onde você pensa que está? Aqui é BRASIL!");
                            }catch (Exception e){
                                Toast toast = Toast.makeText(this, "Não foi possível cadastrar o TechCard agora, tente novamente mais tarde!",
                                        Toast.LENGTH_LONG);
                                toast.show();
                            }
                        }
                }else{
                        txtCard_Key.setError("Digite ao menos uma palavra chave");
                    }
                } else {
                    txtCard_Description.setError("Insira uma descrição com mais de 10 caracteres");
                }
            } else {
                txtCard_Title.setError("Insira um título com mais de 6 caracteres!");
            }
        }else{
            AlertDialog alert;
            alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Ops, Algum campo obrigatório está vazio!");
            alert.setMessage("Título ou Descrição estão vazio, complete os campos obrigatórios e tente novamente.");
            alert.show();
        }
    }

    //TODO Fazer conexão com webservice
}
