package com.example.kkbox.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kkbox.MainActivity;
import com.example.kkbox.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().getFragmentManager().popBackStack();
        Button btn = (Button) getView().findViewById(R.id.btn1);
        final LinearLayout layout = (LinearLayout) getView().findViewById(R.id.rootLayout);
                Button newbtn = new Button(getContext());
                newbtn.setBackgroundResource(R.drawable.user2);
                layout.addView(newbtn);
        newbtn = new Button(getContext());
                newbtn.setBackgroundResource(R.drawable.user3);
                layout.addView(newbtn);
        newbtn = new Button(getContext());
                newbtn.setBackgroundResource(R.drawable.user4);
                layout.addView(newbtn);
        newbtn = new Button(getContext());
                newbtn.setBackgroundResource(R.drawable.user5);
                layout.addView(newbtn);
        newbtn = new Button(getContext());
                newbtn.setBackgroundResource(R.drawable.user6);
                layout.addView(newbtn);
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}