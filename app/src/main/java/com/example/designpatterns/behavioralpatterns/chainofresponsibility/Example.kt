package com.example.designpatterns.behavioralpatterns.chainofresponsibility

abstract class Account(
    private var balance: Int
) {
    private var successor: Account? = null

    fun setNext(account: Account) {
        this.successor = account
    }

    fun pay(amountToPay: Int) {
        if (canPay(amountToPay)) {
            println("Paid $amountToPay using ${this::class.simpleName}")
        } else if (successor != null) {
            println("Cannot pay using ${this::class.simpleName}. Proceeding ..")
            successor?.pay(amountToPay)
        } else {
            throw Exception("None of the accounts have enough balance")
        }
    }

    private fun canPay(amount: Int): Boolean {
        return balance >= amount
    }
}

class Bank(balance: Int) : Account(balance)

class Paypal(balance: Int) : Account(balance)

class Bitcoin(balance: Int) : Account(balance)

fun main() {
    /* Сделаем такую цепочку
      $bank->$paypal->$bitcoin
      Приоритет у банка
      Если банк не может оплатить, переходим к Paypal
      Если Paypal не может, переходим к Bitcoin
    */

    val bank = Bank(100)
    val paypal = Paypal(200)
    val bitcoin = Bitcoin(300)

    bank.setNext(paypal)
    paypal.setNext(bitcoin)

    bank.pay(259)
}