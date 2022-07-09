package com.wisnu.kurniawan.wallee.features.transaction.summary.ui

import androidx.lifecycle.viewModelScope
import com.wisnu.kurniawan.wallee.features.transaction.summary.data.ITransactionSummaryEnvironment
import com.wisnu.kurniawan.wallee.foundation.viewmodel.StatefulViewModel
import com.wisnu.kurniawan.wallee.model.Currency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class TransactionSummaryViewModel @Inject constructor(
    transactionSummaryEnvironment: ITransactionSummaryEnvironment,
) : StatefulViewModel<TransactionSummaryState, TransactionSummaryEffect, TransactionSummaryAction, ITransactionSummaryEnvironment>(TransactionSummaryState.initial(), transactionSummaryEnvironment) {

    init {
        viewModelScope.launch {
            val currency = Currency.INDONESIA
            val divider = 100.toBigDecimal()
            val totalExpense = 30000000L.toBigDecimal().setScale(2) / divider
            val totalIncome = 31000000L.toBigDecimal().setScale(2) / divider
            val totalAmount = totalIncome - totalExpense
            setState {
                copy(
                    cashFlow = CashFlow(
                        totalAmount = totalAmount,
                        totalExpense = totalExpense,
                        totalIncome = totalIncome,
                        currency = currency
                    )
                )
            }
        }
    }

    override fun dispatch(action: TransactionSummaryAction) {

    }

}