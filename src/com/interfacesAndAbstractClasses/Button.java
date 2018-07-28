package com.interfacesAndAbstractClasses;

public class Button {

    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        this.onClickListener.onClick(title);
    }

    // this is the interface the local class ClickListener implements
    public interface OnClickListener {
        void onClick(String title);
    }
}
