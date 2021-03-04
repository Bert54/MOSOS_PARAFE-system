package parafeJAVA;

public enum Fingerprint {
    FP_EXP_PERSON1(Person.PERSON1),
    FP_EXP_PERSON2(Person.PERSON2);

    private Person person;

    Fingerprint(Person person) {
        this.person = person;
    }
}
