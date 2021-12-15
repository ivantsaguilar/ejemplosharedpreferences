package sharepreferences.example.ivants.cmdsharepreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimeLine extends AppCompatActivity {

    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        welcome = (TextView)findViewById(R.id.welcome);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        if (data != null){
            String user  = intent.getStringExtra("user");
            welcome.setText("Bienvenido " + user + "!!!!!!!");
        }

    }
}
