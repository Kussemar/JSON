package dat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Account {
    private String balance;
    private boolean isActive;

    public Account(String balance, boolean isActive) {
        this.balance = balance;
        this.isActive = isActive;
    }
}
