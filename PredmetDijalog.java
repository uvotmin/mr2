package com.example.marksapprecord2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.marksapprecord2.utils.MyAppUtils;

public class PredmetDijalog extends DialogFragment {

    public static final String AKCIJA_DIJALOGA = "Akcija Dijaloga";
    public static final String DODAJ_OCENU = "Dodaj Ocenu";
    public static final String OBRISI_OCENU = "Obrisi Ocenu";
    public static final String OBRISI_PREDMET = "Obrisi Predmet";
    public static final String DODAJ_PREDMET = "Dodaj Predmet";

    public PredmetDijalog(MyAppUtils.onClickListenerOpcijePredmeta listenerOpcijePredmeta){
        this.listenerOpcijePredmeta = listenerOpcijePredmeta;
    }

    private MyAppUtils.onClickListenerOpcijePredmeta listenerOpcijePredmeta;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String akcija = args.getString(PredmetDijalog.AKCIJA_DIJALOGA);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        Dialog dijalog;
        switch (akcija){
            case DODAJ_OCENU:{
                builder.setTitle("Odaberi ocenu:");
                builder.setView(R.layout.dialog_dodaj_ocenu);
                builder.setPositiveButton("Potvrdi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Dialog dialog = (Dialog) dialogInterface;
                        RadioGroup radioGroup = dialog.findViewById(R.id.radioGroupDijalog);
                        RadioButton radioButton = dialog.findViewById(radioGroup.getCheckedRadioButtonId());
                    }
                })
            }
        }
        return super.onCreateDialog(savedInstanceState);
    }
}
