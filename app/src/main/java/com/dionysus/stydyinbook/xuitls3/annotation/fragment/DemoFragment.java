package com.dionysus.stydyinbook.xuitls3.annotation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dionysus.stydyinbook.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * @className: DemoFragment
 * @author: Dionysus
 * @date: 2019/5/23 1:01
 * @Description: DemoFragment
 */
@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment {

    @ViewInject(R.id.btn_fragment)
    private Button mbtnFragment;
    @ViewInject(R.id.txt_text)
    private TextView mtxtText;
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mbtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, getString(R.string.xutils3_click_is_worked), Toast.LENGTH_SHORT).show();
            }
        });

        mtxtText.setText(getString(R.string.xutils3_text_is_already_init));
    }
}

