package fr.isen.martin.androiderestaurant


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class DishAdapter(private val mList: List<DishModel>, val onDishClicked: (DishModel) -> Unit) : RecyclerView.Adapter<DishAdapter.ViewHolder>() {


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val dishName: TextView = itemView.findViewById(R.id.cellBasketName)
        val dishPicture:  ImageView = itemView.findViewById(R.id.cellImageBasket)
        val dishPrice: TextView = itemView.findViewById(R.id.cellBasketPrice)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dishModel = mList[position]

        holder.dishName.text = dishModel.name_fr

        Picasso.get()
            .load(mList[position].getFirstPicture())
            .error(R.drawable.noimages)
            .placeholder(R.drawable.noimages)
            .into(holder.dishPicture)
        
        holder.dishPrice.text = dishModel.getFormattedPrice()

        holder.itemView.setOnClickListener {
            onDishClicked(dishModel)
        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}

