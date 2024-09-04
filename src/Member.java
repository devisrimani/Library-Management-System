public class Member extends Person {
    private String memberId;

    public Member(String name, String memberId) {
        super(name);
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }
}
