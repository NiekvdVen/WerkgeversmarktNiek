package com.niekvdven.android.werkgeversmarktniekv7;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    private String text;
    private boolean isSelected = false;

    // Constructor
    public Model(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    // Creator interface
    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        public Model[] newArray(int size) {
            return new Model[size];
        }

    };

    // Parcelling part
    public Model(Parcel in) {
        super();
        this.text = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
    }

    @Override
    public String toString() {
        return ("Item: " + this.getText());
    }
}
