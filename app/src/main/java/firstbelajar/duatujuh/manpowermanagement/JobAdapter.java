package firstbelajar.duatujuh.manpowermanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyJob> myJob;

    public JobAdapter(Context c, ArrayList<MyJob> p){
        context = c;
        myJob = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.
                from(context).inflate(R.layout.item_myjob, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.xnama_tour.setText(myJob.get(i).getNama_tour());
        myViewHolder.xtour_location.setText(myJob.get(i).getTour_location());

        final String getNamaTour = myJob.get(i).getNama_tour();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojobdetailsnext = new Intent(context, JobDetailsNextAct.class);
                gotojobdetailsnext.putExtra("nama_tour", getNamaTour);
                context.startActivities(new Intent[]{gotojobdetailsnext});

            }
        });


    }

    @Override
    public int getItemCount() {
        return myJob.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView xnama_tour, xtour_location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            xnama_tour = itemView.findViewById(R.id.xnama_tour);
            xtour_location = itemView.findViewById(R.id.xtour_location);

        }
    }
}
