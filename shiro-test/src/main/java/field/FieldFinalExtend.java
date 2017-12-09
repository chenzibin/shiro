package field;

public class FieldFinalExtend extends FieldFinal{

    protected final Person person;

    public FieldFinalExtend(Person person) {
        super(person);
        this.person = person;
    }
}
