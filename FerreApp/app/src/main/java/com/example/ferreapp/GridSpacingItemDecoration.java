package com.example.ferreapp;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{
    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int coloum = position % spanCount;

        if (includeEdge){
            outRect.left =spacing - coloum + spacing / spanCount;
            outRect.right = (coloum + 1) + spacing / spanCount;
            if(position < spanCount){
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        }
        else{
            outRect.left = coloum * spacing / spanCount;
            outRect.right = spacing - (coloum + 1) * spacing / spanCount;
            if (position >= spanCount){
                outRect.top = spacing;
            }
        }
    }
}
