package oncall.model;

import java.util.Objects;

public class Employee {

    private final String nickname;

    public Employee(String nickname) {
        validateName(nickname);
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(nickname, employee.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }

    private void validateName(String nickname) {
        if (nickname.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 닉네임은 공백일 수 없습니다.");
        }

        if (nickname.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 닉네임은 5자 이내로 입력해 주세요.");
        }
    }
}
