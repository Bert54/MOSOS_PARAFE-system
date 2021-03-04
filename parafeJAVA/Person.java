public enum Person {
    PERSON1(Passport.PASSPORT1,Fingerprint.FP_EXP_PERSON1),
    PERSON2(Passport.PASSPORT2,Fingerprint.FP_EXP_PERSON2);

    private final Passport passport;
    private final Fingerprint fingerprint;

    Person(Passport passport, Fingerprint fingerprint) {
        this.passport = passport;
        this.fingerprint = fingerprint;
    }

    public Passport pass() {
        return passport;
    }

    public Fingerprint getFingerprint() {
        return fingerprint;
    }


}
