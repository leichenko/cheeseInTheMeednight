package gdprCrypt;

import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.VendorConsentDecoder;
import com.iab.gdpr.consent.VendorConsentEncoder;
import com.iab.gdpr.consent.range.RangeEntry;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Constants {
    public static final String created = "2018-05-24T21:00:00.000Z";
    public static final String updated = "2018-05-24T21:00:00.000Z";
    public static final int cmpId = 0;
    public static final int cmpVersion = 1;
    public static final int consentScreen = 1;
    public static final String consentLanguage = "RU";
    public static final int vendorListV = 71;
    public static final int maxVendorId = 2011;
    public static final List<RangeEntry> isRange = new ArrayList<>();
    public static final int vendorIdBitString = 1;

    public static final String returnUrlBased(VendorConsent vendorConsent){
        final String base64String = VendorConsentEncoder.toBase64String(vendorConsent);
        System.out.println(base64String);
        return base64String;
    }

    public static final String returnBase64(VendorConsent vendorConsent){
     //here for Base 64 realization
        return "ololo";
    }

}
