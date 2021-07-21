package com.jacob.amazonproject.presentation.signup.viewModel

import androidx.lifecycle.ViewModel
import com.jacob.amazonproject.data.database.CursoRoomDataBase
import com.jacob.amazonproject.data.entities.User
import com.jacob.amazonproject.data.repositories.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val cursoRoomDataBase: CursoRoomDataBase
): ViewModel() {
    private val userRepository = UserRepository(cursoRoomDataBase.userDao())


    init {
      insertUser()
    }
    private fun insertUser() = GlobalScope.launch{
        userRepository.insertUser(
            user = User(name = "Jesus", age = 23,mail = "jacob@gmail.com",password = "1234",autoAccept = true)
        )
    }
}
/** data/data/jacob(package del proyecto/database)*/
