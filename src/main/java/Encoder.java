import com.iab.gdpr.Purpose;
import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.VendorConsentEncoder;
import com.iab.gdpr.consent.implementation.v1.VendorConsentBuilder;
import com.iab.gdpr.consent.range.RangeEntry;

import java.time.Instant;
import java.util.*;

public class Encoder {
    String created = "2018-05-24T21:00:00.000Z";
    String updated = "2018-05-24T21:00:00.000Z";
    int cmpId = 0;
    int cmpVersion = 1;
    int consentScreen = 1;
    String consentLanguage = "RU";
    int vendorListV = 71;
    Set<Purpose> purposeIdBitString = new LinkedHashSet<>();
    int maxVendorId = 455;
    List<RangeEntry> isRange = new ArrayList<>();
    int vendorIdBitString = 1;
    Purpose purpose = Purpose.AD_SELECTION;


    String consent(){
        final VendorConsent vendorConsent = new VendorConsentBuilder()
                .withConsentRecordCreatedOn(Instant.parse(created))
                .withConsentRecordLastUpdatedOn(Instant.parse(updated))
                .withCmpID(cmpId)
                .withCmpVersion(cmpVersion)
                .withConsentScreenID(consentScreen)
                .withConsentLanguage(consentLanguage)
                .withVendorListVersion(vendorListV)
                .withAllowedPurposes(Collections.singleton(purpose))
                .withMaxVendorId(maxVendorId)
                .withVendorEncodingType(vendorIdBitString)
                .withDefaultConsent(false)
                .withRangeEntries(isRange)
                .build();

        final String base64String = VendorConsentEncoder.toBase64String(vendorConsent);
        return base64String;
    }


}
