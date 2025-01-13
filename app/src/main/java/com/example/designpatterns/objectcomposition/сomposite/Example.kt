package com.example.designpatterns.objectcomposition.сomposite

// Вот разные типы сотрудников:
abstract class Employee(val name: String, val salary: Float)

class Developer(name: String, salary: Float) : Employee(name, salary)

class Designer(name: String, salary: Float) : Employee(name, salary)

class Organization {

    private val employees: MutableList<Employee> = mutableListOf()

    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    fun getNetSalaries(): Float {
        var netSalary = 0f

        employees.forEach {
            netSalary += it.salary
        }

        return netSalary
    }
}

fun main() {
    // Подготовка сотрудников
    val john = Developer("John Doe", 12000f)
    val jane = Designer("Jane Doe", 15000f)

    // Включение их в штат
    val organization = Organization()
    organization.addEmployee(john)
    organization.addEmployee(jane)

    println("Net salaries: ${organization.getNetSalaries()}")
}