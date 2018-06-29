import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.VendorConsentDecoder;

public class Decoder {


    public static String decorer(String decoded){
        final VendorConsent vendorConsent = VendorConsentDecoder.fromBase64String(decoded);
        return String.valueOf(vendorConsent);
    }


}
