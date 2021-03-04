import java.util.Scanner;

public class ParafeBiometric {

    private boolean tunnel;
    private boolean door1;
    private boolean door2;
    private Positions positionp1;
    private Positions positionp2;

    public ParafeBiometric() {
        //INITIALISATION
        this.tunnel = false;
        this.door1 = false;
        this.door2 = false;
        this.positionp1 = Positions.IN_FRONT;
        this.positionp2 = Positions.IN_FRONT;
    }

    public void execute(){
        System.out.println("\nPARAFE BIOMETRIC");

        Scanner scanner = new Scanner(System.in);

        String no = "";
        do {
            System.out.println("Saisissez le numéro de la personne qui passe en premier: 1 ou 2");
            no = scanner.next();
        } while (!no.equals("1") && !no.equals("2"));

        if(no.equals("1")) {

            //PERSON1SCAN
            if (this.positionp1 == Positions.IN_FRONT &&
                    !this.tunnel &&
                    !this.door1 &&
                    Person.PERSON1.pass().is_pass_valid()) {
                this.positionp1 = Positions.FIRST_DOOR;
                this.door1 = true;
                System.out.println("EVENT : PERSON1SCAN");
                System.out.println(this);
            }

            //PERSON1DOOR1
            if(this.positionp1 == Positions.FIRST_DOOR &&
                    this.door1) {
                this.positionp1 = Positions.IN_TUNNEL;
                this.tunnel = true;
                this.door1 = false;
                System.out.println("EVENT : PERSON1DOOR1");
                System.out.println(this);
            }

            //PERSON1PASSCHECK
            if(this.positionp1 == Positions.IN_TUNNEL &&
                    Person.PERSON1.pass().getPerson() == Person.PERSON1 && Person.PERSON1.getFingerprint() == Fingerprint.FP_EXP_PERSON1) {
                this.positionp1 = Positions.SECOND_DOOR;
                this.door2 = true;
                System.out.println("EVENT : PERSON1PASSCHECK");
                System.out.println(this);
            }

            //PERSON1DOOR2
            if(this.positionp1 == Positions.SECOND_DOOR &&
                    this.door2){
                this.positionp1 = Positions.PASSED;
                this.tunnel = false;
                this.door2 = false;
                System.out.println("EVENT : PERSON1DOOR2");
                System.out.println(this);
            }

            //PERSON1SCANUNAUTHORIZED
            if(this.positionp1 == Positions.IN_FRONT &&
                    !this.tunnel &&
                    !this.door1 &&
                    !Person.PERSON1.pass().is_pass_valid()) {
                this.positionp1 = Positions.UNAUTHORIZED;
                System.out.println("EVENT : PERSON1SCANUNAUTHORIZED");
                System.out.println(this);
            }

            //PERSON1PASSCHECKUNAUTHORIZED
            if(this.positionp1 == Positions.IN_TUNNEL &&
                    (Person.PERSON1.pass().getPerson() != Person.PERSON1 || Person.PERSON1.getFingerprint() != Fingerprint.FP_EXP_PERSON1)){
                this.positionp1 = Positions.UNAUTHORIZEDSCAN;
                this.door1 = true;
                System.out.println("EVENT : PERSON1PASSCHECKUNAUTHORIZED");
                System.out.println(this);
            }

            //PERSON1PASSCHECKUNAUTHORIZEDOUT
            if(this.positionp1 == Positions.UNAUTHORIZEDSCAN &&
                    this.door1){
                this.positionp2 = Positions.UNAUTHORIZED;
                this.door1 = false;
                this.tunnel = false;
                System.out.println("EVENT : PERSON1PASSCHECKUNAUTHORIZEDOUT");
                System.out.println(this);
            }

            //PERSON1FINGERCHECKUNAUTHORIZED
            if(Person.PERSON1.getFingerprint() != Fingerprint.FP_EXP_PERSON1 &&
                    this.positionp1 == Positions.IN_TUNNEL){
                this.positionp1 = Positions.UNAUTHORIZEDSCAN;
                this.door1 = true;
            }

        }else{

            //PERSON2SCAN
            if (this.positionp2 == Positions.IN_FRONT &&
                    !this.tunnel &&
                    !this.door1 &&
                    Person.PERSON2.pass().is_pass_valid()) {
                this.positionp2 = Positions.FIRST_DOOR;
                this.door1 = true;
                System.out.println("EVENT : PERSON2SCAN");
                System.out.println(this);
            }

            //PERSON2DOOR1
            if(this.positionp2 == Positions.FIRST_DOOR &&
                    this.door1) {
                this.positionp2 = Positions.IN_TUNNEL;
                this.tunnel = true;
                this.door1 = false;
                System.out.println("EVENT : PERSON2DOOR1");
                System.out.println(this);
            }

            //PERSON2PASSCHECK
            if(this.positionp2 == Positions.IN_TUNNEL &&
                    Person.PERSON2.pass().getPerson() == Person.PERSON2 && Person.PERSON2.getFingerprint() == Fingerprint.FP_EXP_PERSON2) {
                this.positionp2 = Positions.SECOND_DOOR;
                this.door2 = true;
                System.out.println("EVENT : PERSON2PASSCHECK");
                System.out.println(this);
            }

            //PERSON2DOOR2
            if(this.positionp2 == Positions.SECOND_DOOR &&
                    this.door2){
                this.positionp2 = Positions.PASSED;
                this.tunnel = false;
                this.door2 = false;
                System.out.println("EVENT : PERSON2DOOR2");
                System.out.println(this);
            }

            //PERSON2SCANUNAUTHORIZED
            if(this.positionp2 == Positions.IN_FRONT &&
                    !this.tunnel &&
                    !this.door1 &&
                    !Person.PERSON2.pass().is_pass_valid()) {
                this.positionp2 = Positions.UNAUTHORIZED;
                System.out.println("EVENT : PERSON2SCANUNAUTHORIZED");
                System.out.println(this);
            }

            //PERSON1PASSCHECKUNAUTHORIZED
            if(this.positionp2 == Positions.IN_TUNNEL &&
                    (Person.PERSON2.pass().getPerson() != Person.PERSON2 || Person.PERSON2.getFingerprint() != Fingerprint.FP_EXP_PERSON2)){
                this.positionp2 = Positions.UNAUTHORIZEDSCAN;
                this.door1 = true;
                System.out.println("EVENT : PERSON2PASSCHECKUNAUTHORIZED");
                System.out.println(this);
            }

            //PERSON1PASSCHECKUNAUTHORIZEDOUT
            if(this.positionp2 == Positions.UNAUTHORIZEDSCAN &&
                    this.door1){
                this.positionp2 = Positions.UNAUTHORIZED;
                this.door1 = false;
                this.tunnel = false;
                System.out.println("EVENT : PERSON2PASSCHECKUNAUTHORIZEDOUT");
                System.out.println(this);
            }

            //PERSON2FINGERCHECKUNAUTHORIZED
            if(Person.PERSON2.getFingerprint() != Fingerprint.FP_EXP_PERSON2 &&
                    this.positionp2 == Positions.IN_TUNNEL){
                this.positionp2 = Positions.UNAUTHORIZEDSCAN;
                this.door1 = true;
                System.out.println("EVENT : PERSON2FINGERCHECKUNAUTHORIZED");
                System.out.println(this);
            }
        }
    }

    @Override
    public String toString() {
        return "ParafeSystem{" +
                "tunnel=" + tunnel +
                ", door1=" + door1 +
                ", door2=" + door2 +
                ", positionp1=" + positionp1 +
                ", positionp2=" + positionp2 +
                '}';
    }
}
