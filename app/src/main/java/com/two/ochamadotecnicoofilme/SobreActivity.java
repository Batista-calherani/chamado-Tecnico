package com.two.ochamadotecnicoofilme;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MaterialToolbar toolbar = findViewById(R.id.toolBarTop);
        setSupportActionBar(toolbar);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtNome = findViewById(R.id.edtNome);
        EditText edtDescri = findViewById(R.id.edtDescri);
        char arromba = '@';

        btnEnviar.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String nome = edtNome.getText().toString().trim();
            String descri = edtDescri.getText().toString().trim();

            if (descri.isEmpty()) {
                edtEmail.setError("Digite o email");

                return;
            } else if (nome.isEmpty()) {
                edtNome.setError("Digite o email");

                return;
            }else if (descri.isEmpty()) {
                edtDescri.setError("Digite o email");

                return;
            }
            Toast.makeText(SobreActivity.this,"Chamado registrado", Toast.LENGTH_SHORT).show();
            finish();
        });

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_config){
            Toast.makeText(this, "Configurações selecionada.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SobreActivity.this, ConfigActivity.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId() == R.id.menu_cadastro){
            Intent intent = new Intent(SobreActivity.this, CadastroActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}