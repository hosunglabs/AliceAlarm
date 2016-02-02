package creativestudioaq.alarmapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by honggyu on 2016-01-31.
 */
public class MainFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);


        Button settingbutton = (Button)view.findViewById(R.id.settingbutton);
        Button alarmbutton = (Button)view.findViewById(R.id.alarmbutton);
        settingbutton.setOnClickListener(this);
        alarmbutton.setOnClickListener(this);

        ImageView icon = new ImageView(getActivity());
        icon.setImageResource(R.drawable.alarmbutton);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(getActivity())
                .setContentView(icon)
                .setPosition(5)
                .build();

        Log.v("dd", "" + actionButton);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(getActivity());
        // repeat many times:
        ImageView itemIcon1 = new ImageView(getActivity());
        itemIcon1.setImageResource(R.drawable.alarmbutton);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();

        ImageView itemIcon2 = new ImageView(getActivity());
        itemIcon2.setImageResource(R.drawable.alarmbutton);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(getActivity())
                .addSubActionView(button1)
                .addSubActionView(button2)
                .attachTo(actionButton)
                .build();


        return view;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.settingbutton:
                ((MainActivity)getActivity()).getViewPager().setCurrentItem(0);
                break;
            case R.id.alarmbutton:
                ((MainActivity)getActivity()).getViewPager().setCurrentItem(2);
                break;

        }

    }
}
