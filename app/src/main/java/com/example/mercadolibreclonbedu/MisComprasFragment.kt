package com.example.mercadolibreclonbedu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_mis_compras.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MisComprasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MisComprasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var rv: RecyclerView
    private lateinit var binding: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflater.inflate(R.layout.fragment_mis_compras, container, false)
        initRecycler()
        return binding
    }

    fun initRecycler(){
        rv = binding.findViewById(R.id.rv_mis_compras)
        val adapter = MisComprasAdapter(miscompraslist)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    val miscompraslist = listOf(
        MisComprasEntity("Entregado", "Bote de leche", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpdtfsQ2NqHJzyh3TnILmZroF_yWl6Z6eih4hOTGsEDCjt_yDu0OPATfZX7SFj53MLVJ2fx2vf&usqp=CAc"),
        MisComprasEntity("No Entregado", "Playera", "https://martimx.vteximg.com.br/arquivos/ids/578134-275-275/1127881945-1.png?v=637540298888830000"),
        MisComprasEntity("Entregado", "Xbox", "https://ss423.liverpool.com.mx/xl/1100132300.jpg"),
        MisComprasEntity("No Entregado", "Guitarra", "https://media.fanaticguitars.com/2021/01/la-mejor-guitarra-espanola-para-empezar-a-tocar.jpg"),
        MisComprasEntity("No Entregado", "Tennis", "https://i.pinimg.com/originals/26/1b/34/261b34e7304e9e3d2e224e8461c8c25d.jpg"),
        MisComprasEntity("Entregado", "Computadora", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJPySDOMVvb57akdklq5DwhNcCVCJ2Sh2J2Q&usqp=CAU"),
        MisComprasEntity("Entregado", "Pelicula Spiderman", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"),
        MisComprasEntity("Entregado", "Celular", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQOKVoPBYB94pzzRg_hgpaQedib_aIFEHbzw&usqp=CAU")
    )

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MisComprasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MisComprasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}