package pt.ipt.dama.fragmentosum

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var f1: MeuFragmento
    lateinit var f2: MeuFragmento
    lateinit var f3: MeuFragmento


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // instanciar os fragmento
        f1 = MeuFragmento.newInstance(getString(R.string.txtFrag1), getString(R.string.btFrag1),1)
        f2 = MeuFragmento.newInstance(getString(R.string.txtFrag2), getString(R.string.btFrag2),2)
        f3 = MeuFragmento.newInstance(getString(R.string.txtFrag3), getString(R.string.btFrag3),3)

        // injetar estes três fragmentos na minha interface
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmento1, f1)
        fragmentTransaction.add(R.id.fragmento2, f2)
        fragmentTransaction.add(R.id.fragmento3, f3)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}