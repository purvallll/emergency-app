package com.example.emergencyapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
EditText etName, etPhone;
CheckBox cbAccident, cbMedical, cbFire;
Button btnSubmit;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);
if (sp.contains("name")) {
startActivity(new Intent(MainActivity.this,

DashboardActivity.class));
finish();
return;
}
setContentView(R.layout.activity_main);
etName = findViewById(R.id.etName);
etPhone = findViewById(R.id.etPhone);
cbAccident = findViewById(R.id.cbAccident);
cbMedical = findViewById(R.id.cbMedical);
cbFire = findViewById(R.id.cbFire);
btnSubmit = findViewById(R.id.btnSubmit);
btnSubmit.setOnClickListener(v -> {
String name = etName.getText().toString();
String phone = etPhone.getText().toString();
if (name.isEmpty() || phone.isEmpty()) {
Toast.makeText(this, "Fields cannot be empty",

Toast.LENGTH_SHORT).show();
} else {
sp.edit().putString("name", name).putString("phone",

phone).apply();

startActivity(new Intent(MainActivity.this,

DashboardActivity.class));
finish();
}
});
}
}
