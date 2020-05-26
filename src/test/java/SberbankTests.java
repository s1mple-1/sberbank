import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Проверка валидации при не полном заполнении форм")
public class SberbankTests extends BaseTest {
    private SberInsuranceFormData formData = new SberInsuranceFormData();

    private static SberTestPerson personFirst = new SberTestPerson("Федотов", "Федот", "Федотович",
            new SberTestPerson.SberTestPassportData("27.12.1970", "4600", "333555", "01.01.2020", "УВД Таганка"),
            new SberTestPerson.SberInsuredPerson("Fedotov", "Fedot", "27.12.1970"), true);

    private static SberTestPerson personSecond = new SberTestPerson("Смирнова", "Анна", "Федотовна",
            new SberTestPerson.SberTestPassportData("25.03.2002", "4600", "333555", "01.01.2020", "УВД Лубянка"),
            new SberTestPerson.SberInsuredPerson("Smirnova", "Anna", "25.03.2002"), false);

    private static Stream<SberTestPerson> streamPerson() {
        return Stream.of(personFirst, personSecond);
    }


    @ParameterizedTest
    @MethodSource("streamPerson")
    @DisplayName("Проверка формы 'Страхование путешественников'")
    void sberbankTest(SberTestPerson person) {
        //1
        getSite(formData.site);

        //2
        findElementAndClick(formData.insurance);

        //3
        findElementAndClick(formData.insuranceOfTravelers);

        //4
        checkElementVisibility(formData.insuranceHeaderFirst);

        //5
        findElementAndClick(formData.buttonFirst);

        //6
        findElementAndClick(formData.minChoose);

        //7
        findElementAndClick(formData.buttonSecond);

        //8
        sendTextToForm(person.getInsuredPerson().getSurName(), formData.surName);
        sendTextToForm(person.getInsuredPerson().getName(), formData.name);
        sendTextToForm(person.getInsuredPerson().getBirthDay(), formData.birthDay);
        sendTextToForm(person.getPersonLastName(), formData.personLastName);
        sendTextToForm(person.getPersonName(), formData.personName);
        sendTextToForm(person.getPersonName(), formData.personMiddleName);
        String maleXpath = person.isMale() ? formData.male : formData.female;
        findElementAndClick(maleXpath);
        sendTextToForm(person.getPassportData().getPersonBirthDate(), formData.personBirthDate);
        sendTextToForm(person.getPassportData().getPassportSeries(), formData.passportSeries);
        sendTextToForm(person.getPassportData().getPassportNumber(), formData.passportNumber);
        sendTextToForm(person.getPassportData().getPassportDate(), formData.passportDate);
        sendTextToForm(person.getPassportData().getPassportIssue(), formData.passportIssue);

        //9
        checkTextInForm(person.getInsuredPerson().getSurName(), formData.surName);
        checkTextInForm(person.getInsuredPerson().getName(), formData.name);
        checkTextInForm(person.getInsuredPerson().getBirthDay(), formData.birthDay);
        checkTextInForm(person.getPersonLastName(), formData.personLastName);
        checkTextInForm(person.getPersonName(), formData.personMiddleName);
        String checkMaleXpath = person.isMale() ? formData.maleCheck : formData.femaleCheck;
        checkElementVisibility(checkMaleXpath);
        checkTextInForm(person.getPassportData().getPersonBirthDate(), formData.personBirthDate);
        checkTextInForm(person.getPassportData().getPassportSeries(), formData.passportSeries);
        checkTextInForm(person.getPassportData().getPassportNumber(), formData.passportNumber);
        checkTextInForm(person.getPassportData().getPassportDate(), formData.passportDate);
        checkTextInForm(person.getPassportData().getPassportIssue(), formData.passportIssue);

        //10
        findElementAndClick(formData.thirdButton);

        //11
        checkElementVisibility(formData.validateHeader);
    }
}
