package com.example.designpatterns.behavioralpatterns.observer

// Сначала реализуем людей, ищущих работу, которых нужно уведомлять о появлении вакансий.
class JobPost(val title: String)

class JobSeeker(private val name: String) : Observer {

    override fun onJobPosted(job: JobPost) {
        // Действия при публикации новой вакансии
        println("Hi $name! New job posted: ${job.title}")
    }
}

interface Observer {
    fun onJobPosted(job: JobPost)
}

// Теперь реализуем публикации вакансий, на которые люди будут подписываться.
interface Observable {
    fun attach(observer: Observer)
    fun notify(jobPosting: JobPost)
}

class JobPostings : Observable {
    private val observers: MutableList<Observer> = mutableListOf()

    override fun attach(observer: Observer) {
        observers.add(observer)
    }

    override fun notify(jobPosting: JobPost) {
        for (observer in observers) {
            observer.onJobPosted(jobPosting)
        }
    }

    fun addJob(jobPosting: JobPost) {
        notify(jobPosting)
    }
}

fun main() {
    // Создаём подписчиков
    val johnDoe = JobSeeker("John Doe")
    val janeDoe = JobSeeker("Jane Doe")

    // Создаём публикатора и прикрепляем подписчиков
    val jobPostings = JobPostings()
    jobPostings.attach(johnDoe)
    jobPostings.attach(janeDoe)

    // Добавляем новую вакансию и смотрим, будут ли уведомлены подписчики
    val job = JobPost("Software Engineer")
    jobPostings.addJob(job)
}
