package com.yquery.gdsccontacts.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yquery.gdsccontacts.R
import com.yquery.gdsccontacts.activities.AddEditActivity
import com.yquery.gdsccontacts.database.ContactEntity

class ContactsAdapter(context: Context): RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {

    private val ctx = context
    private var contactsList = emptyList<ContactEntity>()

    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        var contactNameTextview : TextView = itemView.findViewById(R.id.contact_name_textview)
        var contactNumberTextview : TextView = itemView.findViewById(R.id.contact_number_textview)
        var callButton : ImageView = itemView.findViewById(R.id.call_button)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = contactsList[position]

        holder.contactNameTextview.text = currentItem.contactName
        holder.contactNumberTextview.text = currentItem.contactNumber

        holder.itemView.setOnClickListener{
            val intent = Intent(ctx, AddEditActivity::class.java)

            intent.putExtra("id", currentItem.contactID)
            intent.putExtra("name", currentItem.contactName)
            intent.putExtra("number", currentItem.contactNumber)

            ctx.startActivity(intent)
        }

        holder.callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${currentItem.contactNumber}")

            ctx.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun setData(contacts_list : MutableList<ContactEntity>){
        this.contactsList = contacts_list
        notifyDataSetChanged()
    }

}