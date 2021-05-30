package com.monir.bottomsheetbehavior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    private TextView textViewState;
    private Button buttonExpand;
    private Button buttonCollapse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bottomSheet = findViewById(R.id.bottom_sheet);
        textViewState = findViewById(R.id.text_view_state);
        buttonExpand = findViewById(R.id.button_expand);
        buttonCollapse = findViewById(R.id.button_collapse);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        buttonExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        buttonCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull @org.jetbrains.annotations.NotNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                    textViewState.setText("Expanded");
                    break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        textViewState.setText("Half Expanded");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        textViewState.setText("Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        textViewState.setText("Dragging...");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        textViewState.setText("Settling");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        textViewState.setText("Hidden");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull @org.jetbrains.annotations.NotNull View bottomSheet, float slideOffset) {
                  textViewState.setText("Sliding..");
            }
        });
    }
}