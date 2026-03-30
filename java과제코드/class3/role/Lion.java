package class3.role;

import class3.policy.LionSubmitPolicy;
import class3.policy.SubmitPolicy;

public class Lion extends Member{
    private String id;
    private SubmitPolicy submitPolicy;
    public Lion(String name, String major, int year, String part, String id){
        super(name, major, year, part);
        this.id = id;
        this.submitPolicy = new LionSubmitPolicy();
    }

    @Override
    public String getRole(){
        return "아기사자";
    }
    @Override
    public boolean canSubmit(){
        return submitPolicy.canSubmit();
    }
    @Override
    public String getSpecificInfo(){
        return "학번: " + id;
    }

}
