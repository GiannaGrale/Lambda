package streams;

import org.testng.Assert;

import java.util.function.Consumer;

public class PaymentActions {

    public static final Consumer<PaymentPage> freeCoupon = (p) -> p.enterPromocodeDetails("FREEUDEMY");
    public static final Consumer<PaymentPage> partialCoupon = (p) -> p.enterPromocodeDetails("PARTIALUDEMY");
    public static final Consumer<PaymentPage> validCC = (p) -> p.enterCCDetails("4111111111111111", "2024", "123");
    public static final Consumer<PaymentPage> emptyCC = (p) -> p.enterCCDetails("", "", "");
    public static final Consumer<PaymentPage> invalidCC = (p) -> p.enterCCDetails("4111111111111111", "1998", "123");
    public static final Consumer<PaymentPage> buy = (p) -> p.clickBuy();

    public static final Consumer<PaymentPage> success = (p) -> Assert.assertEquals(p.getStatus(), "PASS");
    public static final Consumer<PaymentPage> fail = (p) ->  Assert.assertEquals(p.getStatus(), "FAIL");


}
