package com.yogiw.konten.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

import com.yogiw.konten.R
import kotlinx.android.synthetic.main.fragment_jadwal.*
import kotlinx.android.synthetic.main.fragment_jadwal.view.*
import java.util.*
import kotlin.collections.HashMap




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class JadwalFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_jadwal, container, false)

        val adapterHari = ArrayAdapter.createFromResource(view.context,
                R.array.spinner_hari, android.R.layout.simple_spinner_item)

        view.spnHari.adapter = adapterHari

        val adapterShift = ArrayAdapter.createFromResource(view.context,
                R.array.spinner_shift, android.R.layout.simple_spinner_item)

        view.spnShift.adapter = adapterShift

        view.btnSimpanJadwal.setOnClickListener {
            val db: FirebaseFirestore = FirebaseFirestore.getInstance()


            val jadwalMap: HashMap<String, String> = HashMap()
            jadwalMap.put("matkul", edtNamaMatkul.text.toString())
            jadwalMap.put("hari", spnHari.selectedItem.toString())
            jadwalMap.put("shift", spnShift.selectedItem.toString())

            db.collection("jadwal")
                    .add(jadwalMap as Map<String, Any>)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "Input sukses", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(activity, "Input gagal", Toast.LENGTH_SHORT).show()
                    }
        }

        return view
    }


}
