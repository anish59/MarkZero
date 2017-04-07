package anish59.markzero.utilPack;


import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Ishan on 06-04-2017.
 */

public class GridItemDecoratorV2 extends RecyclerView.ItemDecoration {
    private int padding = 0;
    private Drawable mDivider;

    /**
     * you need to keep a line_divider of your own which is in drawable for you to pass in the constructor
     *
     * @param padding
     * @param drawable
     */
    public GridItemDecoratorV2(int padding, Drawable drawable) {
        this.padding = padding;
        this.mDivider = drawable;
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
            //            child.setBackgroundColor(Color.parseColor(colorCode));


            int dividerLeft = parent.getPaddingLeft();
            int dividerRight = child.getWidth();
            int dividerTop = child.getBottom();
            int dividerBottom = dividerTop + padding;
            Log.e("bounds", dividerLeft + " " + dividerTop + " " + dividerRight + " " + dividerBottom + " ");


            int pos = i + 1;
            if ((pos % 2) == 0) {
                if (pos > lastChild) {
                } else {
                }
            } else {
                if (pos > lastChild) {

                    mDivider.setBounds(dividerRight, child.getTop(), dividerRight + padding, dividerBottom - padding);//this will draw line right of the view
                    mDivider.draw(c);
                } else {

                    mDivider.setBounds(dividerLeft, dividerTop, parent.getWidth(), dividerBottom);// this will draw line below view
                    mDivider.draw(c);

                    mDivider.setBounds(dividerRight, child.getTop(), dividerRight + padding, dividerBottom);//this will draw line right of the view
                    mDivider.draw(c);

                }
            }

        }
    }
}