package parafeJAVA;

public class ParafeBiometric {

    private boolean tunnel;
    private boolean door1;
    private boolean door2;
    private Positions positionp1;
    private Positions positionp2;

    public ParafeBiometric() {
        this.tunnel = false;
        this.door1 = false;
        this.door2 = false;
        this.positionp1 = Positions.IN_FRONT;
        this.positionp2 = Positions.IN_FRONT;
    }

    public void PERSON1SCAN(){
        if (this.positionp1 == Positions.IN_FRONT &&
                !this.tunnel &&
                !this.door1 &&
                Person.PERSON1.pass().is_pass_valid()) {
            this.positionp1 = Positions.FIRST_DOOR;
            this.door1 = true;
        }
    }

    public void PERSON1DOOR1(){
        if(this.positionp1 == Positions.FIRST_DOOR &&
                this.door1) {
            this.positionp1 = Positions.IN_TUNNEL;
            this.tunnel = true;
            this.door1 = false;
        }
    }

    public void PERSON1PASSCHECK() {
        if(this.positionp1 == Positions.IN_TUNNEL &&
                Person.PERSON1.pass().getPerson() == Person.PERSON1 && Person.PERSON1.getFingerprint() == Fingerprint.FP_EXP_PERSON1) {
            this.positionp1 = Positions.SECOND_DOOR;
            this.door2 = true;
        }
    }

    public void PERSON1DOOR2() {
        if(this.positionp1 == Positions.SECOND_DOOR &&
                this.door2){
            this.positionp1 = Positions.PASSED;
            this.tunnel = false;
            this.door2 = false;
        }
    }

    public void PERSON2SCAN(){
        if (this.positionp1 == Positions.IN_FRONT &&
                !this.tunnel &&
                !this.door1 &&
                Person.PERSON2.pass().is_pass_valid()) {
            this.positionp2 = Positions.FIRST_DOOR;
            this.door1 = true;
        }
    }

    public void PERSON2DOOR1(){
        if(this.positionp2 == Positions.FIRST_DOOR &&
                this.door1) {
            this.positionp2 = Positions.IN_TUNNEL;
            this.tunnel = true;
            this.door1 = false;
        }
    }

    public void PERSON2PASSCHECK() {
        if(this.positionp2 == Positions.IN_TUNNEL &&
                Person.PERSON2.pass().getPerson() == Person.PERSON2 && Person.PERSON2.getFingerprint() == Fingerprint.FP_EXP_PERSON2) {
            this.positionp2 = Positions.SECOND_DOOR;
            this.door2 = true;
        }
    }

    public void PERSON2DOOR2() {
        if(this.positionp2 == Positions.SECOND_DOOR &&
                this.door2){
            this.positionp2 = Positions.PASSED;
            this.tunnel = false;
            this.door2 = false;
        }
    }

    public void PERSON1SCANUNAUTHORIZED(){
        if(this.positionp1 == Positions.IN_FRONT &&
                !this.tunnel &&
                !this.door1 &&
                !Person.PERSON1.pass().is_pass_valid()) {
            this.positionp1 = Positions.UNAUTHORIZED;
        }
    }

    public void PERSON2SCANUNAUTHORIZED(){
        if(this.positionp2 == Positions.IN_FRONT &&
                !this.tunnel &&
                !this.door1 &&
                !Person.PERSON2.pass().is_pass_valid()) {
            this.positionp2 = Positions.UNAUTHORIZED;
        }
    }

    public void PERSON1PASSCHECKUNAUTHORIZED(){
        if(this.positionp1 == Positions.IN_TUNNEL &&
                (Person.PERSON1.pass().getPerson() != Person.PERSON1 || Person.PERSON1.getFingerprint() != Fingerprint.FP_EXP_PERSON1)){
            this.positionp1 = Positions.UNAUTHORIZEDSCAN;
            this.door1 = true;
        }
    }

    public void PERSON1PASSCHECKUNAUTHORIZEDOUT(){
        if(this.positionp1 == Positions.UNAUTHORIZEDSCAN &&
                this.door1){
            this.positionp1 = Positions.UNAUTHORIZED;
            this.door1 = false;
            this.tunnel = false;
        }
    }

    public void PERSON2PASSCHECKUNAUTHORIZED(){
        if(this.positionp2 == Positions.IN_TUNNEL &&
                (Person.PERSON2.pass().getPerson() != Person.PERSON2 || Person.PERSON2.getFingerprint() != Fingerprint.FP_EXP_PERSON2)){
            this.positionp2 = Positions.UNAUTHORIZEDSCAN;
            this.door1 = true;
        }
    }

    public void PERSON2PASSCHECKUNAUTHORIZEDOUT(){
        if(this.positionp2 == Positions.UNAUTHORIZEDSCAN &&
                this.door1){
            this.positionp2 = Positions.UNAUTHORIZED;
            this.door1 = false;
            this.tunnel = false;
        }
    }

}
