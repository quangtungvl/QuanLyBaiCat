package com.bbisno.quanlybaicat.ultils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by MyPC on 11/03/2016.
 */
public class Untils {
    public static boolean checkEditTextInput(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) {
            return false;
        } else return true;
    }
    //Method xóa xe, kiểm tra xe có chủ hay ko, có thì xóa lun chuxe->xesohuu->soxe
    public static void delXe(String pathRefXe){

        Firebase delXe = new Firebase(pathRefXe);
        delXe.removeValue();

    }
    public static void delXeSoHuu(String pathRefXeSoHuu){

        Firebase delXe = new Firebase(pathRefXeSoHuu);
        delXe.removeValue();

    }


}
