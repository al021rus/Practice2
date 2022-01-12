 openclassPerson(var name: String,  varbirthYear: Int ){
    var age: Int = 2021 
}
 classStudent(S_name: String, S_birthYear: Int,
              var averageGrade: Double,
              var extramural: Boolean = false):
    Person(S_name, S_birthYear) {

}
 classLecturer(L_name: String, L_birthYear: Int,
                vardegree: String,
               var experienceFrom: Int):
    Person(L_name, L_birthYear) {

}
fun main() {
    var persons = listOf(
        Student("Волкова Елизавета", 2000, 4.5),
        Student("Кузнецова Дарья", 2000, 4.4),
        Student("Ливанов Михаил", 2000, 4.2),
        Student("Владимиров Никита",2000, 3.2, true),
        Student("Умникова Диана", 2001, 3.3, true),
        Lecturer("Мещеряков Михаил Владимирович", 1972, "Кандидат физико-математических наук", 2001),
        Lecturer("Белов Владимир Фёдорович", 1952, "Доктор технических наук", 2004),
        Lecturer("Шамаев Алексей Валентинович", 1972, "Кандидат технических наук", 2006),
        Lecturer("Фирсова Светлана Анатольевна", 1972, "Кандидат физико-математических наук", 1992),
        Lecturer("Богатова Ольга Анатольевна", 1951, "Доктор социологических наук", 1996)
    )

    println("Сортировка списка Persons по возрасту в порядке убывания:")
    persons.sortByAge().forEach{println("Имя: ${it.name} | Возраст: ${it.age}")}

    println("\nСортировка Students по имени в порядке убывания:")
    var persons_S = mutableListOf<Student>()
    persons.forEach{if(it is Student) persons_S.add(it)}
    persons_S.sortByNameStudents().forEach{println("Имя: ${it.name} | Возраст: ${it.age}")}

    println("\nСортировка очников по средней оценке в порядке убывания")
    persons_S.sortByAverageGrade(true).forEach{println("Имя: ${it.name} | Возраст: ${it.averageGrade}")}

}
fun List<Person>.sortByAge(): List<Person>{

    return this.sortedByDescending{it.age}
}

fun List<Student>.sortByNameStudents(): List<Student>{

    return this.sortedByDescending{it.name}
}

fun List<Student>.sortByAverageGrade(exceptExtramural: Boolean): List<Student> {

    return if (!exceptExtramural)
        this.sortedByDescending { it.averageGrade }
    else {
        this.filter { !it.extramural }.sortedByDescending { it.averageGrade }
    }
}
