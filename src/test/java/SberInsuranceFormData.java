public class SberInsuranceFormData {
    String site = "https://www.sberbank.ru/ru/person";
    String insurance = "//span[text()='Страхование']";
    String insuranceOfTravelers = "//li[@class='lg-menu__sub-item']//a[text()='Страхование путешественников']";
    String insuranceHeaderFirst = "//div[contains(@class, 'kit-col_xs_12 kit-col_md_0')]";
    //    В коде страницы присутсвует 2 заголовка 'insuranceHead' в зависимости от размерности окна. Поскольку окно maximized использую первый.
    //    String insuranceHeaderSecond = "//div[contains(@class, 'kit-col kit-col_xs_0 kit-col_md_6')]";
    String buttonFirst = "//b[text()='Оформить онлайн']";
    String minChoose = "//p[contains(text(), 'Необходимый минимум')]";
    String buttonSecond = "//button[text()='Оформить']";
    String thirdButton = "//button[contains(text(), 'Продолжить')]";
    String validateHeader = "//form//alert-form//div";

    String insuredPersonSurName = "//input[@id='surname_vzr_ins_0']";
    String insuredPersonName = "//input[@id='name_vzr_ins_0']";
    String insuredPersonBirthDay = "//input[@id='birthDate_vzr_ins_0']";

    String personLastName = "//input[@id='person_lastName']";
    String personName = "//input[@id='person_firstName']";
    String personMiddleName = "//input[@id='person_middleName']";
    String male = "//label[text()='Мужской']";
    String maleCheck = "//label[contains(@class, 'active') and contains(text(), 'Мужской')]";
    String female = "//label[text()='Женский']";
    String femaleCheck = "//label[contains(@class, 'active') and contains(text(), 'Женский')]";
    String personBirthDate = "//input[@id='person_birthDate']";
    String passportSeries = "//input[@id='passportSeries']";
    String passportNumber = "//input[@id='passportNumber']";
    String passportDate = "//input[@id='documentDate']";
    String passportIssue = "//input[@id='documentIssue']";
}
