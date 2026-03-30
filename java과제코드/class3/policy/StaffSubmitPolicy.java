package class3.policy;
// 구현체
public class StaffSubmitPolicy implements SubmitPolicy {
    @Override
    public boolean canSubmit(){
        return false;
    }
}
