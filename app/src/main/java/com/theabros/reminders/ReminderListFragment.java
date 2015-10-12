package com.theabros.reminders;

import android.app.Fragment;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

/**
 * Created by gadgetroid on 12/10/15.
 */
public class ReminderListFragment extends Fragment {
    ListView reminderList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reminders_view, container, false);
        reminderList = (ListView)view.findViewById(R.id.ReminderListFragmentListView);
        FloatingActionButton floatingActionButton = (FloatingActionButton)view.findViewById(R.id.fab);
        floatingActionButton.attachToListView(reminderList);
        getActivity().getActionBar().setTitle("Reminders");
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);
        Transition exitTransition = new Slide(Gravity.LEFT);
        setExitTransition(exitTransition);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewReminderFragment newReminderFragment = new NewReminderFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.RemindersActivityFragmentContainer, newReminderFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
