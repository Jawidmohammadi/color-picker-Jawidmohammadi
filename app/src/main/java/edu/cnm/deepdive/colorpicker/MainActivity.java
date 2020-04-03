package edu.cnm.deepdive.colorpicker;

import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

  SeekBar red, green, blue;
  ConstraintLayout constraintLayout;
  TextView color, rr, gg, bb;
  TextView hex;
  int r=0, g=0, b=0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    red=findViewById(R.id.red);
    green = findViewById(R.id.green);
    blue = findViewById(R.id.blue);
    color = findViewById(R.id.color);
    hex = findViewById(R.id.hex);
    red.setOnSeekBarChangeListener(this);
    green.setOnSeekBarChangeListener(this);
    blue.setOnSeekBarChangeListener(this);
    rr = findViewById(R.id.rr);
    gg = findViewById(R.id.gg);
    bb = findViewById(R.id.bb);
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    switch (seekBar.getId()){
      case R.id.red:
        r=progress;
      break;
      case R.id.green:
        g=progress;
      break;
      case R.id.blue:
        b=progress;
      break;
    }

    String c = colorHex(r,g,b);
    hex.setText("Hex: " + c);
    color.setBackgroundColor(android.graphics.Color.rgb(r,g,b));
  }

  public String colorHex(int r, int g, int b){
    String color= "";

    color= "#";
    color+=Integer.toHexString(r);
    color+=Integer.toHexString(g);
    color+=Integer.toHexString(b);
    return color;
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {
    rr.setText("R: " + r);
    gg.setText("G: " + g);
    bb.setText("B: " + b);
  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    rr.setText("R: " + r);
    gg.setText("G: " + g);
    bb.setText("B: " + b);
  }
}
