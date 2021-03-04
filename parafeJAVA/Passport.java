public enum Passport {
    PASSPORT1(Person.PERSON1),
    PASSPORT2(Person.PERSON2);

    private final Person person;

    public Person getPerson() {
        if(this == PASSPORT1){
            return Person.PERSON1;
        }
        else {
            return Person.PERSON2;
        }
    }

    Passport(Person person) {
        this.person = person;
    }

    public boolean is_pass_valid(){
        return (this == PASSPORT1 || this == PASSPORT2);
    }
}
