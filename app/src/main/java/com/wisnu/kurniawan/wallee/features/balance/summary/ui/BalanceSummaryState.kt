package com.wisnu.kurniawan.wallee.features.balance.summary.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.wisnu.kurniawan.wallee.R
import com.wisnu.kurniawan.wallee.foundation.extension.formatAsDisplay
import com.wisnu.kurniawan.wallee.foundation.extension.formatDateTime
import com.wisnu.kurniawan.wallee.foundation.extension.getAmountColor
import com.wisnu.kurniawan.wallee.foundation.extension.isSameDay
import com.wisnu.kurniawan.wallee.foundation.extension.isSameHour
import com.wisnu.kurniawan.wallee.foundation.extension.isSameMinute
import com.wisnu.kurniawan.wallee.foundation.extension.isYesterday
import com.wisnu.kurniawan.wallee.foundation.extension.normalize
import com.wisnu.kurniawan.wallee.foundation.wrapper.DateTimeProviderImpl
import com.wisnu.kurniawan.wallee.model.Account
import com.wisnu.kurniawan.wallee.model.Currency
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Immutable
data class BalanceSummaryState(
    val totalBalance: BigDecimal,
    val currency: Currency,
    val accountItems: List<AccountItem>
) {
    companion object {
        fun initial() = BalanceSummaryState(
            totalBalance = BigDecimal.ZERO,
            currency = Currency.INDONESIA,
            accountItems = listOf()
        )
    }
}

data class AccountItem(
    val totalTransaction: Int,
    val account: Account
)

// Collections

fun BalanceSummaryState.getTotalBalanceDisplay(): String {
    return currency.formatAsDisplay(totalBalance.normalize(), true)
}

fun BalanceSummaryState.getTotalBalanceColor(defaultColor: Color): Color {
    return totalBalance.getAmountColor(defaultColor)
}

fun Account.getTotalBalanceDisplay(): String {
    return currency.formatAsDisplay(amount.normalize(), true)
}

fun Account.getTotalBalanceColor(defaultColor: Color): Color {
    return amount.getAmountColor(defaultColor)
}

@Composable
fun Account.getDateTimeDisplay(currentDate: LocalDateTime = DateTimeProviderImpl().now()): String {
    if (updatedAt == null) return ""
    return when {
        updatedAt.isSameDay(currentDate) -> {
            when {
                updatedAt.isSameMinute(currentDate) -> {
                    stringResource(R.string.balance_account_updated_at_second)
                }
                updatedAt.isSameHour(currentDate) -> {
                    val minutes = ChronoUnit.MINUTES.between(createdAt, currentDate)
                    stringResource(R.string.balance_account_updated_at_minute, minutes.toString())
                }
                else -> {
                    val hours = ChronoUnit.HOURS.between(createdAt, currentDate)
                    stringResource(R.string.balance_account_updated_at_hour, hours.toString())
                }
            }
        }
        createdAt.isYesterday(currentDate) -> stringResource(R.string.balance_account_updated_at_date, createdAt.formatDateTime())
        else -> stringResource(R.string.balance_account_updated_at_yesterday)
    }
}
