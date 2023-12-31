package ru.geekbrains.lesson7.observer;

public class Program {

    /**
     *  TODO: Доработать приложение, которое разрабатывалось на семинаре,
     *  поработать с шаблоном проектирования Observer,
     *  добавить новый тип соискателя.
     *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  Только после этого вы можете усложнить ваше приложение (при желании), например,
     *  добавить тип вакансии (enum),
     *  учитывать тип вакансии при отправке предложения соискателю.
     * @param args
     */
    public static void main(String[] args) {
        Student student1 = new Student("Студент");
        Master master1 = new Master("Мастер");
        Cleaner cleaning1 = new Cleaner("Уборщица");

        Publisher publisher = new JobAgency();
        publisher.registerObserver(student1);
        publisher.registerObserver(master1);
        publisher.registerObserver(cleaning1);

        Company google = new Company("Google", publisher, 120000);
        Company yandex = new Company("Yandex", publisher, 95000);
        Company geekBrains = new Company("GeekBrains", publisher, 98000);

        Vacancy expert = new Vacancy("Мастер", 150000);
        Vacancy intern = new Vacancy("Студент", 3000);
        Vacancy cleaning = new Vacancy("Уборщица", 30000);

        google.needEmployee(expert);
        yandex.needEmployee(intern);
        geekBrains.needEmployee(cleaning);
    }

}
