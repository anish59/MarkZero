package anish59.markzero.utilPack;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by anish on 06-04-2017.
 */

public class CustomGridItemDivider extends RecyclerView.ItemDecoration {
    private String colorCode = "#FFFFFF";
    private int padding = 0;

    public CustomGridItemDivider(String colorCode, int padding) {
        this.colorCode = colorCode;
        this.padding = padding;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {


        int childCount = parent.getChildCount();
        int lastChild;
        if ((childCount % 2) == 0) {
            lastChild = childCount - 2;
        } else {
            lastChild = childCount - 1;
        }


        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            child.setBackgroundColor(Color.parseColor(colorCode));
            int pos = i + 1;
            if ((pos % 2) == 0) {
                if (pos > lastChild) {
                    child.setPadding(0, 0, 0, 0);
                } else {
                    child.setPadding(0, 0, 0, padding);
                }
            } else {
                if (pos > lastChild) {
                    child.setPadding(0, 0, padding, 0);
                } else {
                    child.setPadding(0, 0, padding, padding);
                }
            }
        }
    }
}