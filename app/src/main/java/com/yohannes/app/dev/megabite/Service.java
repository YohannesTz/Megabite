package com.yohannes.app.dev.megabite;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Yohannes on 02-Mar-20.
 */

public class Service implements Serializable {
    private String eng_name;
    private String amh_name;
    private String[] service_detail;
    private String ussdCode;
    private boolean openActivity;

    public Service(String eng_name, String amh_name, String ussdCode, boolean openActivity) {
        this.eng_name = eng_name;
        this.amh_name = amh_name;
        this.ussdCode = ussdCode;
        this.openActivity = openActivity;
    }

    public Service(String eng_name, String amh_name, String[] service_detail) {
        this.eng_name = eng_name;
        this.amh_name = amh_name;
        this.service_detail = service_detail;
    }

    public String getEng_name() {
        return eng_name;
    }

    public void setEng_name(String eng_name) {
        this.eng_name = eng_name;
    }

    public String getAmh_name() {
        return amh_name;
    }

    public void setAmh_name(String amh_name) {
        this.amh_name = amh_name;
    }

    public String[] getService_detail() {
        return service_detail;
    }

    public void setService_detail(String[] service_detail) {
        this.service_detail = service_detail;
    }

    public String getUssdCode() {
        return ussdCode;
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode = ussdCode;
    }

    public boolean isOpenActivity() {
        return openActivity;
    }

    public void setOpenActivity(boolean openActivity) {
        this.openActivity = openActivity;
    }
}
