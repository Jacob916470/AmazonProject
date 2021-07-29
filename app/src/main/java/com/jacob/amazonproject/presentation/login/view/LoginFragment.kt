package com.jacob.amazonproject.presentation.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.data.entities.User
import com.jacob.amazonproject.databinding.FragmentLoginBinding
import com.jacob.amazonproject.presentation.core.callBack.ResultCallBack
import com.jacob.amazonproject.presentation.login.viewModel.LoginViewModel
import com.jacob.amazonproject.presentation.login.viewModel.LoginViewModelFactory

/** Una vez que inicien sesión, tenga 10% */
class LoginFragment: Fragment(), ResultCallBack<User> {

    private var fragmentLoginBinding: FragmentLoginBinding? = null

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
        fragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        fragmentLoginBinding?.loginViewModel =
            ViewModelProvider(
                this,
                LoginViewModelFactory(
                    cursoRoomDataBase = CursoRoomDataBase.getDataBase(requireContext()),
                    resultCallBack = this
                )
            ).get(LoginViewModel::class.java)

        return fragmentLoginBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding?.btnSignUp?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        fragmentLoginBinding?.btnLogin
    }

    override fun onSuccess(type: User) {
        Toast.makeText(requireContext(), "Bienvenido ${type.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String, type: User?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}