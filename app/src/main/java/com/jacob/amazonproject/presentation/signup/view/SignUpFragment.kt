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
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.databinding.FragmentSignUpBinding
import com.jacob.amazonproject.presentation.core.callBack.ResultCallback
import com.jacob.amazonproject.presentation.signup.viewModel.SignUpViewModel
import com.jacob.amazonproject.presentation.signup.viewModel.SignUpViewModelFactory

class SignUpFragment: Fragment(), View.OnClickListener, ResultCallback<String> {

    private var fragmentSignUpBinding: FragmentSignUpBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
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
                    this
                )
            ).get(SignUpViewModel::class.java)

        return fragmentSignUpBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignUpBinding?.btnSaveSign?.setOnClickListener(this)
        fragmentSignUpBinding?.btnCancelar?.setOnClickListener(this)

    }

    private fun saveUser() {
        fragmentSignUpBinding?.signUpViewModel?.saveUser()
    }

    private fun dismiss() {
        findNavController().navigateUp()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnSaveSign -> {
                saveUser()
            }
            R.id.btnCancelar -> {
                dismiss()
            }

        }
    }

    override fun onSuccess(type: String) {
        Toast.makeText(requireContext(), "Ahora puedes iniciar, $type", Toast.LENGTH_LONG).show()
        dismiss()
    }

    override fun onError(message: String, type: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}