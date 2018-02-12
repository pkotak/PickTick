package com.app.limitless4.picktick.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.app.limitless4.picktick.CardAdapter;
import com.app.limitless4.picktick.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class YouFragment extends Fragment {

    public YouFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.expandButton)
    ImageButton mExpandButton;

    @BindView(R.id.expandableLayout)
    ExpandableRelativeLayout mExpandLayout;

    private boolean expanded = false;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_you, container, false);
        ButterKnife.bind(this, view);
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CardAdapter();
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @OnClick(R.id.expandButton)
    void toggle()
    {
        if (expanded == false)
        {
            mExpandLayout.toggle();
            mExpandButton.setImageResource(R.drawable.up_arrow);
            expanded = true;
        }
        else
        {
            mExpandLayout.toggle();
            mExpandButton.setImageResource(R.drawable.down_arrow);
            expanded = false;
        }

    }

}
