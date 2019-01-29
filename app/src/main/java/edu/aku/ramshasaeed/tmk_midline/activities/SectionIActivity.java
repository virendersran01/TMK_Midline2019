package edu.aku.ramshasaeed.tmk_midline.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.tmk_midline.R;
import edu.aku.ramshasaeed.tmk_midline.core.DatabaseHelper;
import edu.aku.ramshasaeed.tmk_midline.core.MainApp;
import edu.aku.ramshasaeed.tmk_midline.validation.validatorClass;

public class SectionIActivity extends AppCompatActivity {
    ActivitySectionIBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DatabaseUtils.setContentView(this, R.layout.activity_section_i);
        bi.setCallback(this);


        bi.tk0188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.tk0188x.setVisibility(View.VISIBLE);
                } else {
                    bi.tk0188x.setVisibility(View.GONE);
                    bi.tk0188x.setText(null);
                }
            }
        });

        bi.tk0288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.tk0288x.setVisibility(View.VISIBLE);
                } else {
                    bi.tk0288x.setVisibility(View.GONE);
                    bi.tk0288x.setText(null);
                }
            }
        });

        bi.tk03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.tk03c) {
                    bi.fldGrptk04.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrptk04.setVisibility(View.GONE);
                    bi.tk04.setText(null);
                    bi.tk0498.setChecked(false);
                    bi.tk05.clearCheck();
                }
            }
        });

        bi.tk0498.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.tk04.setVisibility(View.GONE);
                    bi.tk04.setText(null);
                } else {
                    bi.tk04.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.tk08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (bi.tk08a.isChecked()) {
                    bi.fldGrptk09.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrptk09.setVisibility(View.GONE);
                    bi.tk09.clearCheck();
                    bi.tk0988x.setText(null);
                }
            }
        });

        bi.tk0988.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.tk0988x.setVisibility(View.VISIBLE);
                } else {
                    bi.tk0988x.setVisibility(View.GONE);
                    bi.tk0988x.setText(null);
                }
            }
        });

        bi.tk1098.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.tk1098x.setVisibility(View.VISIBLE);
                } else {
                    bi.tk1098x.setVisibility(View.GONE);
                    bi.tk1098x.setText(null);
                }
            }
        });

        bi.tk12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (bi.tk12a.isChecked()) {
                    bi.fldGrptk13.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrptk13.setVisibility(View.GONE);
                    bi.tk13.clearCheck();
                    bi.tk14.clearCheck();
                }
            }
        });

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sK = new JSONObject();

        sK.put("tk01", bi.tk01a.isChecked() ? "1" : bi.tk01b.isChecked() ? "2" : bi.tk01c.isChecked() ? "3" : bi.tk01d.isChecked() ? "4"
                : bi.tk01e.isChecked() ? "5" : bi.tk01f.isChecked() ? "6" : bi.tk01g.isChecked() ? "7" : bi.tk01h.isChecked() ? "8"
                : bi.tk01i.isChecked() ? "9" : bi.tk01j.isChecked() ? "10" : bi.tk01k.isChecked() ? "11" : bi.tk01l.isChecked() ? "12"
                : bi.tk01m.isChecked() ? "13" : bi.tk01n.isChecked() ? "14" : bi.tk0196.isChecked() ? "96" : "0");
        sK.put("tk0196x", bi.tk0196x.getText().toString());

        sK.put("tk02", bi.tk02a.isChecked() ? "1" : bi.tk02b.isChecked() ? "2" : bi.tk02c.isChecked() ? "3" : bi.tk02d.isChecked() ? "4"
                : bi.tk02e.isChecked() ? "5" : bi.tk02f.isChecked() ? "6" : bi.tk02g.isChecked() ? "7" : bi.tk02h.isChecked() ? "8"
                : bi.tk02i.isChecked() ? "9" : bi.tk02j.isChecked() ? "10" : bi.tk02k.isChecked() ? "11" : bi.tk02l.isChecked() ? "12"
                : bi.tk02m.isChecked() ? "13" : bi.tk02n.isChecked() ? "14" : bi.tk0296.isChecked() ? "96" : "0");
        sK.put("tk0296x", bi.tk0296x.getText().toString());
        sK.put("tk03", bi.tk03a.isChecked() ? "1" : bi.tk03b.isChecked() ? "2" : bi.tk03c.isChecked() ? "3" : "0");
        sK.put("tk04", bi.tk04.getText().toString());
        sK.put("tk0498", bi.tk0498.isChecked() ? "98" : "0");
        sK.put("tk05", bi.tk05a.isChecked() ? "1" : bi.tk05b.isChecked() ? "2" : bi.tk05c.isChecked() ? "3" :
                bi.tk05d.isChecked() ? "4" : bi.tk05e.isChecked() ? "5" : "0");
        sK.put("tk06", bi.tk06a.isChecked() ? "1" : bi.tk06b.isChecked() ? "2" : "0");
        sK.put("tk07", bi.tk07a.isChecked() ? "1" : bi.tk07b.isChecked() ? "2" : bi.tk0798.isChecked() ? "98" : "0");
        sK.put("tk08", bi.tk08a.isChecked() ? "1" : bi.tk08b.isChecked() ? "2" : bi.tk0898.isChecked() ? "98" : "0");
        sK.put("tk09", bi.tk09a.isChecked() ? "1" : bi.tk09b.isChecked() ? "2" : bi.tk09c.isChecked() ? "3" : bi.tk09d.isChecked() ? "4"
                : bi.tk09e.isChecked() ? "5" : bi.tk09f.isChecked() ? "6" : bi.tk09g.isChecked() ? "7" : bi.tk0998.isChecked() ? "88" : "0");
        sK.put("tk0998x", bi.tk0998x.getText().toString());

        sK.put("tk10", bi.tk10a.isChecked() ? "1" : bi.tk10b.isChecked() ? "2" : bi.tk10c.isChecked() ? "3" : bi.tk10d.isChecked() ? "4"
                : bi.tk10e.isChecked() ? "5" : bi.tk1098.isChecked() ? "88" : "0");
        sK.put("tk1098x", bi.tk1098x.getText().toString());

        sK.put("tk11", bi.tk11a.isChecked() ? "1" : bi.tk11b.isChecked() ? "2" : bi.tk11c.isChecked() ? "3" : bi.tk11d.isChecked() ? "4"
                : bi.tk11e.isChecked() ? "5" : bi.tk11f.isChecked() ? "6" : bi.tk11g.isChecked() ? "7" : bi.tk11h.isChecked() ? "8"
                : bi.tk11i.isChecked() ? "9" : bi.tk11j.isChecked() ? "10" : bi.tk11k.isChecked() ? "11" : "0");

        sK.put("tk12", bi.tk12a.isChecked() ? "1" : bi.tk12b.isChecked() ? "2" : bi.tk1298.isChecked() ? "98" : "0");
        sK.put("tk13", bi.tk13a.isChecked() ? "1" : bi.tk13b.isChecked() ? "2" : "0");
        sK.put("tk14", bi.tk14a.isChecked() ? "1" : bi.tk14b.isChecked() ? "2" : bi.tk1498.isChecked() ? "98" : "0");

        MainApp.fc.setsK(String.valueOf(sK));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }
    public boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
      
            if (!validatorClass.EmptyRadioButton(this, bi.tk01,bi.tk0196,tk0196x, getString(R.string.tk01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.tk02,bi.tk0296,tk0296x, getString(R.string.tk02))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.tk03, getString(R.string.tk03))) {
                return false;
            }
            if(!bi.tk0498.isChecked()){
                if (!validatorClass.EmptyTextBox(this, bi.tk04, getString(R.string.tk04))) {
                    return false;
                }
            }
        if (!validatorClass.EmptyRadioButton(this, bi.tk05, getString(R.string.tk05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk06, getString(R.string.tk06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk07, getString(R.string.tk07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk08, getString(R.string.tk08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk0996, bi.tk0996x, getString(R.string.tk09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk1096, bi.tk1096x, getString(R.string.tk10))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk11, getString(R.string.tk11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk12, getString(R.string.tk12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk13, getString(R.string.tk13))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tk14, getString(R.string.tk14))) {
            return false;
        }

      
        return true;
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addChild(MainApp.ims);
        MainApp.ims.set_ID(String.valueOf(updcount));

        if (updcount != -1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.ims.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.ims.get_ID()));
            db.updateChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    public void BtnContinue() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                //finish();

                if (MainApp.imsCount < MainApp.totalImsCount) {
                    finish();

                    MainApp.imsCount++;

                    MainApp.lstChild.remove(MainApp.positionIm);
                    MainApp.childsMap.remove(MainApp.positionIm);
                    MainApp.flag = false;
                    Intent secNext = new Intent(this, SectionIActivity.class);
                    //tiname.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, MainApp.lstChild));
                    startActivity(secNext);


                } else {
                    MainApp.imsCount = 0;

                    Intent secNext = new Intent(this, SectionJActivity.class);
                    startActivity(secNext);
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void BtnEnd() {

    }


}