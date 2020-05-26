public class SberTestPerson {
    private String personLastName;
    private String personName;
    private String personMiddleName;
    private SberTestPassportData passportData;
    private SberInsuredPerson insuredPerson;
    private boolean male;

    public SberTestPerson(String personLastName, String personName, String personMiddleName,
                          SberTestPassportData passportData, SberInsuredPerson insuredPerson, boolean male) {
        this.personLastName = personLastName;
        this.personName = personName;
        this.personMiddleName = personMiddleName;
        this.passportData = passportData;
        this.insuredPerson = insuredPerson;
        this.male = male;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonMiddleName() {
        return personMiddleName;
    }

    public SberTestPassportData getPassportData() {
        return passportData;
    }

    public SberInsuredPerson getInsuredPerson() {
        return insuredPerson;
    }

    public boolean isMale() {
        return male;
    }

    static class SberTestPassportData {
        String personBirthDate;
        String passportSeries;
        String passportNumber;
        String passportDate;
        String passportIssue;

        public SberTestPassportData(String personBirthDate, String passportSeries, String passportNumber, String passportDate, String passportIssue) {
            this.personBirthDate = personBirthDate;
            this.passportSeries = passportSeries;
            this.passportNumber = passportNumber;
            this.passportDate = passportDate;
            this.passportIssue = passportIssue;
        }

        public String getPersonBirthDate() {
            return personBirthDate;
        }

        public String getPassportSeries() {
            return passportSeries;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public String getPassportDate() {
            return passportDate;
        }

        public String getPassportIssue() {
            return passportIssue;
        }
    }

    static class SberInsuredPerson {
        private String surName;
        private String name;
        private String birthDay;

        public SberInsuredPerson(String surName, String name, String birthDay) {
            this.surName = surName;
            this.name = name;
            this.birthDay = birthDay;
        }

        public String getSurName() {
            return surName;
        }

        public String getName() {
            return name;
        }

        public String getBirthDay() {
            return birthDay;
        }
    }
}
