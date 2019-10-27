package com.example.kkbox.ui.notifications;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.kkbox.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().getFragmentManager().popBackStack();
        final Button cha = (Button) getView().findViewById(R.id.change);
        final Button acc = (Button) getView().findViewById(R.id.accept);
        final ImageView peo1 = (ImageView) getView().findViewById(R.id.people1);
        final ImageView peo2 = (ImageView) getView().findViewById(R.id.people2);
        final ImageView peo3 = (ImageView) getView().findViewById(R.id.people3);
        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(peo1.getVisibility() ==View.VISIBLE){
                    peo1.setVisibility(View.INVISIBLE);
                    peo2.setVisibility(View.VISIBLE);
                }
                else if(peo2.getVisibility() ==View.VISIBLE){
                    peo2.setVisibility(View.INVISIBLE);
                    peo3.setVisibility(View.VISIBLE);
                }
                else if(peo3.getVisibility() ==View.VISIBLE){
                    peo3.setVisibility(View.INVISIBLE);
                    peo1.setVisibility(View.VISIBLE);
                }
            }
        });

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sent friend request!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}