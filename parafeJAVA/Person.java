package parafeJAVA;

public enum Person {
    PERSON1,
    PERSON2;

    private Passport passport;
    private Fingerprint fingerprint;

    Person(Passport passport, Fingerprint fingerprint) {
        this.passport = passport;
        this.fingerprint = fingerprint;
    }

    Person() {

    }

    public Passport pass() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Fingerprint getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(Fingerprint fingerprint) {
        this.fingerprint = fingerprint;
    }

}
