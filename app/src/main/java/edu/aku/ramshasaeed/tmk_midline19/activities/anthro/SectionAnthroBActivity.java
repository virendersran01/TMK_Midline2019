package edu.aku.ramshasaeed.tmk_midline19.activities.anthro;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.ramshasaeed.tmk_midline19.R;
import edu.aku.ramshasaeed.tmk_midline19.activities.EndingActivity;
import edu.aku.ramshasaeed.tmk_midline19.activities.SectionEActivity;
import edu.aku.ramshasaeed.tmk_midline19.activities.SectionGActivity;
import edu.aku.ramshasaeed.tmk_midline19.core.DatabaseHelper;
import edu.aku.ramshasaeed.tmk_midline19.core.MainApp;
import edu.aku.ramshasaeed.tmk_midline19.databinding.ActivitySectionAnthroBBinding;
import edu.aku.ramshasaeed.tmk_midline19.validation.ValidatorClass02;

/*import static edu.aku.ramshasaeed.tmk_midline19.activities.anthro.SectionInfoAnthroActivity.childrenName;
import static edu.aku.ramshasaeed.tmk_midline19.activities.anthro.SectionInfoAnthroActivity.selectedChildrenMap;
import static edu.aku.ramshasaeed.tmk_midline19.core.MainApp.ac;*/

public class SectionAnthroBActivity extends AppCompatActivity {
    ActivitySectionAnthroBBinding bi;
    DatabaseHelper db;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_anthro_b);
        bi.setCallback(this);
        db = new DatabaseHelper(this);
        this.setTitle(getString(R.string.tsh));

        //Set Child Name
        /*bi.tsa00.setAdapter(new ArrayAdapter<>(this, android.R.layout.select_dialog_item, SectionInfoAnthroActivity.childrenName));

        bi.tsa00.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

        RadioGroup[] rdb = {bi.tsb03, bi.tsb07, bi.tsb11};
        for (RadioGroup radio : rdb) {
            for (int i = 0; i < radio.getChildCount(); i++) {
                if (radio.getChildAt(i) instanceof RadioButton)
                    radio.getChildAt(i).setEnabled(false);
            }
        }

        setListeners();

    }

    private void setListeners() {

        TextWatcher tsb01_02 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (bi.tsb01.getText().toString().isEmpty() || bi.tsb02.getText().toString().isEmpty())
                    return;
                float values = Math.abs(Float.valueOf(bi.tsb01.getText().toString()) - Float.valueOf(bi.tsb02.getText().toString()));
                bi.tsb03.clearCheck();
                bi.tsb03.check(values >= 0.6 ? bi.tsb03a.getId() : bi.tsb03b.getId());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        bi.tsb01.addTextChangedListener(tsb01_02);
        bi.tsb02.addTextChangedListener(tsb01_02);

        TextWatcher tsb05_06 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (bi.tsb05.getText().toString().isEmpty() || bi.tsb06.getText().toString().isEmpty())
                    return;
                float values = Math.abs(Float.valueOf(bi.tsb05.getText().toString()) - Float.valueOf(bi.tsb06.getText().toString()));
                bi.tsb07.clearCheck();
                bi.tsb07.check(values >= 0.1 ? bi.tsb07a.getId() : bi.tsb07b.getId());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        bi.tsb05.addTextChangedListener(tsb05_06);
        bi.tsb06.addTextChangedListener(tsb05_06);

        TextWatcher tsb09_10 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (bi.tsb09.getText().toString().isEmpty() || bi.tsb10.getText().toString().isEmpty())
                    return;
                float values = Math.abs(Float.valueOf(bi.tsb09.getText().toString()) - Float.valueOf(bi.tsb10.getText().toString()));
                bi.tsb11.clearCheck();
                bi.tsb11.check(values >= 1.3 ? bi.tsb11a.getId() : bi.tsb11b.getId());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        bi.tsb09.addTextChangedListener(tsb09_10);
        bi.tsb10.addTextChangedListener(tsb09_10);

    }

    private void SaveDraft() throws JSONException {

        /*ac = new AnthroContract();
        ac.setDevicetagID(getSharedPreferences("tagName", MODE_PRIVATE).getString("tagName", null));
        ac.setFormDate(dtToday);
        ac.setUser(MainApp.userName);
        ac.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));*/

        JSONObject sb = new JSONObject();

        /*sb.put("appver", MainApp.versionName + "." + MainApp.versionCode);
        sb.put("ta03", MainApp.talukaCode);
        sb.put("ta04", MainApp.ucCode);
        sb.put("ta04A", MainApp.areaCode);
        sb.put("cluster_no", MainApp.cluster);
        sb.put("hhno", MainApp.hhno);

        FamilyMembersContract fm = selectedChildrenMap.get(bi.tsa00.getSelectedItem().toString());

        ac.set_UUID(fm.get_UUID());*/

        /*sb.put("serial", fm.getserialNo());
        sb.put("mothername", fm.getMmname());
        sb.put("mother_id", fm.getmotherId());
        sb.put("FMUID", fm.get_UID());*/

        sb.put("tsa01", bi.tsa01a.isChecked() ? "1"
                : bi.tsa01b.isChecked() ? "2"
                : bi.tsa01c.isChecked() ? "3" : "0");
        sb.put("tsa02", bi.tsa02a.isChecked() ? "1"
                : bi.tsa02b.isChecked() ? "2"
                : bi.tsa02c.isChecked() ? "3" : "0");
        sb.put("tsa03", bi.tsa03a.isChecked() ? "1"
                : bi.tsa03b.isChecked() ? "2"
                : bi.tsa03c.isChecked() ? "3" : "0");
        sb.put("tsa04", bi.tsa04.getText().toString());
        sb.put("tsa0498", bi.tsa0498.isChecked() ? "98" : "0");

        sb.put("tsb01", bi.tsb01.getText().toString());
        sb.put("tsb02", bi.tsb02.getText().toString());
        sb.put("tsb03", bi.tsb03a.isChecked() ? "1"
                : bi.tsb03b.isChecked() ? "2" : "0");
        sb.put("tsb04", bi.tsb04.getText().toString());
        sb.put("tsb05", bi.tsb05.getText().toString());
        sb.put("tsb06", bi.tsb06.getText().toString());
        sb.put("tsb07", bi.tsb07a.isChecked() ? "1"
                : bi.tsb07b.isChecked() ? "2" : "0");
        sb.put("tsb08", bi.tsb08.getText().toString());
        sb.put("tsb09", bi.tsb09.getText().toString());
        sb.put("tsb10", bi.tsb10.getText().toString());
        sb.put("tsb11", bi.tsb11a.isChecked() ? "1"
                : bi.tsb11b.isChecked() ? "2" : "0");
        sb.put("tsb12", bi.tsb12.getText().toString());

        /*ac.setsI(String.valueOf(sb));


        selectedChildrenMap.remove(bi.tsa00.getSelectedItem().toString());
        childrenName.remove(position);*/

        MainApp.fc.setsG(String.valueOf(sb));

    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                finish();
//                startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", true));
                if (MainApp.TotalChildCount > 0) {
                    Intent secNext = new Intent(this, SectionEActivity.class);
                    startActivity(secNext);
                } else if (MainApp.totalImsCount > 0) {
                    Intent secNext = new Intent(this, SectionGActivity.class);
                    startActivity(secNext);
                } else {
                    Intent secNext = new Intent(this, EndingActivity.class).putExtra("complete", true);
                    startActivity(secNext);
                }
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        /*if (ValidatorClass02.EmptySpinner(this, bi.tsa00, getString(R.string.tsa00))) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, AnthroEndingActivity.class).putExtra("complete", false));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/


        MainApp.endActivity(this, this);

    }

    private boolean UpdateDB() {

        /*Long updcount = db.addAnthro(ac);
        MainApp.ac.set_ID(String.valueOf(updcount));

        if (updcount != 0) {

            MainApp.fc.set_UID(
                    (MainApp.fc.getdeviceid() + MainApp.fc.get_ID()));
            db.updateAnthroFormID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSG();

        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean formValidation() {
        return ValidatorClass02.EmptyCheckingContainer(this, bi.fldGrpSecE);
    }
}
