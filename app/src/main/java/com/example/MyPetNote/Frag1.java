package com.example.MyPetNote;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.MyPetNote.Viewer.VideoViewer;
import com.example.MyPetNote.Viewer.VideoViewer2;
import com.example.MyPetNote.Viewer.VideoViewer3;

public class Frag1 extends Fragment {

    private View view;
    private Button video1, video2, video3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        video1 = view.findViewById(R.id.video1);
        video2 = view.findViewById(R.id.video2);
        video3 = view.findViewById(R.id.video3);

        video1.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), VideoViewer.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });
        video2.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), VideoViewer2.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });
        video3.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), VideoViewer3.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        });

        return view;
    }
}
