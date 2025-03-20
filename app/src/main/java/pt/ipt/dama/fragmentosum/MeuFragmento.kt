package pt.ipt.dama.fragmentosum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * texto a apresentar na TextView
 */
private const val ARG_TEXTO_TEXT_VIEW = ""

/**
 * texto a apresentar no Botão
 */
private const val ARG_TEXT_BOTAO = "param2"

/**
 * número do fragmento
 */
private const val ARG_FRAG_ID = "0"

/**
 * A simple [Fragment] subclass.
 * Use the [MeuFragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeuFragmento : Fragment() {
    // TO DO: Rename and change types of parameters
    /**
     * texto a mostrar na TextView do fragmento
     */
    private var txtTextView: String? = null

    /**
     * texto a mostrar no Botão do fragmento
     */
    private var txtBotao: String? = null

    /**
     * número do Fragmento para formatar o trabalho do botão do fragmento
     */
    private var numeroFragmento: Byte = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        // estamos a recuperar para dentro do método 'onCreate' da subclasse,
        //  o conteúdo do método 'onCreate' da superclasse,
        super.onCreate(savedInstanceState)
        // se houver conteúdo nos argumentos, são atribuídos aos atributos do fragmento
        arguments?.let {
            txtTextView = it.getString(ARG_TEXTO_TEXT_VIEW)
            txtBotao = it.getString(ARG_TEXT_BOTAO)
            numeroFragmento = it.getByte(ARG_FRAG_ID)
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

        // adicionar 'alguma' ação ao botão
        // esta acção será mostrar um 'popup' com um texto
        aux_Button.setOnClickListener {
            // se o número associado ao Fragmento for par, mostrar um objeto de popup diferente
            if (numeroFragmento % 2 == 0) {
                // fragmento é par
                // vamos usar o SnackBar para mostrar a mensagem
                Snackbar.make(view, getString(R.string.txtToast,txtBotao), Snackbar.LENGTH_LONG).show()
            } else {
                // é ímpar
                Toast.makeText(this.context,  getString(R.string.txtToast,txtBotao), Toast.LENGTH_LONG).show()
            }
        }
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
         * @param numFrag número associado ao fragmento
         * @return uma nova realização do fragmento MeuFragmento.
         */
        // TO DO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(txtLabel: String, txtBotao: String, numFrag: Byte) =
            MeuFragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXTO_TEXT_VIEW, txtLabel)
                    putString(ARG_TEXT_BOTAO, txtBotao)
                    putByte(ARG_FRAG_ID, numFrag)
                }
            }
    }
}