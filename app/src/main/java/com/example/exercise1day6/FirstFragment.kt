package com.example.exercise1day6

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.exercise1day6.databinding.ActivityMainBinding
import com.example.exercise1day6.databinding.FragmentFirstBinding
import java.util.prefs.Preferences
import android.content.SharedPreferences as SharedPreferences1

//constante para nombre de archivo
private const val nameSharePreferences= "com.example.exercise1day6"
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    //crear variable para referenciar shared preference
    private lateinit var sharedPreferences: SharedPreferences1
    val clave1 = "clave1"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        //Inicializar shared Preferences
       sharedPreferences= requireActivity().getSharedPreferences(nameSharePreferences,Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            save()
        }
        val recuperado1 = sharedPreferences.getInt(clave1,0)
        binding.textView1.setText(getString(R.string.entero, recuperado1.toString()))
        binding.btnDelete.setOnClickListener {
            delete()
        }
    }
    fun save(){
        val text1 = binding.editText1.text.toString().toInt()
        sharedPreferences.edit().putInt(clave1, text1).apply()
        binding.textView1.setText(getString(R.string.entero, text1.toString()))
    }
    fun delete(){
        binding.textView1.setText(getString(R.string.entero, "0"))
        sharedPreferences.edit().remove(clave1).apply()
    }
}