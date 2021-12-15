package sharepreferences.example.ivants.cmdsharepreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText user, password;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.password);
        guardar = (Button)findViewById(R.id.guardar);

        SharedPreferences preferences = getSharedPreferences("login",Context.MODE_PRIVATE);
        user.setText(preferences.getString("user",null));
        password.setText(preferences.getString("contrasena",null));

        if (user != null && password != null){
            //Compruebo que el usuario y la contraseña guardado en el equipo sea la misma
            //que en el archivo de las preferencias porqur el usario puede actualizar su contraseña y yo tendría
            //que guardar esas preferecias nuevamente
            if (user.getText().toString().equals("ivan") && password.getText().toString().equals("123")){
                Intent intent = new Intent( this, TimeLine.class);
                intent.putExtra("user",user.getText().toString());
                startActivity(intent);
            }
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = user.getText().toString();
                String contrasena = password.getText().toString();
                SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor  = preferences.edit();
                editor.putString("user",usuario);
                editor.putString("contrasena", contrasena);
                editor.apply();
                //editor.commit();
                finish();//cerramos la aplicacion

            }
        });



    }
}
