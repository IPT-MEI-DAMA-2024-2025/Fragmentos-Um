package pt.ipt.dama.fragmentosum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TEXTO_TEXT_VIEW = ""
private const val ARG_TEXT_BOTAO = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MeuFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeuFragmento : Fragment() {
    // TODO: Rename and change types of parameters
    /**
     * texto a mostrar na TextView do fragmento
     */
    private var txtTextView: String? = null

    /**
     * texto a mostrar no Botão do fragmento
     */
    private var txtBotao: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        // estamos a recuperar para dentro do método 'onCreate' da subclasse,
        //  o conteúdo do método 'onCreate' da superclasse,
        super.onCreate(savedInstanceState)
        // se houver conteúdo nos argumentos, são atribuídos aos atributos do fragmento
        arguments?.let {
            txtTextView = it.getString(ARG_TEXTO_TEXT_VIEW)
            txtBotao = it.getString(ARG_TEXT_BOTAO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_meu_fragmento, container, false)

        // injetar na TextView do fragmento o texto que quero que ela mostre
        val aux_TextView: TextView = view.findViewById(R.id.txtFragmento)
        aux_TextView.text = txtTextView

        // injetar no Botão o texto que ele deve mostrar
        val aux_Button = view.findViewById<Button>(R.id.btFragmento)
        aux_Button.text = txtBotao

        return view
    }





    // https://kotlinlang.org/docs/object-declarations.html
    // https://medium.com/@appdevinsights/companion-object-in-kotlin-c3a1203cd63c
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param txtLabel texto a apresentar na TextView do fragmento
         * @param txtBotao texto a apresentar no Botão do fragmento
         * @return uma nova realização do fragmento MeuFragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(txtLabel: String, txtBotao: String) =
            MeuFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXTO_TEXT_VIEW, txtLabel)
                    putString(ARG_TEXT_BOTAO, txtBotao)
                }
            }
    }
}