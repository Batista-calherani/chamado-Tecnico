package com.two.ochamadotecnicoofilme;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;

    private TextInputEditText edtEmail,edtNumber,edtNome;

    private TextInputLayout ilEmail,ilNumber,ilNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ilEmail = findViewById(R.id.ilEmail);
        ilNome = findViewById(R.id.ilNome);
        ilNumber = findViewById(R.id.ilNumber);
        edtEmail = findViewById(R.id.edtEmail);
        edtNome = findViewById(R.id.edtNome);
        edtNumber = findViewById(R.id.edtNumber);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equipamento = edtNome.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String Number = edtNumber.getText().toString().trim();

                ilEmail.setError(null);
                ilNome.setError(null);
                ilNumber.setError(null);

                if(email.isEmpty()){
                    ilEmail.setError("informe o e-mail");
                    return;
                }else if (equipamento.isEmpty()){
                    ilNome.setError("informe o equipamento");
                } else if (Number.isEmpty()) {
                    ilNumber.setError("informe o numero do patrimonio");
                } else {
                    Toast.makeText(MainActivity.this, "Gerando pedido...", Toast.LENGTH_SHORT).show();
                    ViewGroup pai = (ViewGroup) ilNumber.getParent();
                    pai.removeView(ilNome);
                    pai.removeView(ilEmail);
                    pai.removeView(ilNumber);
                    TextView title = findViewById(R.id.Cadastro);
                    TextView text = findViewById(R.id.paragraf);
                    title.setText("Registro Com Sucesso");
                    text.setText("Equipamento registrado: " + equipamento);
                    TableLayout tabela = new TableLayout(MainActivity.this);
                    TextView equipa = new TextView(MainActivity.this);
                    TextView emai = new TextView(MainActivity.this);
                    TextView num = new TextView(MainActivity.this);
                    equipa.setText("Equipamento: " + equipamento);
                    num.setText("N° do patrimônio: "+Number);
                    emai.setText("Email de Contato: "+email);
                    tabela.setX(125F);
                    tabela.setY(300F);
                    tabela.addView(equipa);
                    tabela.addView(emai);
                    tabela.addView(num);
                    pai.addView(tabela);
                }
            }
        });
    }
}