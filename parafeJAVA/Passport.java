package parafeJAVA;

public class Passport {

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Passport(Person person) {
        this.person = person;
    }

    public boolean is_pass_valid(){
        boolean valid = false;
        if(this.person == Person.PERSON1){
            valid =  true;
        } else if(this.person == Person.PERSON2){
            valid =  true;
        }
        return valid;
    }
}
