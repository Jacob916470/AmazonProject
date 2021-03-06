package com.jacob.amazonproject.presentation.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.analytics.FirebaseAnalytics
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.local.database.CursoRoomDataBase
import com.jacob.amazonproject.databinding.FragmentSignUpBinding
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack
import com.jacob.amazonproject.presentation.signup.viewModel.SignUpViewModel
import com.jacob.amazonproject.presentation.signup.viewModel.SignUpViewModelFactory

/** Heredamos de View.OnClickListener la cual nos atraera la vista y nos generara nustros clicks
 * (implementamos los metodos solicitados(onClick))
 * */

/** Heredamos interface ResultCallBack con su tipo de variable "String", y se implementan sus metodos */
class SignUpFragment : Fragment(), View.OnClickListener, ResultCallBack<String> {

    private var fragmentSignUpBinding: FragmentSignUpBinding? = null
    lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sign_up,
            container,
            false
        )
        fragmentSignUpBinding?.signUpViewModel =
            ViewModelProvider(
                this,
                SignUpViewModelFactory(
                    cursoRoomDataBase = CursoRoomDataBase.getDataBase(requireContext()),
                    /** Colocamos "this" en onCreateView para indicarle que las acciones de la
                     * interfaz ResultCallBack ser??n usadas en el mismo */
                    this
                )
            ).get(SignUpViewModel::class.java)

        sendEvent()

        return fragmentSignUpBinding?.root
    }


    private fun sendEvent() {
        val bundle: Bundle = Bundle()
        bundle.putString("screen","SignUp")
        firebaseAnalytics.logEvent("SIGNUP",bundle)
    }

    /** Creamos onViewCreated para confirmar que la vista ya esta creada*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /** Implementamos nuestros setOnClickListener para poder utilizarlos en la funcion onClick*/
        fragmentSignUpBinding?.btnSaveSign?.setOnClickListener(this)
        fragmentSignUpBinding?.btnCancelar?.setOnClickListener(this)
    }

    /** Creamos funci??n privada saveUser, verificamos que nuestra vista no
     * este vacia con nuestra variable "fragmentSignUpBinding?", posteriomente ingresamos "signUpViewModel"
     * para atraer la funci??n saveUser y poderla aplicar en la acci??n del bot??n*/
    private fun saveUser() {
        fragmentSignUpBinding?.signUpViewModel?.saveUser()
    }

    /** Creamos funci??n dissmiss para regresar al fragment anterior "Login"*/
    private fun dismiss() {
        /** Se genera la sentencia findNavController().navigateUp() la cual nos regresa una vista anterior */
        findNavController().navigateUp()
    }

    /** Se crea implementaci??n al heredar de View.OnClickListener */
    override fun onClick(view: View?) {
        /** Creamos un "when" para atraer la vista acorde con su id de cada objeto que se encuentre en la vista*/
        when (view?.id) {
            R.id.btnSaveSign -> {
                saveUser()
            }
            R.id.btnCancelar -> {
                /** Mandamos a llamar a la funci??n dissmiss para que si hub?? una proceso exitoso
                 * nos mande directo a la vista login */
                dismiss()
            }
        }
    }

    /** Se crean implementaciones de la interfaz ResultCallBack*/
    override fun onSuccess(type: String) {
        Toast.makeText(requireContext(), "Ahora puedes iniciar, $type", Toast.LENGTH_SHORT).show()
        /** Mandamos a llamar a la funci??n dissmiss para que si hub?? una proceso exitoso
         * nos mande directo a la vista login */
        dismiss()
        sendEventTwo(type)

    }

    private fun sendEventTwo(name:String) {
        val bundle: Bundle = Bundle()
        bundle.putString("click","Saving")
        bundle.putString("new_user",name)
        firebaseAnalytics.logEvent("CLICK",bundle)
    }

    override fun onError(message: String, type: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}