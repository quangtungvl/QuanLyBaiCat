package com.bbisno.quanlybaicat.ultils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MyPC on 11/03/2016.
 */
public class Untils {
    public static boolean checkEditTextInput(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            return false;
        } else return true;
    }
}
