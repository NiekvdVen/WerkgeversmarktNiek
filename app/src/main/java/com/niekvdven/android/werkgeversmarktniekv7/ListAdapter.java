package com.niekvdven.android.werkgeversmarktniekv7;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.niekvdven.android.werkgeversmarktniekv7.TabParticiperendeWerkgevers;

/**
 * Adapter class for recyclerview.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Model> mModelList;
    private static String pdfFileName = "";
    private boolean multiSelect = false;
    private ArrayList<Model> selectedItems = new ArrayList<>();
    public ArrayList<Model> participerend;

    // Constructor
    public ListAdapter(ArrayList<Model> modelList) {
        mModelList = modelList;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.update(mModelList.get(position));
    }

    /**
     * ActionMode.
     */
    private ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            multiSelect = true;
            menu.add("+ Toevoegen aan participerend");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            ArrayList<String> duplicates = new ArrayList<>();
            participerend = new ArrayList<Model>();
            for (Model model : selectedItems) {
                if (participerend.contains(model)) {
                    duplicates.add(model.getText());
                } else {
                    participerend.add(model);
                }
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("key", participerend);

//
//            String str = "";
//            for (String value : duplicates) {
//                str += value + ", ";
//            }
//            Toast.makeText(view.getContext(), str, Toast.LENGTH_LONG).show();

//            String toegevoegd = "De selectie is toegevoegd aan de tab Participerend.";
//            Toast.makeText(view.getContext(), toegevoegd, Toast.LENGTH_SHORT).show();

            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            multiSelect = false;
            selectedItems.clear();
            notifyDataSetChanged();
        }
    };

    @Override
    public int getItemCount() {
        return mModelList == null ? 0 : mModelList.size();
    }

    /**
     * Inner class for ViewHolder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        FrameLayout frameLayout;

        // Constructor
        public ViewHolder(View itemView) {
            super(itemView);
            frameLayout = (FrameLayout)itemView.findViewById(R.id.frameLayout);
            textView = (TextView) itemView.findViewById(R.id.company_name);
        }

        void selectItem(Model value, View view) {
            if (multiSelect) {
                if (selectedItems.contains(value)) {
                    selectedItems.remove(value);
                    frameLayout.setBackgroundColor(Color.WHITE);
                } else {
                    selectedItems.add(value);
                    frameLayout.setBackgroundColor(Color.LTGRAY);
                }
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, PdfRenderActivity.class);
                context.startActivity(intent);
            }
        }

        void update(final Model value) {
            textView.setText(value.getText());
            if (selectedItems.contains(value)) {
                frameLayout.setBackgroundColor(Color.LTGRAY);
            } else {
                frameLayout.setBackgroundColor(Color.WHITE);
            }
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    ((AppCompatActivity)view.getContext()).startActionMode(actionModeCallbacks);
                    selectItem(value, view);

                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectItem(value, view);

                    pdfFileName = value.getText() + ".pdf";
                }
            });
        }
    }

    public static String getVariable() {
        return pdfFileName;
    }
}
