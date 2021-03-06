package gdprCrypt;

import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.implementation.v1.VendorConsentBuilder;

import java.time.Instant;
import java.util.*;

import static gdprCrypt.Constants.*;


public class Encoder {



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
        returnUrlBased(vendorConsent);
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
        returnUrlBased(vendorConsent);
    }



}
