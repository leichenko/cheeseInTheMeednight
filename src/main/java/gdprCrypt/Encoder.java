package gdprCrypt;

import com.iab.gdpr.Purpose;
import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.VendorConsentEncoder;
import com.iab.gdpr.consent.implementation.v1.VendorConsentBuilder;
import com.iab.gdpr.consent.range.RangeEntry;

import java.time.Instant;
import java.util.*;

public class Encoder {



    static String created = "2018-05-24T21:00:00.000Z";
    static String updated = "2018-05-24T21:00:00.000Z";
    static int cmpId = 0;
    static int cmpVersion = 1;
    static int consentScreen = 1;
    static String consentLanguage = "RU";
    static int vendorListV = 71;
    static int maxVendorId = 2011;
    static List<RangeEntry> isRange = new ArrayList<>();
    static int vendorIdBitString = 1;


    static public void consent(){
        final VendorConsent vendorConsent = new VendorConsentBuilder()
                .withConsentRecordCreatedOn(Instant.parse(created))
                .withConsentRecordLastUpdatedOn(Instant.parse(updated))
                .withCmpID(cmpId)
                .withCmpVersion(cmpVersion)
                .withConsentScreenID(consentScreen)
                .withConsentLanguage(consentLanguage)
                .withVendorListVersion(vendorListV)
                .withMaxVendorId(maxVendorId)
                .withVendorEncodingType(vendorIdBitString)
                .withDefaultConsent(true)
                .withRangeEntries(isRange)
                .build();
        returner(vendorConsent);
    }

    static public void consent(Set<Integer> allowedPurposeIds){
        final VendorConsent vendorConsent = new VendorConsentBuilder()
                .withConsentRecordCreatedOn(Instant.parse(created))
                .withConsentRecordLastUpdatedOn(Instant.parse(updated))
                .withCmpID(cmpId)
                .withCmpVersion(cmpVersion)
                .withConsentScreenID(consentScreen)
                .withConsentLanguage(consentLanguage)
                .withVendorListVersion(vendorListV)
                .withAllowedPurposeIds(allowedPurposeIds)
                .withMaxVendorId(maxVendorId)
                .withVendorEncodingType(vendorIdBitString)
                .withDefaultConsent(true)
                .withRangeEntries(isRange)
                .build();
        returner(vendorConsent);
    }

    static String returner(VendorConsent vendorConsent){
        final String base64String = VendorConsentEncoder.toBase64String(vendorConsent);
        System.out.println(base64String);
        return base64String;
    }




}
