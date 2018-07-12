package gdprCrypt;

import com.iab.gdpr.Purpose;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PurposeData {
    private static final int storage_and_accessId = Purpose.STORAGE_AND_ACCESS.getId();
    private static final int personalizationId = Purpose.PERSONALIZATION.getId();
    private static final int ad_selectionId = Purpose.AD_SELECTION.getId();
    private static final int content_deliveryId = Purpose.CONTENT_DELIVERY.getId();
    private static final int measurementId = Purpose.MEASUREMENT.getId();
    private static final int undefinedId = Purpose.UNDEFINED.getId();
    private static final int purposeInvalid = 777;
    /* эту херь для автоматики запихнуть в один сет и по нему проходить для каждого кейса
    хотя не. как раз в метод пихать тот пурпос и набор вендоров что нужен для проверки кейса
    PURPOSES DATA
     */
    public static Set<Integer> allPurposes = new HashSet<>(Arrays.asList(
            content_deliveryId,
            measurementId,
            storage_and_accessId,
            personalizationId,
            ad_selectionId));
    public Set<Integer> undefinedPurpose = new HashSet<>(Collections.singletonList(undefinedId));
    public Set<Integer> purp13only = new HashSet<>(Arrays.asList(storage_and_accessId, ad_selectionId));
    public Set<Integer> purp12only = new HashSet<>(Arrays.asList(storage_and_accessId, personalizationId));
    public Set<Integer> purp23only = new HashSet<>(Arrays.asList(personalizationId, ad_selectionId));
    public Set<Integer> noAllowedPurposes = new HashSet<>(Arrays.asList(content_deliveryId, measurementId));
    public Set<Integer> dublicatedPurposes12 = new HashSet<>(Arrays.asList(
            storage_and_accessId,
            storage_and_accessId,
            storage_and_accessId,
            content_deliveryId,
            personalizationId));
    public Set<Integer> noValid = new HashSet<>(Collections.singletonList(purposeInvalid));
    public Set<Integer> emptyPurposes = new HashSet<>();
}
