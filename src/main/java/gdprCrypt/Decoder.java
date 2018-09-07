package gdprCrypt;

import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.VendorConsentDecoder;
import java.util.Base64;


public class Decoder {



    public static final String decodeUrlbased(String decoded){
        final VendorConsent vendorConsent = VendorConsentDecoder.fromBase64String(decoded);
        return String.valueOf(vendorConsent);
    }
//
//    public static final void decodeUrlbased(String decoded){
//
//        Base64.Decoder dec = Base64.getDecoder();
//        byte[] decoded1 = dec.decode(decoded.getBytes(StandardCharsets.UTF_8));
//        System.out.println(new String(decoded1));
//    }

    public static VendorConsent decode(String consentString) {
        Base64.Decoder dec = Base64.getDecoder();
        return VendorConsentDecoder.fromByteArray(dec.decode(consentString));
    }

    public static VendorConsent testDecode(String consentString){
        VendorConsent vendorConsent = null;
        if (consentString.contains("/") || consentString.contains("+")) { //Decoder RFC4648
                      byte[] decodedConsent = Base64.getDecoder().decode(consentString);
            vendorConsent = VendorConsentDecoder.fromByteArray(decodedConsent);
                       } else { // UrlDecoder RFC4648_URLSAFE (contains "_" and "-" instead "/" and "+")
            vendorConsent = VendorConsentDecoder.fromBase64String(consentString); }
            return vendorConsent;
    }
}
