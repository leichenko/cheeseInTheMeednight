import org.testng.annotations.Test;

import static gdprCrypt.PurposeData.*;
import static gdprCrypt.Encoder.consent;

public class GetDecodeString {

    @Test
    public void withoutPurposes(){
        consent();
    }

    @Test
    public void withAllPurposes(){
        consent(allPurposes);
    }


}
