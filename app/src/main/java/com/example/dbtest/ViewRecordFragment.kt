package com.example.dbtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.dbtest.Database.Student
import kotlinx.android.synthetic.main.fragment_view_record.*

/**
 * A simple [Fragment] subclass.
 */
class ViewRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_view_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        btnGet.setOnClickListener(){
            val arrayList = ArrayList<String>()
            val adapter = ArrayAdapter(context!!, android.R.layout.simple_list_item_1, arrayList)

            txtResult.adapter = adapter

            try {
                //display from database by getAll() method
                val sList: List<Student> = MainActivity.appDB.studentDao().getAll()

                var name:String = ""

                //for earch
                for (s in sList) {
                    //  name = name + s.studentid + " " + s.studentName + "\n"
                    adapter.add(s.studentName + "(" + s.studentid + ")")

                }

               // txtResult.setText(name)
            }catch (ex:Exception){
                Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
            }

        }
    }
}
