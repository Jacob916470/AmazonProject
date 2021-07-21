package com.jacob.amazonproject.presentation.signup.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jacob.amazonproject.R
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.databinding.FragmentSignUpBinding
import com.jacob.amazonproject.presentation.signup.viewModel.SignUpViewModel
import com.jacob.amazonproject.presentation.signup.viewModel.SignUpViewModelFactory

class SignUpFragment: Fragment(){

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
                    cursoRoomDataBase = CursoRoomDataBase.getDataBase(requireContext())
                )
            ).get(SignUpViewModel::class.java)

        return fragmentSignUpBinding?.root
    }
}