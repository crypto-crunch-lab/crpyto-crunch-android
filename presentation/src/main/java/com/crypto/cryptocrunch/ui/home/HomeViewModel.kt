package com.crypto.cryptocrunch.ui.home

import android.widget.CompoundButton
import com.crypto.cryptocrunch.base.BaseViewModel
import com.crypto.cryptocrunch.domain.usecase.home.GetInfoSkipUseCase
import com.crypto.cryptocrunch.domain.usecase.home.InsertInfoSkipUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val insertInfoSkipUseCase: InsertInfoSkipUseCase,
    getInfoSkipUseCase: GetInfoSkipUseCase
): BaseViewModel() {

    val startSkip = getInfoSkipUseCase.execute()

    fun skipCheckChanged(button: CompoundButton, check: Boolean){
        insertInfoSkipUseCase.execute(check)
    }
}