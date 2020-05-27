import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Проверка валидации при не полном заполнении форм")
public class SberbankTest extends BaseTest {
    private SberInsuranceFormData formData = new SberInsuranceFormData();

    private static SberTestPerson personFirst = new SberTestPerson("Федотов", "Федот", "Федотович",
            new SberTestPerson.SberTestPassportData("27.12.1970", "4600", "333555", "28.12.2015", "УВД Таганка"),
            new SberTestPerson.SberInsuredPerson("Fedotov", "Fedot", "27.12.1970"), true);

    private static SberTestPerson personSecond = new SberTestPerson("Смирнова", "Анна", "Федотовна",
            new SberTestPerson.SberTestPassportData("29.12.1999", "4603", "333555", "27.03.2020", "УВД Лубянка"),
            new SberTestPerson.SberInsuredPerson("Smirnova", "Anna", "29.12.1999"), false);

    private static SberTestPerson personThird = new SberTestPerson("Петров", "Иван", "Иванович",
            new SberTestPerson.SberTestPassportData("06.01.1990", "4601", "456879", "20.05.2011", "УВД Каменск-Шахтинска"),
            new SberTestPerson.SberInsuredPerson("Petrov", "Ivan", "06.01.1990"), true);

    private static Stream<SberTestPerson> streamPerson() {
        return Stream.of(personFirst, personSecond, personThird);
    }


    @ParameterizedTest
    @MethodSource("streamPerson")
    @DisplayName("Проверка формы 'Страхование путешественников'")
    void sberbankTest(SberTestPerson testPerson) {
        //1
        getSite(formData.site);

        //2
        findElementAndClick(formData.insurance);

        //3
        findElementAndClick(formData.insuranceOfTravelers);

        //4
        checkElement(formData.insuranceHeaderFirst);

        //5
        findElementAndClick(formData.buttonFirst);

        //6
        findElementAndClick(formData.minChoose);

        //7
        findElementAndClick(formData.buttonSecond);

        //8
        //insured
        sendTextToForm(testPerson.getInsuredPerson().getSurName(), formData.insuredPersonSurName);
        sendTextToForm(testPerson.getInsuredPerson().getName(), formData.insuredPersonName);
        sendTextToForm(testPerson.getInsuredPerson().getBirthDay(), formData.insuredPersonBirthDay);
        //person
        sendTextToForm(testPerson.getPersonLastName(), formData.personLastName);
        sendTextToForm(testPerson.getPersonName(), formData.personName);
        sendTextToForm(testPerson.getPersonMiddleName(), formData.personMiddleName);
        //sex
        String maleXpath = testPerson.isMale() ? formData.male : formData.female;
        findElementAndClick(maleXpath);
        //passport
        sendTextToForm(testPerson.getPassportData().getPersonBirthDate(), formData.personBirthDate);
        sendTextToForm(testPerson.getPassportData().getPassportSeries(), formData.passportSeries);
        sendTextToForm(testPerson.getPassportData().getPassportDate(), formData.passportDate);
        sendTextToForm(testPerson.getPassportData().getPassportNumber(), formData.passportNumber);
        sendTextToForm(testPerson.getPassportData().getPassportIssue(), formData.passportIssue);

        //9
        //insured
        checkTextInForm(testPerson.getInsuredPerson().getSurName(), formData.insuredPersonSurName);
        checkTextInForm(testPerson.getInsuredPerson().getName(), formData.insuredPersonName);
        checkTextInForm(testPerson.getInsuredPerson().getBirthDay(), formData.insuredPersonBirthDay);
        //person
        checkTextInForm(testPerson.getPersonLastName(), formData.personLastName);
        checkTextInForm(testPerson.getPersonName(), formData.personName);
        checkTextInForm(testPerson.getPersonMiddleName(), formData.personMiddleName);
        //sex
        String checkMaleXpath = testPerson.isMale() ? formData.maleCheck : formData.femaleCheck;
        checkElement(checkMaleXpath);
        //passport
        checkTextInForm(testPerson.getPassportData().getPersonBirthDate(), formData.personBirthDate);
        checkTextInForm(testPerson.getPassportData().getPassportSeries(), formData.passportSeries);
        checkTextInForm(testPerson.getPassportData().getPassportNumber(), formData.passportNumber);
        checkTextInForm(testPerson.getPassportData().getPassportDate(), formData.passportDate);
        checkTextInForm(testPerson.getPassportData().getPassportIssue(), formData.passportIssue);

        //10
        findElementAndClick(formData.thirdButton);

        //11
        checkElement(formData.validateHeader);
    }
}
