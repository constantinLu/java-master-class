package MasterClass.InnerClasses;

/**
 * Created by LunguC on 18.08.2017.
 */
public class Button {
    private String title;
    private OnClickListener onClickListener;


    //constructor

    public Button(String title) {
        this.title = title;
    }

    //getter

    public String getTitle() {
        return title;
    }

    //set the onclicklistener

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        this.onClickListener.onClick(this.title);
    }

    public interface OnClickListener {
        void onClick(String title);
    }
}

