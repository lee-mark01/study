package class3.role;
import class3.policy.StaffSubmitPolicy;
import class3.policy.SubmitPolicy;

public class Staff extends Member{
    private String staffPosition;
    private SubmitPolicy submitPolicy;

    public Staff(String name, String major, int year, String part, String staffPosition){
        super(name, major, year, part);
        this.staffPosition = staffPosition;
        this.submitPolicy = new StaffSubmitPolicy();
    }

    @Override
    public String getRole(){
        return "운영진";
    }
    @Override
    public boolean canSubmit(){
        return submitPolicy.canSubmit();
    }
    @Override
    public String getSpecificInfo(){
        return "직책: " + staffPosition;
    }
}
