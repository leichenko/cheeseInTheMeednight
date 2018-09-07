package gdprCrypt;

import com.iab.gdpr.consent.VendorConsent;
import com.iab.gdpr.consent.implementation.v1.VendorConsentBuilder;
import com.iab.gdpr.consent.range.RangeEntry;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import static gdprCrypt.Constants.*;
import static gdprCrypt.PurposeData.allPurposes;

public class EncodeVendors {


    static public void consentVendors0(Set<Integer> vendorIds, int maxVendorIds){
        final VendorConsent vendorConsent = new VendorConsentBuilder()
                .withConsentRecordCreatedOn(Instant.parse(created))
                .withConsentRecordLastUpdatedOn(Instant.parse(updated))
                .withCmpID(cmpId)
                .withCmpVersion(cmpVersion)
                .withConsentScreenID(consentScreen)
                .withConsentLanguage(consentLanguage)
                .withVendorListVersion(vendorListV)
                .withAllowedPurposeIds(allPurposes)
                .withMaxVendorId(maxVendorIds)
                .withVendorEncodingType(0)
                .withBitField(vendorIds)
                .build();
        returnUrlBased(vendorConsent);
    }

    static public void consentVendors1(List<RangeEntry> isRanger, int maxVendorIds){
        final VendorConsent vendorConsent = new VendorConsentBuilder()
                .withConsentRecordCreatedOn(Instant.parse(created))
                .withConsentRecordLastUpdatedOn(Instant.parse(updated))
                .withCmpID(cmpId)
                .withCmpVersion(cmpVersion)
                .withConsentScreenID(consentScreen)
                .withConsentLanguage(consentLanguage)
                .withVendorListVersion(vendorListV)
                .withAllowedPurposeIds(allPurposes)
                .withMaxVendorId(maxVendorIds)
                .withVendorEncodingType(1)
                .withRangeEntries(isRanger)
                .withDefaultConsent(true)
                .build();
        returnUrlBased(vendorConsent);
    }
}
